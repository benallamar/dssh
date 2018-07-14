package com.bbles.automator.node.kernel.task.shell;

import com.bbles.automator.node.kernel.OutputStreamObserver;
import com.bbles.automator.node.kernel.task.Task;
import com.bbles.automator.node.utils.AutomatorUtils;

import java.io.IOException;

public class ShellTask extends Task {
    public ShellTask(String command, String[] args) {
        this.command = command;
        this.args = args;
    }

    public void execute(OutputStreamObserver outPutStream) throws IOException {
        //TODO: To be updated
        ProcessBuilder processBuilder = new ProcessBuilder().command(AutomatorUtils.mergeStringWithAnArray(command, args));
        Process process = processBuilder.start();
        while (process.isAlive()) {
            outPutStream.onNext(process.getInputStream().read());
        }
    }
}
