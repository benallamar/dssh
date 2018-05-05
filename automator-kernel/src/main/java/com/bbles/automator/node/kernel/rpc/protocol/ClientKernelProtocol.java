package com.bbles.automator.node.kernel.rpc.protocol;


import com.bbles.automator.node.kernel.action.SystemCallHandler;
import com.bbles.automator.node.kernel.task.TaskOutput;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.io.IOException;

public interface ClientKernelProtocol extends SystemCallHandler {

    /**
     * For the time being we considere blocked execution
     *
     * @param taskWrapper
     * @throws IOException
     */
    TaskOutput execute(TaskWrapper taskWrapper) throws IOException;
}
