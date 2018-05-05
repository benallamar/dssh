package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.ClientOutputStreamObserver;
import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.ProcessorConstants;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.kernel.rpc.server.RPCServer;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.KernelProcessorServiceGrpc;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * RPCServer for the processors (follower node)
 */
public class ProcessorRPCServer extends RPCServer {
    private int kernelRPCPort;

    public ProcessorRPCServer(Processor processor, Configuration config) {
        super(processor);
        kernelRPCPort = config.get(
                ProcessorConstants.PROCESSOR_NODE_RPC_PORT,
                ProcessorConstants.DEFAULT_PROCESSOR_NODE_RPC_PORT
        );
    }

    @Override
    public BindableServiceWithPort[] services() {
        // Return the list of the services to be used to call the users
        return new BindableServiceWithPort[]{null};
    }
}
