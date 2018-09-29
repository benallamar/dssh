package com.bbles.automator.node.kernel.rpc.protocol;


import com.bbles.automator.node.kernel.action.SystemCall;
import com.bbles.automator.node.kernel.action.SystemCallOutput;

public interface ClientMasterProtocol {

  /**
   * Submit a request to the master to be executed
   *
   * @param systemCall {@link SystemCall}
   * @throws com.bbles.automator.node.kernel.exception.task.IllegalTask
   */
  SystemCallOutput execute(SystemCall systemCall) throws Exception;
}
