package com.bbles.automator.node.kernel.task;


import com.bbles.automator.node.kernel.OutputStreamObserver;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;

import java.io.IOException;

// Describe a execution wrapper
public class TaskWrapper extends Thread {
    private TaskContext ctx;
    private Task tsk;
    private TaskOutput taskOutPut;

    public TaskWrapper(TaskContext ctx, Task tsk) {
        this.ctx = ctx;
        this.tsk = tsk;
    }

    public void execute(OutputStreamObserver kernelOutPutStream) throws IOException {
        //TODO: Check the TaskContext for more correct information
        tsk.execute(kernelOutPutStream);
    }

    public static TaskWrapper fromProtobuf(ClientMasterProtocol.TaskWrapper wrapper) {
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


    public TaskOutput getTaskOutPut() {
        return TaskOutput;
    }


    /**
     * Get a protobuf-base serialized task wrapper from the native taskwrapper
     *
     * @param taskWrapper
     * @return
     */
    public static ClientMasterProtocol.TaskWrapper toProtobuf(TaskWrapper taskWrapper) {
        return ClientMasterProtocol.TaskWrapper.newBuilder()
                .setTsk(Task.toProtobuf(taskWrapper.getTask()))
                .setCtx(TaskContext.fromProtobuf(taskWrapper.getContext()))
                .build();
    }
}
