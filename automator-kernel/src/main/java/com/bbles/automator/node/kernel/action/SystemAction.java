package com.bbles.automator.node.kernel.action;

/**
 * This interface represents every systems action that may (or not) induce
 * a fallback action.
 * A system action could be :
 * - SystemCall from the client to the kernel (handled by SystemCallHandler)
 * - An Execution Order from the kernel to the processors (handled by ExecutionHandler)
 * - An Interrupt Action from the processors to the kernel. (handler by InterruptHandler)
 */
public interface SystemAction {

  String getCommand();


  String getType();

  String[] getArgs();

  String getArgsString();

}
