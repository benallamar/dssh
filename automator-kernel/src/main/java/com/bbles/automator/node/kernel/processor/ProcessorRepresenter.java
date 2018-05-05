package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.OutputStreamObserver;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.KernelProcessorServiceGrpc;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ProcessorRepresenter {
    private Processor processor;
    private ManagedChannel channel;

    public ProcessorRepresenter(Processor processor) {
        this.processor = processor;
        this.channel = ManagedChannelBuilder.forAddress(processor.getHost(), processor.getPort()).usePlaintext(true).build();

    }

    public void execute(TaskWrapper taskWrapper, OutputStreamObserver observer) {
        //Convert TaskWrapper to : TaskContext and Task
        try {
            KernelProcessorServiceGrpc.KernelProcessorServiceStub asyncStub = KernelProcessorServiceGrpc.newStub(channel);
            Task task = taskWrapper.getTask();
            MasterFollowerProtocol.TaskRepresenter protoTaskRepresenter = MasterFollowerProtocol.TaskRepresenter.newBuilder()
                    .setTaskType(task.getType())
                    .setTask(
                            ClientMasterProtocol.Task
                                    .newBuilder()
                                    .setCommand(task.getCommand())
                                    .setArgs(String.join("", task.getArgs()))
                                    .build()
                    )
                    .build();

            asyncStub.execute(protoTaskRepresenter, new StreamObserver<ClientMasterProtocol.TaskOutput>() {
                @Override
                public void onNext(ClientMasterProtocol.TaskOutput taskOutput) {
                    observer.onNext(taskOutput);
                }

                @Override
                public void onError(Throwable throwable) {
                    observer.onError(throwable);
                }

                @Override
                public void onCompleted() {
                    observer.onCompleted();
                }
            });
        } catch (Exception o) {
            o.printStackTrace();
        }
    }
}
