package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.OutputStreamObserver;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.util.ArrayList;
import java.util.List;

public class ProcessorManager {
    private ArrayList<ProcessorRepresenter> processors = new ArrayList<ProcessorRepresenter>();
    private Configuration config;

    // Return the list of the core executor
    public List<ProcessorRepresenter> cores() {
        return processors;
    }

    public void execute(TaskWrapper taskWrapper, OutputStreamObserver observer) throws Exception {
        taskWrapper.execute(observer);
    }

    public void subscribe(Processor processor) {
        processors.add(new ProcessorRepresenter(processor));
    }

}
