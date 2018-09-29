package com.bbles.automator.client.task;


import com.bbles.automator.client.rpc.utils.ClientProtobufUtils;
import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.protobuf.GeneralProtocol;

// Describe a execution wrapper
public class TaskWrapper implements SystemCall {
  private TaskContext ctx;
  private Task tsk;
  private TaskOutput taskOutPut;

  public TaskWrapper(TaskContext ctx, Task tsk) {
    this.ctx = ctx;
    this.tsk = tsk;
  }

  public static TaskWrapper fromProtobuf(GeneralProtocol.TaskWrapper wrapper) {
    TaskContext ctx = ClientProtobufUtils.fromProtobuf(wrapper.getCtx());
    Task tsk = Task.fromProtobuf(wrapper.getTsk());
    return new TaskWrapper(ctx, tsk);
  }

  public Task getTask() {
    return tsk;
  }

  public TaskContext getContext() {
    return ctx;
  }

  @Override
  public Task getAction() {
    return tsk;
  }
}
