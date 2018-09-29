package com.bbles.automator.client.task.shell;

import com.bbles.automator.client.task.Task;
import com.bbles.automator.node.utils.AutomatorUtils;

import java.io.IOException;

public class ShellTask extends Task {
    public ShellTask(String command, String[] args) {
        this.command = command;
        this.args = args;
    }

    public void execute() throws IOException {
        //TODO: To be updated
        ProcessBuilder processBuilder = new ProcessBuilder().command(AutomatorUtils.mergeStringWithAnArray(command, args));
        Process process = processBuilder.start();
    }
}
