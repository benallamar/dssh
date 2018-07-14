package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.kernel.task.*;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.ClientMasterServiceGrpc;
import io.grpc.stub.StreamObserver;


/**
 * Implement the client/Master communication on both the cluster and the negotiation
 */
public final class ClientMasterServerSideHandler extends ClientMasterServiceGrpc.ClientMasterServiceImplBase implements BindableServiceWithPort {
    private SystemCallHandler serverHandler;
    private int port;

    public ClientMasterServerSideHandler(SystemCallHandler secureRPCServerHandler, int port) {
        this.serverHandler = secureRPCServerHandler;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void submit(ClientMasterProtocol.TaskWrapper request,
                       StreamObserver<ClientMasterProtocol.TaskDescriptor> responseObserver) {
        try {
            ClientMasterProtocol.TaskContext protoTaskContext = request.getCtx();
            TaskContext ctx = TaskContextBuilder
                    .newBuild()
                    .withStartDate(protoTaskContext.getStartDate())
                    .withEndDate(protoTaskContext.getEndDate())
                    .isScheduled(protoTaskContext.getIsScheduled())
                    .retryInError(protoTaskContext.getRetryInError())
                    .withMaxRetry(protoTaskContext.getMaxRetry())
                    .build();
            ClientMasterProtocol.Task protoTask = request.getTsk();
            Task tsk = Task
                    .loadTask(request.getTskDescriptor())
                    .newInstance()
                    .setCommand(protoTask.getCommand())
                    .setArgs(protoTask.getArgs().split(" "));
            TaskWrapper taskWrapper = new TaskWrapper(ctx, tsk);
            TaskDescriptor taskDescriptor = serverHandler.schedule(taskWrapper);
            /**
             * The client has already a version of the taskwrapper
             * all he needs is only a task id to track his jobs
             */
            taskDescriptor.setTaskWrapper(null);
            responseObserver.onNext(taskDescriptor.toProtobuf());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

}