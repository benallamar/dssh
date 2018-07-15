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
    comments = "Source: MasterFollowerProtocol.proto")
public final class MasterFollowerServiceGrpc {

  private MasterFollowerServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bbles.automator.node.protobuf.MasterFollowerService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getPullTaskMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> METHOD_PULL_TASK = getPullTaskMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> getPullTaskMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> getPullTaskMethod() {
    return getPullTaskMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor,
      com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> getPullTaskMethodHelper() {
    io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor, com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> getPullTaskMethod;
    if ((getPullTaskMethod = MasterFollowerServiceGrpc.getPullTaskMethod) == null) {
      synchronized (MasterFollowerServiceGrpc.class) {
        if ((getPullTaskMethod = MasterFollowerServiceGrpc.getPullTaskMethod) == null) {
          MasterFollowerServiceGrpc.getPullTaskMethod = getPullTaskMethod = 
              io.grpc.MethodDescriptor.<com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor, com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.bbles.automator.node.protobuf.MasterFollowerService", "pullTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor.getDefaultInstance()))
                  .setSchemaDescriptor(new MasterFollowerServiceMethodDescriptorSupplier("pullTask"))
                  .build();
          }
        }
     }
     return getPullTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MasterFollowerServiceStub newStub(io.grpc.Channel channel) {
    return new MasterFollowerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MasterFollowerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MasterFollowerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MasterFollowerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MasterFollowerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MasterFollowerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void pullTask(com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> responseObserver) {
      asyncUnimplementedUnaryCall(getPullTaskMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPullTaskMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor,
                com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor>(
                  this, METHODID_PULL_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class MasterFollowerServiceStub extends io.grpc.stub.AbstractStub<MasterFollowerServiceStub> {
    private MasterFollowerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MasterFollowerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MasterFollowerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MasterFollowerServiceStub(channel, callOptions);
    }

    /**
     */
    public void pullTask(com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPullTaskMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MasterFollowerServiceBlockingStub extends io.grpc.stub.AbstractStub<MasterFollowerServiceBlockingStub> {
    private MasterFollowerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MasterFollowerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MasterFollowerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MasterFollowerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor pullTask(com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor request) {
      return blockingUnaryCall(
          getChannel(), getPullTaskMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MasterFollowerServiceFutureStub extends io.grpc.stub.AbstractStub<MasterFollowerServiceFutureStub> {
    private MasterFollowerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MasterFollowerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MasterFollowerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MasterFollowerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor> pullTask(
        com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor request) {
      return futureUnaryCall(
          getChannel().newCall(getPullTaskMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PULL_TASK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MasterFollowerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MasterFollowerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PULL_TASK:
          serviceImpl.pullTask((com.bbles.automator.node.protobuf.GeneralProtocol.ProcessorDescriptor) request,
              (io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.GeneralProtocol.TaskDescriptor>) responseObserver);
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

  private static abstract class MasterFollowerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MasterFollowerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bbles.automator.node.protobuf.MasterFollowerProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MasterFollowerService");
    }
  }

  private static final class MasterFollowerServiceFileDescriptorSupplier
      extends MasterFollowerServiceBaseDescriptorSupplier {
    MasterFollowerServiceFileDescriptorSupplier() {}
  }

  private static final class MasterFollowerServiceMethodDescriptorSupplier
      extends MasterFollowerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MasterFollowerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MasterFollowerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MasterFollowerServiceFileDescriptorSupplier())
              .addMethod(getPullTaskMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
