package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.processor.ProcessorSelector;
import com.bbles.automator.node.kernel.security.UserGroupManager;
import com.bbles.automator.node.protobuf.GeneralProtocol;

public class TaskDescriptor {
    private ProcessorSelector selector;
    private String taskId;
    private TaskWrapper taskWrapper;
    private UserGroupManager user;

    public TaskDescriptor(String id, TaskWrapper taskWrapper) {
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

    public void setTaskWrapper(TaskWrapper taskWrapper) {
        this.taskWrapper = taskWrapper;
    }

    public String getTaskId() {
        return taskId;
    }

    public TaskWrapper getTaskWrapper() {
        return taskWrapper;
    }

    public static GeneralProtocol.TaskDescriptor toProtobuf(TaskDescriptor taskDescriptor) {
        return GeneralProtocol
                .TaskDescriptor
                .newBuilder()
                .setTaskId(taskDescriptor.getTaskId())
                .setTaskWrapper(
                        TaskWrapper.toProtobuf(taskDescriptor.getTaskWrapper())
                ).build();

    }

    public GeneralProtocol.TaskDescriptor toProtobuf() {
        return TaskDescriptor.toProtobuf(this);
    }

    public static TaskDescriptor fromProtobuf(GeneralProtocol.TaskDescriptor td) {
        TaskWrapper tw = TaskWrapper.fromProtobuf(td.getTaskWrapper());
        return new TaskDescriptor(td.getTaskId(), tw);
    }
}
