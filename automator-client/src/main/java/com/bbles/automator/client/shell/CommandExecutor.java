package com.bbles.automator.client.shell;

import com.bbles.automator.client.ClientAgent;
import com.bbles.automator.client.ClientAgentOptions;

public class CommandExecutor {
    public static ClientAgentOptions parseCommandOptions(String[] args) {
        return null;
    }

    public static void main(String[] args) {
        // Get the parsed options from the output
        ClientAgentOptions options = CommandExecutor.parseCommandOptions(args);

        // Instantiate the client
        ClientAgent client = ClientAgent.load(options);

        // Execute the command
        client.execute();
    }
}
