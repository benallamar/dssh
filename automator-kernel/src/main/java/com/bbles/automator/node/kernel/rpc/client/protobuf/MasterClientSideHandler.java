package com.bbles.automator.node.kernel.rpc.client.protobuf;

import com.bbles.automator.node.kernel.rpc.protocol.ClientMasterProtocol;
import com.bbles.automator.node.kernel.task.*;
import com.bbles.automator.node.protobuf.ClientMasterServiceGrpc;
import com.bbles.automator.node.protobuf.GeneralProtocol;

public class MasterClientSideHandler implements ClientMasterProtocol {
    private ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel;


    public MasterClientSideHandler(ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel) {
        this.channel = channel;
    }

    public TaskDescriptor submit(TaskWrapper taskWrapper) {
        try {
            GeneralProtocol.Task tskProto = Task.toProtobuf(taskWrapper.getTask());
            GeneralProtocol.TaskContext ctxProto = TaskContext.toProtobuf(taskWrapper.getContext());
            GeneralProtocol.TaskWrapper tskWrapper =
                    GeneralProtocol.TaskWrapper
                            .newBuilder()
                            .setTsk(tskProto)
                            .setCtx(ctxProto)
                            .build();
            return TaskDescriptor.fromProtobuf(channel.submit(tskWrapper));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
