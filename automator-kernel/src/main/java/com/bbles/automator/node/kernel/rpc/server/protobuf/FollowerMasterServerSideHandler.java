package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.Kernel;
import com.bbles.automator.node.kernel.processor.ProcessorDescriptor;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.protobuf.GeneralProtocol;
import com.bbles.automator.node.protobuf.MasterFollowerProtocol;
import com.bbles.automator.node.protobuf.MasterFollowerServiceGrpc;
import io.grpc.stub.StreamObserver;

public final class FollowerMasterServerSideHandler extends MasterFollowerServiceGrpc.MasterFollowerServiceImplBase implements BindableServiceWithPort {
    private Kernel kernel;
    private int port;

    public FollowerMasterServerSideHandler(Kernel kernel, int port) {
        this.kernel = kernel;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void pullTask(GeneralProtocol.ProcessorDescriptor request, StreamObserver<GeneralProtocol.TaskDescriptor> responseObserver) {
        try {
            ProcessorDescriptor pd = kernel.getProcessorManager().getProcessorDescriptor(request.getDp());
            while (pd.hasNext()) {
                responseObserver.onNext(pd.next().toProtobuf());
            }
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }

    }
}
