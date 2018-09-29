package com.bbles.automator.node;

/**
 * Main class
 */
public interface Node {
  String info();

  String version();

  NodeMode mode();

  void start();

  void shutdown();
}
