package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.KernelProcessorServiceGrpc;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProcessorDescriptor {
    private Processor processor;
    private PriorityQueue<TaskWrapper> taskWrappers;

    public ProcessorDescriptor(Processor processor) {
        this.processor = processor;
    }

    public void submit(TaskWrapper taskWrapper) {
        taskWrappers.add(taskWrapper);
    }

    public boolean hasNext() {
        return !taskWrappers.isEmpty();
    }

    public TaskWrapper next() {
        return taskWrappers.peek();
    }

    public Processor getProcessor() {
        return processor;
    }
}
