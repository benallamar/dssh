package com.bbles.automator.client.rpc.protobuf;

import com.bbles.automator.client.rpc.utils.ClientProtobufUtils;
import com.bbles.automator.client.task.TaskOutput;
import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.rpc.protocol.ClientMasterProtocol;
import com.bbles.automator.node.protobuf.ClientMasterServiceGrpc;
import com.bbles.automator.node.protobuf.GeneralProtocol;
import com.bbles.automator.node.utils.ProtobufUtils;

public class MasterClientSideHandler implements ClientMasterProtocol {
  private ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel;


  public MasterClientSideHandler(ClientMasterServiceGrpc.ClientMasterServiceBlockingStub channel) {
    this.channel = channel;
  }

  public TaskOutput execute(SystemCall systemCall) throws Exception {
    GeneralProtocol.Task tskProto = ProtobufUtils.toProtobuf(systemCall.getAction());
    GeneralProtocol.TaskContext ctxProto = ProtobufUtils.toProtobuf(systemCall.getContext());
    GeneralProtocol.TaskWrapper tskWrapper =
        GeneralProtocol.TaskWrapper
            .newBuilder()
            .setTsk(tskProto)
            .setCtx(ctxProto)
            .build();
    return ClientProtobufUtils.fromProtobuf(channel.execute(tskWrapper));
  }
}
