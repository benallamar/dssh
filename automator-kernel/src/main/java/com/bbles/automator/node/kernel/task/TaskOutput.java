package com.bbles.automator.node.kernel.task;

import com.bbles.automator.node.protobuf.ClientMasterProtocol;

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

    public static TaskOutput fromProtobuf(ClientMasterProtocol.TaskOutput output) {
        return new TaskOutput(output.getStdout().getOutput(), output.getErrout().getOutput());
    }
}
