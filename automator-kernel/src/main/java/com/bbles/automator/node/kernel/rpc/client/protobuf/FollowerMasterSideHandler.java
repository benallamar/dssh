package com.bbles.automator.node.kernel.rpc.client.protobuf;

import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.KernelProcessorServiceGrpc;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import io.grpc.stub.AbstractStub;
import org.apache.commons.logging.LogFactory;
import sun.rmi.runtime.Log;

public class FollowerMasterSideHandler {
    private Log logger = LogFactory.getLog(FollowerMasterSideHandler.class);
    private KernelProcessorServiceGrpc.KernelProcessorServiceBlockingStub channel;

    public TaskDescriptor submit(TaskWrapper tw) {
        try {
            ClientMasterProtocol.TaskWrapper taskWrapper = tw.toProtobuf();
            return TaskDescriptor.fromProtobuf(channel.submit(taskWrapper));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
