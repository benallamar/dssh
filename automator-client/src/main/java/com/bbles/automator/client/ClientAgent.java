package com.bbles.automator.client;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.rpc.client.protobuf.MasterClientSideHandler;
import com.bbles.automator.node.kernel.rpc.proxy.ClientMasterProxy;
import com.bbles.automator.node.kernel.task.TaskDescriptor;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import org.apache.commons.cli.ParseException;


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
    public TaskDescriptor submit(TaskWrapper taskWrapper) {
        return new TaskDescriptor("", null);
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
        try {
            ClientAgentOptions options = new ClientAgentOptions(args);

            Configuration config;
            if (options.getConfigDir() != null) {
                config = new Configuration(options.getConfigDir());
            } else {
                config = new Configuration();
            }

            TaskWrapper taskWrapper = options.getTaskWrapper();
            // Instantiate the client
            ClientAgent client = new ClientAgent(config, options);

            // Execute the command
            client.submit(taskWrapper);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
