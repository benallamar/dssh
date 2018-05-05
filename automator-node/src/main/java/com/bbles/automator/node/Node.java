package com.bbles.automator.node;

/**
 * Main class
 */
public interface Node {
    public String info();

    public String version();

    public NodeMode mode();

    public void start();

    public void shutdown();
}
