package com.bbles.automator.node.kernel.rpc.proxy;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.KernelConstants;
import com.bbles.automator.node.kernel.rpc.client.RPClient;
import com.bbles.automator.node.kernel.rpc.client.RPClientBuilder;
import com.bbles.automator.node.kernel.rpc.protocol.ClientMasterProtocol;
import com.bbles.automator.node.kernel.security.UserManager;
import io.grpc.stub.AbstractStub;

import java.lang.reflect.Proxy;


/**
 * A dynamic proxy to figure out which node should be contacted during the processus of lookup
 * At the begining will contact always the same node.
 *
 * @param <T>
 */
public class ClientMasterProxy<T extends ClientMasterProtocol> /* TODO: Add `extends Proxy`*/ {
    private UserManager mg;
    private RPClient<T> proxy;


    public ClientMasterProxy(Configuration config) {
        proxy = RPClientBuilder
                .newBuild()
                .withBlockingRPC(false)
                .withHost(config.get(KernelConstants.KERNEL_CLIENT_RPC_PORT, "localhost"))
                .withPort(config.get(KernelConstants.KERNEL_CLIENT_RPC_PORT, KernelConstants.DEFAULT_KERNEL_NODE_RPC_PORT))
                .build();
    }

    public RPClient<T> getProxy() {
        return proxy;
    }
}
