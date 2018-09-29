package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.protobuf.ClientMasterServiceGrpc;
import com.bbles.automator.node.protobuf.GeneralProtocol;
import io.grpc.stub.StreamObserver;


/**
 * Implement the client/Master communication on both the cluster and the negotiation
 */
public final class ClientMasterServerSideHandler extends ClientMasterServiceGrpc.ClientMasterServiceImplBase implements BindableServiceWithPort {
  private SystemCallHandler serverHandler;
  private int port;

  public ClientMasterServerSideHandler(SystemCallHandler secureRPCServerHandler, int port) {
    this.serverHandler = secureRPCServerHandler;
    this.port = port;
  }

  public int getPort() {
    return port;
  }

  public void submit(GeneralProtocol.TaskWrapper request,
                     StreamObserver<GeneralProtocol.TaskDescriptor> responseObserver) {
  }
}