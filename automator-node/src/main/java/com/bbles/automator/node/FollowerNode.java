package com.bbles.automator.node;

import com.bbles.automator.node.kernel.config.Configuration;
import com.bbles.automator.node.kernel.processor.Processor;

public class FollowerNode extends Pro implements Node {
    private NodeMode mode = NodeMode.FOLLOWER;

    public static void main(String[] args) {
        FollowerNode follower = new FollowerNode();
        follower.start();
    }
}
