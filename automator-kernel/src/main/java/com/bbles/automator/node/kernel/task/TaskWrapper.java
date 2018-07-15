package com.bbles.automator.node.kernel.task;


import com.bbles.automator.node.protobuf.GeneralProtocol;

// Describe a execution wrapper
public class TaskWrapper extends Thread {
    private TaskContext ctx;
    private Task tsk;
    private TaskOutput taskOutPut;

    public TaskWrapper(TaskContext ctx, Task tsk) {
        this.ctx = ctx;
        this.tsk = tsk;
    }

    public static TaskWrapper fromProtobuf(GeneralProtocol.TaskWrapper wrapper) {
        TaskContext ctx = TaskContext.fromProtobuf(wrapper.getCtx());
        Task tsk = Task.fromProtobuf(wrapper.getTsk());
        return new TaskWrapper(ctx, tsk);
    }

    public Task getTask() {
        return tsk;
    }

    public TaskContext getContext() {
        return ctx;
    }

    /**
     * Get a protobuf-base serialized task wrapper from the native taskwrapper
     *
     * @param taskWrapper
     * @return
     */
    public static GeneralProtocol.TaskWrapper toProtobuf(TaskWrapper taskWrapper) {
        return GeneralProtocol.TaskWrapper.newBuilder()
                .setTsk(Task.toProtobuf(taskWrapper.getTask()))
                .setCtx(TaskContext.toProtobuf(taskWrapper.getContext()))
                .build();
    }

    public GeneralProtocol.TaskWrapper toProtobuf() {
        return TaskWrapper.toProtobuf(this);
    }
}
