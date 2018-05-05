package com.bbles.automator.node.kernel.executor;

import com.bbles.automator.node.kernel.rpc.server.RPCServerHandler;

public class Processor implements RPCServerHandler {
    private ProcessorRPCServer processorRPCServer;

    public void start() {
        processorRPCServer.start();
    }
}
