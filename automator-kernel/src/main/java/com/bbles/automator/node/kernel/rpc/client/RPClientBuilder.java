package com.bbles.automator.node.kernel.rpc.client;

import io.grpc.stub.AbstractStub;

import javax.annotation.CheckForSigned;

public class RPClientBuilder<T> {
  private int port = 9999;
  private String host;
  private Class<? extends AbstractStub> rpcHandler;
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

  @CheckForSigned
  public <S extends AbstractStub> RPClientBuilder withRPCHandler(Class<S> rpcHandler) {
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
