package com.bbles.automator.node.kernel.action;


import com.bbles.automator.node.kernel.processor.ProcessorManager;
import com.bbles.automator.node.kernel.task.TaskDescriptor;

/**
 * This the thread responsible for checking if the systemcall has been well answered
 */
public interface SystemCallHandler extends SystemActionHandler {


    TaskDescriptor schedule(SystemCall ctx) throws Exception;

    ProcessorManager getProcessorManager();
}
