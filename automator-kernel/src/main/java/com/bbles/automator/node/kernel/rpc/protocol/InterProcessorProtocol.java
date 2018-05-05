package com.bbles.automator.node.kernel.rpc.protocol;

import com.bbles.automator.node.kernel.action.SystemCallHandler;

import java.io.FileDescriptor;
import java.util.concurrent.TimeoutException;

public interface InterProcessorProtocol extends SystemCallHandler {
    public void xcopy(FileDescriptor fileDescriptor);

    /**
     * Acknowledge the other processor that I'm living
     * this will help the node to build a map of the network.
     * @throws TimeoutException
     */
    public void ack() throws TimeoutException;
}
