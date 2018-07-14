package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.kernel.security.UserGroupManager;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;

public class TaskDescriptor {
    private String taskId;
    private TaskWrapper taskWrapper;
    private UserGroupManager user;

    public TaskDescriptor(String id, TaskWrapper taskWrapper) {
        this.taskId = id;
        this.taskWrapper = taskWrapper;
    }

    public void setTaskId(String task_id) {
        this.taskId = task_id;
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

    public static ClientMasterProtocol.TaskDescriptor toProtobuf(TaskDescriptor taskDescriptor) {
        return ClientMasterProtocol
                .TaskDescriptor
                .newBuilder()
                .setTaskId(taskDescriptor.getTaskId())
                .setTaskWrapper(
                        TaskWrapper.toProtobuf(taskDescriptor.getTaskWrapper())
                ).build();

    }

    public ClientMasterProtocol.TaskDescriptor toProtobuf() {
        return TaskDescriptor.toProtobuf(this);
    }

    public static TaskDescriptor fromProtobuf(ClientMasterProtocol.TaskDescriptor td) {
        TaskWrapper tw = TaskWrapper.fromProtobuf(td.getTaskWrapper());
        return new TaskDescriptor(td.getTaskId(), tw);
    }
}
