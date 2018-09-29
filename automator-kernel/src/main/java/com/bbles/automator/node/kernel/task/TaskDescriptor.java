/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.processor.ProcessorSelector;
import com.bbles.automator.node.kernel.security.UserGroupManager;
import com.bbles.automator.node.protobuf.GeneralProtocol;
import com.bbles.automator.node.utils.ProtobufUtils;

public class TaskDescriptor {
  private ProcessorSelector selector;
  private String taskId;
  private SystemCall taskWrapper;
  private UserGroupManager user;

  public TaskDescriptor(String id, SystemCall taskWrapper) {
    this.taskId = id;
    this.taskWrapper = taskWrapper;
    this.selector = new ProcessorSelector();
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public ProcessorSelector getSelector() {
    return selector;
  }

  public void setTaskWrapper(SystemCall taskWrapper) {
    this.taskWrapper = taskWrapper;
  }

  public String getTaskId() {
    return taskId;
  }

  public SystemCall getTaskWrapper() {
    return taskWrapper;
  }


  public GeneralProtocol.TaskDescriptor toProtobuf() {
    return ProtobufUtils.toProtobuf(this);
  }
}
