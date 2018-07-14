package com.bbles.automator.node.kernel.action;


import com.bbles.automator.node.kernel.OutputStreamObserver;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskContext;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.io.IOException;

/**
 * This the thread responsible for checking if the systemcall has been well answered
 */
public interface SystemCallHandler extends SystemActionHandler {

    void execute(TaskWrapper ctx, OutputStreamObserver observer) throws Exception;

}
