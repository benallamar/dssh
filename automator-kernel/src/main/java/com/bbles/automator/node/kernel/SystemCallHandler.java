package com.bbles.automator.node.kernel;

import com.bbles.automator.node.kernel.SystemCall;

import java.net.InetAddress;

public class SystemCallHandler implements SystemCall {
    @Override
    public String uname() {
        return System.getProperty("os.name");
    }

    @Override
    public InetAddress hostname() {
        return InetAddress.getLocalHost()
    }
}
