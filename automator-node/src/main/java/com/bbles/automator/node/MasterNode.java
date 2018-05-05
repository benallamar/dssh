package com.bbles.automator.node;

import com.bbles.automator.node.kernel.Kernel;

public class MasterNode extends Kernel implements Node {
    private NodeMode mode = NodeMode.FOLLOWER;
    private String version = "0.1.0"

    public void start() {
        super.start()
    }

    @Override
    public String info() {
        return "Automator_Master-" + version;
    }

    @Override
    public String version() {
        return version;
    }
}

