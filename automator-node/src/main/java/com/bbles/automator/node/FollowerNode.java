package com.bbles.automator.node;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.Processor;

public class FollowerNode implements Node {
    private Processor processor;

    public FollowerNode(Configuration config) {
        this.processor = new Processor(config);
    }

    @Override
    public NodeMode mode() {
        return NodeMode.FOLLOWER;
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String version() {
        return null;
    }

    @Override
    public void shutdown() {
        processor.shutdown();
    }

    @Override
    public void start() {
        processor.start();
    }

    public static void main(String[] args) {
        Configuration config = new Configuration();
        FollowerNode follower = new FollowerNode(config);
        follower.start();
    }
}
