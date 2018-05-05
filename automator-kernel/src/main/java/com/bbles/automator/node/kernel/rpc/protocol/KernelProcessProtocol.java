package com.bbles.automator.node.kernel.rpc.protocol;

import com.bbles.automator.node.kernel.action.InterruptHandler;
import com.bbles.automator.node.kernel.exception.processor.UnknowProcessor;
import com.bbles.automator.node.kernel.processor.Processor;

import java.io.IOException;

public interface KernelProcessProtocol extends InterruptHandler {
    void execute() throws IOException;
}
