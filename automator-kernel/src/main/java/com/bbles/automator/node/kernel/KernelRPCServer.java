package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.NodeConfigurationConstants;
import com.bbles.automator.node.kernel.rpc.server.RPCServer;

public class KernelRPCServer extends RPCServer {
    private Kernel kernel;
    private Configuration config;

    public KernelRPCServer(Kernel kernel, Configuration config) {
        super(
                config.get(
                        NodeConfigurationConstants.NODE_KERNEL_RPC_PORT,
                        NodeConfigurationConstants.DEFAULT_KERNEL_NODE_RPC_PORT
                ),
                this
        );
        this.kernel = kernel;
        this.config = config;
    }
}
