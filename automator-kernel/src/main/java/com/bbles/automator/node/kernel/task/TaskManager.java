package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskManager extends Thread {
    private SystemCallHandler kernel;
    private PriorityBlockingQueue<TaskWrapper> queue;
    private Configuration config;

    public void addTask(TaskWrapper taskWrapper) {
        queue.add(taskWrapper);
    }


    public TaskManager(SystemCallHandler kernel, Configuration config) {
        this.config = config;
        this.kernel = kernel;
        //TODO: Is it the safe way to implement this ? a question to be asked to make sure !
        this.queue = new PriorityBlockingQueue<>();
    }

    /**
     * Get the first element to be handled and executed
     *
     * @return
     */
    public TaskWrapper getTaskWrapper() {
        return queue.poll();
    }


    public void run() {
        while (true) {
            try {
                TaskWrapper tskWrapper = getTaskWrapper();
                kernel.execute(tskWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
