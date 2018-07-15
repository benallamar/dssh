package com.bbles.automator.node.kernel.rpc.protocol;


import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskWrapper;

import java.io.IOException;

public interface ClientMasterProtocol extends ClientProtocol {

    /**
     * For the time being we considere blocked execution
     *
     * @param taskWrapper
     * @throws IOException
     */
    TaskDescriptor submit(TaskWrapper taskWrapper);
}
