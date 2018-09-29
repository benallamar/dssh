/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.bbles.automator.node.kernel.action;

/**
 * Give more description about the task that should be executed
 * <p>
 * Time, duration, ...
 */
public interface SystemCallContext {

  String getStartDateTime();


  String getEndDateTime();


  boolean isScheduled();

  boolean getRetryInError();

  int getMaxRetry();
}
