package com.bbles.automator.node.kernel.rpc.server;

import com.bbles.automator.node.kernel.action.SystemAction;
import com.bbles.automator.node.kernel.action.SystemActionHandler;
import com.bbles.automator.node.kernel.action.SystemCallHandler;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class RPCServer {
    protected Log logger = LogFactory.getLog(RPCServer.class);

    protected SystemActionHandler systemCallHandler;
    private ArrayList<Server> servers;


    /**
     * This return the list of the services that should be handled by the current
     * RPC services (gives more freedem to the instantiator of server)
     *
     * @return an array of the bindable service
     * every service is binded to a given port.
     */
    public abstract BindableServiceWithPort[] services();

    public RPCServer(SystemCallHandler systemCallHandler) {
        this.systemCallHandler = systemCallHandler;
    }

    protected void init() {
        for (BindableServiceWithPort service : services()) {
            logger.info("Add the RPC server handler " + service.getClass().getSimpleName());
            this.servers.add(ServerBuilder
                    .forPort(service.getPort())
                    .addService(service)
                    .build());
        }
    }

    public void start() throws IOException {
        servers.stream().parallel().forEach((server) -> {
            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void shutdown() {
        try {
            servers.stream().parallel().forEach((server) -> server.shutdown());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
