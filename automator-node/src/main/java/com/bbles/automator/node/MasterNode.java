package com.bbles.automator.node;


import com.bbles.automator.node.kernel.Kernel;
import com.bbles.automator.node.kernel.config.Configuration;

public class MasterNode implements Node {
    private Kernel kernel;
    private NodeMode mode = NodeMode.FOLLOWER;
    private String version = "0.1.0";

    public MasterNode() {
        kernel = new Kernel(new Configuration());
    }

    @Override
    public String info() {
        return "Automator Master \n Version: " + version;
    }

    @Override
    public String version() {
        return version;
    }

    @Override
    public NodeMode mode() {
        return mode;
    }

    @Override
    public void start() {
        kernel.start();
    }


    @Override
    public void shutdown() {
        try {
            kernel.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MasterNode master = new MasterNode();
        master.start();
    }
}

