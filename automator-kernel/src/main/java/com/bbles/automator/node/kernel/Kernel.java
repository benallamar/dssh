package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.executor.ProcessorHandler;
import com.bbles.automator.node.kernel.rpc.server.RPCServerHandler;
import com.bbles.automator.node.kernel.security.TokenManager;

public abstract class Kernel implements SystemCall, RPCServerHandler {
    private ProcessorHandler processorHandler;
    private TokenManager tokenManager;
    private KernelRPCServer kernelRPCServer;

    public Kernel(Configuration config) {
        this.kernelRPCServer = new KernelRPCServer(this, config);
    }

    public void start() {
        kernelRPCServer.start();
    }
}
