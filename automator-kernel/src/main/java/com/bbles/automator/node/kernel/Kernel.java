package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.action.SecurityHandler;
import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.ProcessorManager;
import com.bbles.automator.node.kernel.security.TokenManager;
import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskManager;


public class Kernel implements SystemCallHandler, InterruptHandler, SecurityHandler {
  private ProcessorManager processorManager;
  private TokenManager tokenManager;
  private KernelRPCServer kernelRPCServer;
  private TaskManager taskManager;

  public Kernel(Configuration config) {
    this.kernelRPCServer = new KernelRPCServer(this, config);
    this.taskManager = new TaskManager(this, config);
    this.processorManager = new ProcessorManager(this, config);
    this.tokenManager = new TokenManager(this, config);
  }

  @Override
  public ProcessorManager getProcessorManager() {
    return processorManager;
  }
  
  public TokenManager getTokenManager() {
    return tokenManager;
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
   * @param systemCall
   * @return
   */
  public TaskDescriptor schedule(SystemCall systemCall) {
    return taskManager.addTask(systemCall);
  }

  public static void main(String[] args) {
    Configuration config = new Configuration();
    Kernel kernel = new Kernel(config);
    kernel.start();
  }
}
