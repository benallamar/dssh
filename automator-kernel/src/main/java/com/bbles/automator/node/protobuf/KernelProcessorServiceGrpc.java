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
public final class KernelProcessorServiceGrpc {

  private KernelProcessorServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bbles.automator.node.protobuf.KernelProcessorService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getExecuteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter,
      com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> METHOD_EXECUTE = getExecuteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter,
      com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> getExecuteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter,
      com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> getExecuteMethod() {
    return getExecuteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter,
      com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> getExecuteMethodHelper() {
    io.grpc.MethodDescriptor<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter, com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> getExecuteMethod;
    if ((getExecuteMethod = KernelProcessorServiceGrpc.getExecuteMethod) == null) {
      synchronized (KernelProcessorServiceGrpc.class) {
        if ((getExecuteMethod = KernelProcessorServiceGrpc.getExecuteMethod) == null) {
          KernelProcessorServiceGrpc.getExecuteMethod = getExecuteMethod = 
              io.grpc.MethodDescriptor.<com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter, com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.bbles.automator.node.protobuf.KernelProcessorService", "execute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput.getDefaultInstance()))
                  .setSchemaDescriptor(new KernelProcessorServiceMethodDescriptorSupplier("execute"))
                  .build();
          }
        }
     }
     return getExecuteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KernelProcessorServiceStub newStub(io.grpc.Channel channel) {
    return new KernelProcessorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KernelProcessorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new KernelProcessorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KernelProcessorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new KernelProcessorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class KernelProcessorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void execute(com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> responseObserver) {
      asyncUnimplementedUnaryCall(getExecuteMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecuteMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter,
                com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput>(
                  this, METHODID_EXECUTE)))
          .build();
    }
  }

  /**
   */
  public static final class KernelProcessorServiceStub extends io.grpc.stub.AbstractStub<KernelProcessorServiceStub> {
    private KernelProcessorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KernelProcessorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KernelProcessorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KernelProcessorServiceStub(channel, callOptions);
    }

    /**
     */
    public void execute(com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter request,
        io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getExecuteMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KernelProcessorServiceBlockingStub extends io.grpc.stub.AbstractStub<KernelProcessorServiceBlockingStub> {
    private KernelProcessorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KernelProcessorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KernelProcessorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KernelProcessorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput> execute(
        com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter request) {
      return blockingServerStreamingCall(
          getChannel(), getExecuteMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KernelProcessorServiceFutureStub extends io.grpc.stub.AbstractStub<KernelProcessorServiceFutureStub> {
    private KernelProcessorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KernelProcessorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KernelProcessorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KernelProcessorServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXECUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KernelProcessorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KernelProcessorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE:
          serviceImpl.execute((com.bbles.automator.node.protobuf.MasterFollowerProtocol.TaskRepresenter) request,
              (io.grpc.stub.StreamObserver<com.bbles.automator.node.protobuf.ClientMasterProtocol.TaskOutput>) responseObserver);
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

  private static abstract class KernelProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KernelProcessorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bbles.automator.node.protobuf.MasterFollowerProtocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KernelProcessorService");
    }
  }

  private static final class KernelProcessorServiceFileDescriptorSupplier
      extends KernelProcessorServiceBaseDescriptorSupplier {
    KernelProcessorServiceFileDescriptorSupplier() {}
  }

  private static final class KernelProcessorServiceMethodDescriptorSupplier
      extends KernelProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KernelProcessorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (KernelProcessorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KernelProcessorServiceFileDescriptorSupplier())
              .addMethod(getExecuteMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
