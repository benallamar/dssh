package com.bbles.automator.node.kernel.action;

import com.bbles.automator.node.kernel.processor.Processor;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.util.ArrayList;

public interface ResourceHandler {
    ArrayList<Processor> getProcessors();

    /**
     * Execute a special query based on the search query
     *
     * @param query       Query to filter the node executing the command
     * @param taskWrapper Task to be executed, every node will receive a copy of the task to be executed
     *                    Either should be in memory or in database every thing will be saved (we need a persistent layer)
     */
    void execute(String query, TaskWrapper taskWrapper);
}
