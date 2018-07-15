package com.bbles.automator.node.kernel.rpc.server.protobuf;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;
import com.bbles.automator.node.protobuf.ClientFollowerServiceGrpc;

public final class ClientFollowerServerSideHandler extends ClientFollowerServiceGrpc.ClientFollowerServiceImplBase implements BindableServiceWithPort {
    private InterruptHandler interruptHandler;
    private int port;

    public ClientFollowerServerSideHandler(InterruptHandler interruptHandler, int port) {
        this.interruptHandler = interruptHandler;
        this.port = port;
    }

    @Override
    public int getPort() {
        return port;
    }


}
