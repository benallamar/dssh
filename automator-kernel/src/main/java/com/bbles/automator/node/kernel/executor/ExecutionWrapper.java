package com.bbles.automator.node.kernel.executor;


// Describe a execution wrapper
abstract public class ExecutionWrapper extends Thread {

    private String command;
    private String[] args;
    private String stdout;
    private String stderr;

    /**
     * The execution of the command
     *
     * @param command
     * @param args
     */
    abstract public ExecutionWrapper(String command, String[] args);
}
