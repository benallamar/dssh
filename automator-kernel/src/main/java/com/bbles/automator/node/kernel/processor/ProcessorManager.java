package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.task.TaskDescriptor;

import java.util.ArrayList;
import java.util.List;

public class ProcessorManager {
    private ArrayList<ProcessorDescriptor> processorDescriptors = new ArrayList<ProcessorDescriptor>();
    private Configuration config;
    private InterruptHandler kernel;

    // Return the list of the core executor
    public List<ProcessorDescriptor> cores() {
        return processorDescriptors;
    }

    public void subscribe(Processor processor) {
        processorDescriptors.add(new ProcessorDescriptor(processor));
    }

    public ProcessorManager(InterruptHandler kernel, Configuration config) {
        this.kernel = kernel;
        this.config = config;
    }

    public void submit(ProcessorSelector selector, TaskDescriptor td) {
        //TODO: Improve this to be parallel processing
        for (ProcessorDescriptor pd : processorDescriptors) {
            if (selector.doesMatch(pd.getProcessor())) {
                pd.submit(td.getTaskWrapper());
            }
        }
    }
}
