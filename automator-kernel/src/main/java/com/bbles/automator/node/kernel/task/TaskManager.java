package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.config.Configuration;

import java.time.LocalDateTime;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskManager extends Thread {
  private SystemCallHandler kernel;
  private PriorityBlockingQueue<TaskDescriptor> queue;
  private Configuration config;

  public TaskDescriptor addTask(SystemCall taskWrapper) {
    String taskId = generateTaskId();
    TaskDescriptor taskDescriptor = new TaskDescriptor(taskId, taskWrapper);
    queue.add(taskDescriptor);
    return taskDescriptor;
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
  public TaskDescriptor getNextTask() {
    return queue.poll();
  }

  public int waitingTask() {
    return queue.size();
  }

  public void run() {
    while (true) {
      try {
        /**
         * We send the task sequentially (they could be managed to be done automatically)
         * TODO: What about sending the requests using many threads ? Would it be a
         * resource consuming for the resources that we have by default ?
         */
        if (waitingTask() > 0) {
          TaskDescriptor td = getNextTask();
          kernel.getProcessorManager().submit(td);
        } else {
          // We sleep waiting for other tasks to come
          Thread.sleep(2000);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String generateTaskId() {
    return LocalDateTime.now().toString();
  }
}
