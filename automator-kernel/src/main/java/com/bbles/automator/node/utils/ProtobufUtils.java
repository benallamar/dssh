/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.bbles.automator.node.utils;

import com.bbles.automator.node.kernel.action.SystemAction;
import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.action.SystemCallContext;
import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.protobuf.GeneralProtocol;

/**
 * Serialize/Deserialize java object to BinaryProtobuf objects
 */
public class ProtobufUtils {

  public static GeneralProtocol.TaskWrapper toProtobuf(SystemCall taskWrapper) {
    return GeneralProtocol.TaskWrapper.newBuilder()
        .setTsk(toProtobuf(taskWrapper.getAction()))
        .setCtx(toProtobuf(taskWrapper.getContext()))
        .build();
  }

  public static GeneralProtocol.Task toProtobuf(SystemAction tsk) {
    return GeneralProtocol.Task.newBuilder()
        .setArgs(tsk.getArgsString())
        .setCommand(tsk.getCommand())
        .build();
  }

  public static GeneralProtocol.TaskContext toProtobuf(SystemCallContext ctx) {
    return GeneralProtocol.TaskContext.newBuilder()
        .setStartDate(ctx.getStartDateTime())
        .setEndDate(ctx.getEndDateTime())
        .setIsScheduled(ctx.isScheduled())
        .setMaxRetry(ctx.getMaxRetry())
        .setRetryInError(ctx.getRetryInError())
        .build();
  }

  public static GeneralProtocol.TaskDescriptor toProtobuf(TaskDescriptor taskDescriptor) {
    return GeneralProtocol
        .TaskDescriptor
        .newBuilder()
        .setTaskId(taskDescriptor.getTaskId())
        .setTaskWrapper(
            toProtobuf(taskDescriptor.getTaskWrapper())
        ).build();
  }

}
