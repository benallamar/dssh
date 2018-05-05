package com.bbles.automator.node;

import com.bbles.automator.node.kernel.executor.Processor;

public class FollwerNode extends Processor implements Node {
    private NodeMode mode = NodeMode.FOLLOWER;
}
