package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.ClientOutputStreamObserver;
import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.KernelProcessorServiceGrpc;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public final class KernelProcessorServiceHandler extends KernelProcessorServiceGrpc.KernelProcessorServiceImplBase implements BindableServiceWithPort {
    private InterruptHandler interruptHandler;
    private int port;

    public KernelProcessorServiceHandler(InterruptHandler interruptHandler, int port) {
        this.interruptHandler = interruptHandler;
        this.port = port;
    }

    @Override
    public int getPort() {
        return port;
    }

    /**
     */
    public void execute(MasterFollowerProtocol.TaskRepresenter request,
                        StreamObserver<ClientMasterProtocol.TaskOutput> responseObserver) {
        try {
            Class<? extends Task> classTask = Task.loadTask(request.getTaskType());
            classTask
                    .newInstance()
                    .setCommand(request.getTask().getCommand())
                    .setArgs(request.getTask().getArgs().split(" "))
                    .execute(new ClientOutputStreamObserver<ClientMasterProtocol.TaskOutput>(responseObserver));
        } catch (InstantiationException e) {
            responseObserver.onError(e);
        } catch (IllegalAccessException e) {
            responseObserver.onError(e);
        } catch (IOException e) {
            responseObserver.onError(e);
        }

    }

}
