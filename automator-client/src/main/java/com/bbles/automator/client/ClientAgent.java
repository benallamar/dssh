package com.bbles.automator.client;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.rpc.client.protobuf.MasterClientSideHandler;
import com.bbles.automator.node.kernel.rpc.protocol.ClientKernelProtocol;
import com.bbles.automator.node.kernel.rpc.proxy.ClientMasterProxy;


public class ClientAgent {
    private Configuration config;
    private ClientMasterProxy master;
    private ClientAgentOptions options;

    public ClientAgent(Configuration config, ClientAgentOptions options) {
        this.master = new ClientMasterProxy<>(config);
        this.config = config;
        this.options = options;
    }

    public static ClientAgent load(ClientAgentOptions options) {
        return setupShellConnection(new Configuration(), options);
    }

    /**
     * Execute the command
     */
    public void execute() {
        //  master.getProxy()
        //         .getChannel()
        //        .execute(options.getCommand(), options.getCommandArgument());
    }

    /**
     * To be used for the first step to setup all the connection.
     * It could be useful to setup every thing
     */
    public static ClientAgent setupShellConnection(Configuration configuration, ClientAgentOptions options) {
        return new ClientAgent(configuration, options);
    }
}
