package com.bbles.automator.node.kernel.rpc.proxy;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.KernelConstants;
import com.bbles.automator.node.kernel.rpc.client.RPClient;
import com.bbles.automator.node.kernel.rpc.client.RPClientBuilder;
import com.bbles.automator.node.kernel.security.UserManager;

import java.lang.reflect.Proxy;


/**
 * A dynamic proxy to figure out which node should be contacted during the processus of lookup
 * At the begining will contact always the same node.
 *
 * @param <T>
 */
public class ClientMasterProxy<T> extends Proxy {
    private UserManager mg;
    private RPClient<T> proxy;


    public ClientMasterProxy(Configuration config) {
        proxy = RPClientBuilder
                .newBuild()
                .withBlockingRPC(false)
                .withHost(config.get(KernelConstants.KERNEL_CLIENT_RPC_PORT))
                .withPort(config.get(KernelConstants.KERNEL_CLIENT_RPC_PORT))
                .withRPCHandler(T.class)
                .build();
    }

    public RPClient<T> getProxy() {
        return proxy;
    }
}
