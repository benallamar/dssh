/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.bbles.automator.client.rpc.utils;

import com.bbles.automator.client.task.TaskContext;
import com.bbles.automator.client.task.TaskOutput;
import com.bbles.automator.client.task.TaskWrapper;
import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.protobuf.GeneralProtocol;

import java.util.Iterator;

/**
 * Serialize/Deserialize java object to BinaryProtobuf objects
 */
public class ClientProtobufUtils {
  public static TaskContext fromProtobuf(GeneralProtocol.TaskContext ctx) {
    return TaskContext.newInstance(ctx.getStartDate(), ctx.getEndDate(),
        ctx.getIsScheduled(), ctx.getRetryInError(), ctx.getMaxRetry());
  }

  public static TaskDescriptor fromProtobuf(GeneralProtocol.TaskDescriptor td) {
    TaskWrapper tw = TaskWrapper.fromProtobuf(td.getTaskWrapper());
    return new TaskDescriptor(td.getTaskId(), tw);
  }

  public static TaskOutput fromProtobuf(Iterator<GeneralProtocol.TaskOutput> taskOutputIterator) {
    //TODO: Handle many taskoutputs
    return new TaskOutput(taskOutputIterator.next().getTaskId(), "", "");
  }

}
