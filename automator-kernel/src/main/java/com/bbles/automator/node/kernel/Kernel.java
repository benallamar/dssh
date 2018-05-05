package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.action.SecurityHandler;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.ProcessorManager;
import com.bbles.automator.node.kernel.security.TokenManager;
import com.bbles.automator.node.kernel.security.UserGroupManager;
import com.bbles.automator.node.kernel.task.TaskManager;
import com.bbles.automator.node.kernel.task.TaskWrapper;

public class Kernel implements SystemCallHandler, SecurityHandler, InterruptHandler {
    private ProcessorManager processorManager;
    private TokenManager tokenManager;
    private KernelRPCServer kernelRPCServer;
    private TaskManager taskManager;

    public Kernel(Configuration config) {
        this.kernelRPCServer = new KernelRPCServer(this, config);
        this.tokenManager = new TokenManager(this, config);
        this.processorManager = new ProcessorManager(this, config);
        this.taskManager = new TaskManager(this, config);
    }

    /**
     * Start the serveur
     */
    public void start() {
        try {
            kernelRPCServer.start();
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

    public void execute(TaskWrapper taskWrapper, OutputStreamObserver observer) throws Exception {
        //TODO: Could we get stream inforamtion from this output (to be handled in safe mode)
        processorManager.execute(taskWrapper, observer);
    }


    public void execute(TaskWrapper taskWrapper) {
        taskManager.addTask(taskWrapper);
    }

    public UserGroupManager authenticate() {
        return null;
    }

    public ProcessorManager getProcessorManager() {
        return processorManager;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public TokenManager getTokenManager() {
        return tokenManager;
    }
}
