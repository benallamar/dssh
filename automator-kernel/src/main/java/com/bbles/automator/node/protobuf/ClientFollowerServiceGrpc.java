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
    comments = "Source: ClientFollowerProtocol.proto")
public final class ClientFollowerServiceGrpc {

  private ClientFollowerServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bbles.automator.node.protobuf.ClientFollowerService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStatusMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> METHOD_GET_STATUS = getGetStatusMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> getGetStatusMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> getGetStatusMethod() {
    return getGetStatusMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> getGetStatusMethodHelper() {
    io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor, com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> getGetStatusMethod;
    if ((getGetStatusMethod = ClientFollowerServiceGrpc.getGetStatusMethod) == null) {
      synchronized (ClientFollowerServiceGrpc.class) {
        if ((getGetStatusMethod = ClientFollowerServiceGrpc.getGetStatusMethod) == null) {
          ClientFollowerServiceGrpc.getGetStatusMethod = getGetStatusMethod = 
              io.grpc.MethodDescriptor.<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor, com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.bbles.automator.node.protobuf.ClientFollowerService", "getStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientFollowerServiceMethodDescriptorSupplier("getStatus"))
                  .build();
          }
        }
     }
     return getGetStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientFollowerServiceStub newStub(io.grpc.Channel channel) {
    return new ClientFollowerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientFollowerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientFollowerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientFollowerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientFollowerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientFollowerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getStatus(com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatusMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStatusMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor,
                com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus>(
                  this, METHODID_GET_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class ClientFollowerServiceStub extends io.grpc.stub.AbstractStub<ClientFollowerServiceStub> {
    private ClientFollowerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientFollowerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientFollowerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientFollowerServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStatus(com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatusMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientFollowerServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientFollowerServiceBlockingStub> {
    private ClientFollowerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientFollowerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientFollowerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientFollowerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus getStatus(com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor request) {
      return blockingUnaryCall(
          getChannel(), getGetStatusMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientFollowerServiceFutureStub extends io.grpc.stub.AbstractStub<ClientFollowerServiceFutureStub> {
    private ClientFollowerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientFollowerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientFollowerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientFollowerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus> getStatus(
        com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatusMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientFollowerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientFollowerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STATUS:
          serviceImpl.getStatus((com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor) request,
              (io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskStatus>) responseObserver);
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

  private static abstract class ClientFollowerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientFollowerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bbles.automator.node.protobuf.ClientFollowerProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientFollowerService");
    }
  }

  private static final class ClientFollowerServiceFileDescriptorSupplier
      extends ClientFollowerServiceBaseDescriptorSupplier {
    ClientFollowerServiceFileDescriptorSupplier() {}
  }

  private static final class ClientFollowerServiceMethodDescriptorSupplier
      extends ClientFollowerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientFollowerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientFollowerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientFollowerServiceFileDescriptorSupplier())
              .addMethod(getGetStatusMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
