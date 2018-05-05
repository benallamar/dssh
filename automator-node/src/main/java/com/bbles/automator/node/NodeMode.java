package com.bbles.automator.node;

public enum NodeMode {
    MASTER("master"),
    FOLLOWER("follower");

    private final String description;

    public boolean isMaster(NodeMode mode) {
        return mode == MASTER;
    }

    public NodeMode(String mode) {
        this.description = mode;
    }

    public boolean isFollower(NodeMode mode) {
        return mode == FOLLOWER;
    }
}
