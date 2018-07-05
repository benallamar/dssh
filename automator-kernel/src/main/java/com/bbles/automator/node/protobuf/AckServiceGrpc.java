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
    comments = "Source: InterNodeProtocol.proto")
public final class AckServiceGrpc {

  private AckServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bbles.automator.node.protobuf.AckService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAckNodeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack,
      com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> METHOD_ACK_NODE = getAckNodeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack,
      com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> getAckNodeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack,
      com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> getAckNodeMethod() {
    return getAckNodeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack,
      com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> getAckNodeMethodHelper() {
    io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack, com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> getAckNodeMethod;
    if ((getAckNodeMethod = AckServiceGrpc.getAckNodeMethod) == null) {
      synchronized (AckServiceGrpc.class) {
        if ((getAckNodeMethod = AckServiceGrpc.getAckNodeMethod) == null) {
          AckServiceGrpc.getAckNodeMethod = getAckNodeMethod = 
              io.grpc.MethodDescriptor.<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack, com.bbles.automator.node.protobuf.InterNodeProtocol.Ack>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.bbles.automator.node.protobuf.AckService", "ackNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.InterNodeProtocol.Ack.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.InterNodeProtocol.Ack.getDefaultInstance()))
                  .setSchemaDescriptor(new AckServiceMethodDescriptorSupplier("ackNode"))
                  .build();
          }
        }
     }
     return getAckNodeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AckServiceStub newStub(io.grpc.Channel channel) {
    return new AckServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AckServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AckServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AckServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AckServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AckServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ackNode(com.bbles.automator.node.protobuf.InterNodeProtocol.Ack request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> responseObserver) {
      asyncUnimplementedUnaryCall(getAckNodeMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAckNodeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bbles.automator.node.protobuf.InterNodeProtocol.Ack,
                com.bbles.automator.node.protobuf.InterNodeProtocol.Ack>(
                  this, METHODID_ACK_NODE)))
          .build();
    }
  }

  /**
   */
  public static final class AckServiceStub extends io.grpc.stub.AbstractStub<AckServiceStub> {
    private AckServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AckServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AckServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AckServiceStub(channel, callOptions);
    }

    /**
     */
    public void ackNode(com.bbles.automator.node.protobuf.InterNodeProtocol.Ack request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAckNodeMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AckServiceBlockingStub extends io.grpc.stub.AbstractStub<AckServiceBlockingStub> {
    private AckServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AckServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AckServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AckServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bbles.automator.node.protobuf.InterNodeProtocol.Ack ackNode(com.bbles.automator.node.protobuf.InterNodeProtocol.Ack request) {
      return blockingUnaryCall(
          getChannel(), getAckNodeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AckServiceFutureStub extends io.grpc.stub.AbstractStub<AckServiceFutureStub> {
    private AckServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AckServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AckServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AckServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack> ackNode(
        com.bbles.automator.node.protobuf.InterNodeProtocol.Ack request) {
      return futureUnaryCall(
          getChannel().newCall(getAckNodeMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACK_NODE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACK_NODE:
          serviceImpl.ackNode((com.bbles.automator.node.protobuf.InterNodeProtocol.Ack) request,
              (io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.InterNodeProtocol.Ack>) responseObserver);
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

  private static abstract class AckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bbles.automator.node.protobuf.InterNodeProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AckService");
    }
  }

  private static final class AckServiceFileDescriptorSupplier
      extends AckServiceBaseDescriptorSupplier {
    AckServiceFileDescriptorSupplier() {}
  }

  private static final class AckServiceMethodDescriptorSupplier
      extends AckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AckServiceFileDescriptorSupplier())
              .addMethod(getAckNodeMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
