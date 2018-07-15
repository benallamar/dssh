package com.bbles.automator.node.kernel.task;

import java.io.File;

public class ExecutionManager {
    private ExecutionPool executionPool;

    /**
     * Get the output flow of the execution of a program
     *
     * @param descriptor
     * @return
     */
    public File getOutput(TaskDescriptor descriptor) {
        return new File("test");
    }

    /**
     * Get the error out of the execution of a program
     *
     * @param descriptor
     * @return
     */
    public File getErrorOutput(TaskDescriptor descriptor) {
        return new File("test");
    }
}
