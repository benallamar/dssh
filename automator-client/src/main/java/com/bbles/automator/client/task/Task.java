package com.bbles.automator.client.task;

import com.bbles.automator.client.task.shell.ShellTask;
import com.bbles.automator.node.kernel.action.SystemAction;
import com.bbles.automator.node.protobuf.GeneralProtocol;

public abstract class Task implements SystemAction {

  /**
   * Construct a class from protobuf protocol
   *
   * @param tsk
   */
  public static <T extends Task> T fromProtobuf(GeneralProtocol.Task tsk) {
    Class<? extends Task> klass = Task.loadTask(tsk.getType());
    try {
      return (T) klass.getConstructor(String.class, String[].class)
          .newInstance(tsk.getCommand(), tsk.getArgs().split(" "));
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } finally {
      return null;
    }
  }

  protected String command;
  protected String[] args;
  protected String type = getClass().getName().toLowerCase();

  public String getCommand() {
    return command;
  }


  public String getType() {
    return type;
  }

  public String[] getArgs() {
    return args;
  }

  public String getArgsString() {
    StringBuilder sb = new StringBuilder();
    for (String s : args) {
      sb.append(s);
    }
    return sb.toString();
  }

  /**
   * Load the appropriate task based on the task type to be used.
   * <p>
   * #TODO: Is it the best way to do class loading ? A question to be answered later
   * If you need type task you only need to implement one and added it to this class
   * </p>
   *
   * @param taskType The task type
   * @return
   */
  public static Class<? extends Task> loadTask(String taskType) {
    switch (taskType) {
      case "shell":
        return ShellTask.class;
      default:
        throw new IllegalArgumentException("The task type " + taskType + " doesn't exist");
    }
  }

  public static GeneralProtocol.Task toProtobuf(Task tsk) {
    return GeneralProtocol.Task.newBuilder()
        .setArgs(tsk.getArgsString())
        .setCommand(tsk.getCommand())
        .build();
  }

}
