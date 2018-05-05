package com.bbles.automator.node.kernel.rpc.proxy;

import com.bbles.automator.node.kernel.rpc.client.RPClient;
import com.bbles.automator.node.kernel.rpc.client.protobuf.FollowerMasterSideHandler;
import com.bbles.automator.node.kernel.task.TaskOutput;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;

import java.util.Iterator;

public class MasterFollowerProxy {
    private RPClient<FollowerMasterSideHandler> follower;

    private Iterator<TaskOutput> execute(TaskWrapper taskWrapper) {
        /**
         * How to do many connections at the sametime for the same groups ?
         * Launching containers ?
         * Should they get what they have to do
         * Get the data from the cluster to get the result of the server
         */
        ClientMasterProtocol.TaskWrapper taskWrapper1 = TaskWrapper.toProtobuf(taskWrapper);
        //follower.getChannel().execute(taskWrapper);
        return null;
    }
}
