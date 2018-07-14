package com.bbles.automator.node.kernel.processor;

import com.bbles.automator.node.kernel.action.SystemActionHandler;
import com.bbles.automator.node.kernel.config.Configuration;

import java.net.InetAddress;

/**
 * The processors here doen't simulate the same meaning of the processors in real computer.
 * You can see them as hardware componenet (i.e block devices) that executes tasks comming
 * from the kernel.
 * <p>
 * That said, every processors receive either an execution order from the kernel, and
 * response to that execution by sending an interruption.
 */
public class Processor implements SystemActionHandler {

    private ProcessorRPCServer processorRPCServer;
    private String host;
    private int port;

    public Processor(Configuration config) {
        processorRPCServer = new ProcessorRPCServer(this, config);
    }

    public Processor() {
        this(Processor.getDefaultProcessorConfiguration());
    }

    /**
     * Processor abstract the nodes executing the command comming
     * from the client through the kernel.
     *
     * @param host
     * @param port
     */
    private Processor(InetAddress host, int port) {
        this.host = host.getCanonicalHostName();
        this.port = port;
        this.processorRPCServer = null;
    }

    /*
     *  Start the processor
     */
    public void start() {
        try {
            processorRPCServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the processor
     */

    public void shutdown() {
        try {
            processorRPCServer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the default configuration
     *
     * @return
     */
    public static Configuration getDefaultProcessorConfiguration() {
        return Configuration.getDefaultConfigurationByName(Processor.class.getSimpleName());
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}

