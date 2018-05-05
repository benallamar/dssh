package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.action.SystemCallHandler;

import java.util.PriorityQueue;

public class TaskManager extends Thread {
    private SystemCallHandler kernel;
    private PriorityQueue<TaskWrapper> queue;

    public addTask(TaskWrapper taskWrapper) {
        queue.add(taskWrapper);
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
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
