package com.bbles.automator.node.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: ClientMasterProtocol.proto")
public final class ClientMasterServiceGrpc {

  private ClientMasterServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bbles.automator.node.protobuf.ClientMasterService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExecuteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> METHOD_EXECUTE = getExecuteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> getExecuteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> getExecuteMethod() {
    return getExecuteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> getExecuteMethodHelper() {
    io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper, com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> getExecuteMethod;
    if ((getExecuteMethod = ClientMasterServiceGrpc.getExecuteMethod) == null) {
      synchronized (ClientMasterServiceGrpc.class) {
        if ((getExecuteMethod = ClientMasterServiceGrpc.getExecuteMethod) == null) {
          ClientMasterServiceGrpc.getExecuteMethod = getExecuteMethod = 
              io.grpc.MethodDescriptor.<com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper, com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.bbles.automator.node.protobuf.ClientMasterService", "execute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientMasterServiceMethodDescriptorSupplier("execute"))
                  .build();
          }
        }
     }
     return getExecuteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientMasterServiceStub newStub(io.grpc.Channel channel) {
    return new ClientMasterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientMasterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientMasterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientMasterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientMasterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientMasterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void execute(com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecuteMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper,
                com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput>(
                  this, METHODID_EXECUTE)))
          .build();
    }
  }

  /**
   */
  public static final class ClientMasterServiceStub extends io.grpc.stub.AbstractStub<ClientMasterServiceStub> {
    private ClientMasterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientMasterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientMasterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientMasterServiceStub(channel, callOptions);
    }

    /**
     */
    public void execute(com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExecuteMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientMasterServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientMasterServiceBlockingStub> {
    private ClientMasterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientMasterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientMasterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientMasterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput> execute(
        com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper request) {
      return blockingServerStreamingCall(
          getChannel(), getExecuteMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientMasterServiceFutureStub extends io.grpc.stub.AbstractStub<ClientMasterServiceFutureStub> {
    private ClientMasterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientMasterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientMasterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientMasterServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXECUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientMasterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientMasterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE:
          serviceImpl.execute((com.bbles.automator.node.protobuf.GeneralProtocol.TaskWrapper) request,
              (io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskOutput>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClientMasterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientMasterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bbles.automator.node.protobuf.ClientMasterProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientMasterService");
    }
  }

  private static final class ClientMasterServiceFileDescriptorSupplier
      extends ClientMasterServiceBaseDescriptorSupplier {
    ClientMasterServiceFileDescriptorSupplier() {}
  }

  private static final class ClientMasterServiceMethodDescriptorSupplier
      extends ClientMasterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientMasterServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClientMasterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientMasterServiceFileDescriptorSupplier())
              .addMethod(getExecuteMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
