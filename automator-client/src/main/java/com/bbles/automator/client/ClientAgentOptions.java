package com.bbles.automator.client;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.task.TaskContext;
import com.bbles.automator.node.kernel.task.TaskContextBuilder;
import com.bbles.automator.node.kernel.task.TaskWrapper;
import com.bbles.automator.node.kernel.task.shell.ShellTask;
import com.sun.deploy.util.ArgumentParsingUtil;
import net.source
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.MissingFormatArgumentException;

public class ClientAgentOptions {
    private String command;
    private String[] args;
    private String startDate;
    private String endDate;
    private String context;

    public ClientAgentOptions(String[] argvs) {
        Options options = new Options();
        options.addOption("--command", "Command to be executed")
                .addOption("--context", "Add task context");
        CommandLine cli = new DefaultParser().parse(options, argvs);
        if (cli.hasOption("command")) {
            String[] targs = cli.getOptionValue("command").split(" ");
            this.command = targs[0];
            this.args = Arrays.copyOfRange(targs, 1, targs.length() - 1);
        } else {
            throw new MissingFormatArgumentException("The command is missing");
        }
        if (cli.hasOption("context")) {
            this.context = cli.getOptionValue("context");
        }
        if (cli.hasOption("startDate")) {
            this.endDate = cli.getOptionValue("startDate");
        }
        if (cli.hasOption("endDate")) {
            this.endDate = cli.getOptionValue("endDate");
        }
    }

    private String getCommand() {
        return command;
    }


    private String[] getCommandArgument() {
        return args;
    }


    //TODO: Parse argument lines to get the task wrapper
    public TaskWrapper getTaskWrapper() {
        TaskContext context = TaskContextBuilder.newBuild()
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();
        return new TaskWrapper(new ShellTask(getCommand(), getCommandArgument()), context);
    }

    //TODO: Check the properties of the jvm if there any path to where the configuration has been saved
    public String getConfigPath() {
        return System.getProperty("automator.config.dir");
    }
}
