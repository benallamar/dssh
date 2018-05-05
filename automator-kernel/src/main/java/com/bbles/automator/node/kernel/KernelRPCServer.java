package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.config.KernelConstants;
import com.bbles.automator.node.kernel.rpc.server.protobuf.ClientMasterServerSideHandler;
import com.bbles.automator.node.kernel.rpc.server.protobuf.KernelProcessorServiceHandler;
import com.bbles.automator.node.kernel.rpc.server.RPCServer;
import com.bbles.automator.node.kernel.rpc.server.BindableServiceWithPort;


/**
 * RPCServer for the kernel (master node)
 */
public class KernelRPCServer extends RPCServer {
    private Configuration config;
    private Kernel kernel;
    private int clientRpcPort;
    private int processorRpcPort;


    /**
     * Generate the RPC servers that should be launched
     *
     * @return
     */
    @Override
    public BindableServiceWithPort[] services() {
        return new BindableServiceWithPort[]{new ClientMasterServerSideHandler(kernel, clientRpcPort), new KernelProcessorServiceHandler(kernel, processorRpcPort)};
    }

    /**
     * Instantiate the RPC server
     *
     * @param kernel
     * @param config
     */
    public KernelRPCServer(Kernel kernel, Configuration config) {
        super(kernel);
        this.config = config;
        this.kernel = kernel;
        this.processorRpcPort = config.get(KernelConstants.NODE_KERNEL_RPC_PORT, KernelConstants.DEFAULT_KERNEL_NODE_RPC_PORT);
        this.clientRpcPort = config.get(KernelConstants.KERNEL_CLIENT_RPC_PORT, KernelConstants.DEFAULT_KERNEL_CLIENT_RPC_PORT);
        /**
         * Configure the server to be started
         */
        init();
    }
}
