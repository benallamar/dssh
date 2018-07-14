package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.ProcessorConstants;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.kernel.rpc.server.RPCServer;

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
