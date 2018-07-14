package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.ProcessorManager;
import com.bbles.automator.node.kernel.security.TokenManager;
import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskManager;
import com.bbles.automator.node.kernel.task.TaskWrapper;


public class Kernel implements SystemCallHandler, InterruptHandler {
    private ProcessorManager processorManager;
    private TokenManager tokenManager;
    private KernelRPCServer kernelRPCServer;
    private TaskManager taskManager;

    public Kernel(Configuration config) {
        this.kernelRPCServer = new KernelRPCServer(this, config);
        this.taskManager = new TaskManager(this, config);
    }

    /**
     * Start the serveur
     */
    public void start() {
        try {
            kernelRPCServer.start();
            taskManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void shutdown() {
        try {
            kernelRPCServer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Send the task to the scheduler who will make best effort to execute
     * the task in respect to the context given within the task
     *
     * @param taskWrapper
     * @return
     */
    public TaskDescriptor schedule(TaskWrapper taskWrapper) {
        return taskManager.addTask(taskWrapper);
    }

    public static void main(String[] args){
        Configuration config = new Configuration();
        Kernel kernel = new Kernel(config);
        kernel.start();
    }
}
