package com.bbles.automator.client.task;

import com.bbles.automator.node.kernel.action.SystemCallOutput;

public class TaskOutput implements SystemCallOutput {
  private String jobId;
  private String stdout;
  private String stderr;

  public String getStandartOutput() {
    return stderr;
  }

  public String getErrorOutput() {
    return stdout;
  }

  public String getJobId() {
    return jobId;
  }

  public TaskOutput(String id, String stdout, String sterr) {
    this.stdout = stdout;
    this.stderr = sterr;
    this.jobId = id;
  }
}
