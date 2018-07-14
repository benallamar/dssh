package com.bbles.automator.client;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.rpc.client.protobuf.MasterClientSideHandler;
import com.bbles.automator.node.kernel.rpc.proxy.ClientMasterProxy;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.kernel.task.TaskWrapper;


public class ClientAgent {
    private Configuration config;
    private ClientMasterProxy<MasterClientSideHandler> master;
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
    public void submit(TaskWrapper taskWrapper) {
        master.getProxy().getChannel().submit(taskWrapper);
    }

    /**
     * To be used for the first step to setup all the connection.
     * It could be useful to setup every thing
     */
    public static ClientAgent setupShellConnection(Configuration configuration, ClientAgentOptions options) {
        return new ClientAgent(configuration, options);
    }

    public static void main(String[] args) {
        // Get the parsed options from the output
        ClientAgentOptions options = new ClientAgentOptions(args);

        Configuration config = null;
        if (options.getConfigPath() != null) {
            config = new Configuration(options.getConfigPath());
        } else {
            config = new Configuration();
        }


        TaskWrapper taskWrapper = options.getTaskWrapper();
        // Instantiate the client
        ClientAgent client = new ClientAgent(config, options);

        // Execute the command
        client.submit(taskWrapper);
    }
}
