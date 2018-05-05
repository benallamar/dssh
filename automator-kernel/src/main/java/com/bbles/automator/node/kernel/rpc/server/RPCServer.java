package com.bbles.automator.node.kernel.rpc.server;

import com.bbles.automator.node.Node;
import com.bbles.automator.node.protobuf.AckServiceGrpc;
import com.bbles.automator.node.protobuf.ClientNodeProtocol;
import com.bbles.automator.node.protobuf.ClientNodeServiceGrpc;
import com.bbles.automator.node.protobuf.NodeProtocol;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class RPCServer {
    private RPCServerHandler rpcServerHandler;
    private Server nodeServer;
    private Server clientServer;

    /**
     * Create a RouteGuide server using serverBuilder as a base and features as data.
     */
    public RPCServer getInstance(int port) {
        return new RPCServer(ServerBuilder.forPort(port), port)
    }

    private RPCServer(ServerBuilder<?> nodeServerBuilder, ServerBuilder clientServerBuilder, int port) {
        this.port = port;
        this.nodeServer = nodeServerBuilder.addService(new NodeRPCHandler()).build();
        this.clientServer = clientServerBuilder.addService(new ClientRPCHandler()).build();
    }

    private int port;

    public RPCServer(int port, RPCServerHandler commander) {
        this.port = port;
        this.rpcServerHandler = commander;
    }

    /**
     * Inter node RPC Handler
     * Handles the request comming from the nodes
     */
    private class NodeRPCHandler extends AckServiceGrpc.AckServiceImplBase {
        private Node commander;

        @Override
        public void ackNode(NodeProtocol.Ack request, StreamObserver<NodeProtocol.Ack> observer) {
            if (commander.checkSecret(request.getSecretBytes().toByteArray()))
                observer.onNext(
                        NodeProtocol.Ack
                                .newBuilder()
                                .setSecret("FuckYou")
                                .build()
                );

        }
    }

    /**
     * Client RPC Handler.
     * This classes handles the request comming from the client
     */
    private class ClientRPCHandler extends ClientNodeServiceGrpc.ClientNodeServiceImplBase {
        private Node commander;

        @Override
        public void hello(ClientNodeProtocol.Hello request, StreamObserver<ClientNodeProtocol.HelloResponse> observer) {
            if (commander.)
                observer.onNext(
                        ClientNodeProtocol.HelloResponse
                                .newBuilder()
                                .setHost(commander.uname())
                                .setName(commander.info())
                                .build()
                );

        }
    }


    public void start() {
        try {
            clientServer.start();
            nodeServer.start()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
