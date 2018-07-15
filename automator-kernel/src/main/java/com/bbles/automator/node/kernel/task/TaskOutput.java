package com.bbles.automator.node.kernel.task;

public class TaskOutput {
    private String stdout;
    private String stderr;

    public String getStderr() {
        return stderr;
    }

    public String getStdout() {
        return stdout;
    }

    private TaskOutput(String stdout, String sterr) {
        this.stdout = stdout;
        this.stderr = sterr;
    }
}
