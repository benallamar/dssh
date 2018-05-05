package com.bbles.automator.node.kernel.rpc.client;

import io.grpc.stub.AbstractStub;

public class RPClientBuilder<T extends AbstractStub> {
    private int port = 9999;
    private String host;
    private Class<T> rpcHandler;
    private boolean blockinRPC = true;

    public static RPClientBuilder newBuild() {
        return new RPClientBuilder();
    }

    public RPClientBuilder withHost(String host) {
        this.host = host;
        return this;
    }

    public RPClientBuilder withPort(int port) {
        this.port = port;
        return this;
    }

    public RPClientBuilder withRPCHandler(Class<T> rpcHandler) {
        this.rpcHandler = rpcHandler;
        return this;
    }

    public RPClientBuilder withBlockingRPC(boolean blockingRPC) {
        this.blockinRPC = blockingRPC;
        return this;
    }

    // We could set the configuration for other purposes

    public RPClient<T> build() {
        return new RPClient<T>(host, port, rpcHandler, blockinRPC);
    }
}
