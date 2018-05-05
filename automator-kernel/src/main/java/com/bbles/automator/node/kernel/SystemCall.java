package com.bbles.automator.node.kernel;

public interface SystemCall {
    /**
     * Return the response of uname command
     */
    public String uname();


    /**
     * Return the reponse of hostname -f
     */
    public String hostname();
}
