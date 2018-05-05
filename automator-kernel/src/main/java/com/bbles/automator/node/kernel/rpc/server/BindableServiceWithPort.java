package com.bbles.automator.node.kernel.rpc.server;

import io.grpc.BindableService;

public interface BindableServiceWithPort extends BindableService {
    /**
     * Get the caracterestic port for the service
     * We're using FaireQueue per service to avoid impact between the services
     *
     * @return
     */
    int getPort();
}

