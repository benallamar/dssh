package com.bbles.automator.node.kernel.rpc.client.protobuf;

import com.bbles.automator.node.kernel.task.*;
import com.bbles.automator.node.protobuf.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.ClientMasterServiceGrpc;

import java.util.Iterator;

public class MasterClientSideHandler {
    private ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel;


    public MasterClientSideHandler(ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel) {
        this.channel = channel;
    }

    /**
     * Collect a stream of data from the output
     *
     * @param output
     * @param taskWrapper TaskWrapper that holds all the information about the task to be executed
     */
    public void submit(TaskWrapper taskWrapper) {
        try {
            ClientMasterProtocol.Task tskProto = Task.toProtobuf(taskWrapper.getTask());
            ClientMasterProtocol.TaskContext ctxProto = TaskContext.toProtobuf(taskWrapper.getContext());
            ClientMasterProtocol.TaskWrapper tskWrapper =
                    ClientMasterProtocol.TaskWrapper
                            .newBuilder()
                            .setTsk(tskProto)
                            .setCtx(ctxProto)
                            .build();
            Iterator<ClientMasterProtocol.TaskOutput> outputs = channel.execute(tskWrapper);
            while (outputs.hasNext()) {
                TaskOutput.fromProtobuf(outputs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
