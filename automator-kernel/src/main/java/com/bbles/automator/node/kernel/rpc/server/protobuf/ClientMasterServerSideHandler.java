package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.ClientOutputStreamObserver;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskContext;
import com.bbles.automator.node.kernel.task.TaskContextBuilder;
import com.bbles.automator.node.kernel.task.TaskWrapper;
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

    public void execute(ClientMasterProtocol.TaskWrapper request,
                        StreamObserver<ClientMasterProtocol.TaskOutput> responseObserver) {
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
            serverHandler.execute(taskWrapper, new ClientOutputStreamObserver<ClientMasterProtocol.TaskOutput>(responseObserver));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

}