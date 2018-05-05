package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.action.SecurityHandler;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.ProcessorManager;
import com.bbles.automator.node.kernel.security.Token;
import com.bbles.automator.node.kernel.security.TokenManager;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.io.IOException;

public class Kernel implements SystemCallHandler, SecurityHandler, InterruptHandler {
    private ProcessorManager processorManager;
    private TokenManager tokenManager;
    private KernelRPCServer kernelRPCServer;

    public Kernel(Configuration config) {
        this.kernelRPCServer = new KernelRPCServer(this, config);
        this.tokenManager = new TokenManager(this, config);
        this.processorManager = new ProcessorManager(this, config);
    }

    /**
     * Start the serveur
     */
    public void start() {
        kernelRPCServer.start();
    }

    public boolean tokenIsValid(Token token) {
        try {
            this.tokenManager.tokenIsValid(token);
            return true;
        } finally {
            return false;
        }
    }

    public void execute(TaskWrapper taskWrapper, OutputStreamObserver observer) throws IOException {
        processorManager.execute(taskWrapper, observer);
    }
}
