package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.util.PriorityQueue;

public class ProcessorDescriptor {
    private Processor processor;
    private PriorityQueue<TaskDescriptor> taskDescriptors;

    public ProcessorDescriptor(Processor processor) {
        this.processor = processor;
    }

    public void submit(TaskDescriptor taskWrapper) {
        taskDescriptors.add(taskWrapper);
    }

    public boolean hasNext() {
        return !taskDescriptors.isEmpty();
    }

    public TaskDescriptor next() {
        return taskDescriptors.peek();
    }

    public Processor getProcessor() {
        return processor;
    }
}
