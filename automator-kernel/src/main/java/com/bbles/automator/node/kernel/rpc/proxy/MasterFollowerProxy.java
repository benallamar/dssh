package com.bbles.automator.node.kernel.rpc.proxy;

import com.bbles.automator.node.kernel.task.TaskOutput;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.protobuf.GeneralProtocol;

import java.util.Iterator;

public class MasterFollowerProxy {
    private Iterator<TaskOutput> execute(TaskWrapper taskWrapper) {
        /**
         * How to do many connections at the sametime for the same groups ?
         * Launching containers ?
         * Should they get what they have to do
         * Get the data from the cluster to get the result of the server
         */
        GeneralProtocol.TaskWrapper taskWrapper1 = TaskWrapper.toProtobuf(taskWrapper);
        return null;
    }
}
