package com.bbles.automator.node.kernel.security;

import com.bbles.automator.node.kernel.action.SecurityHandler;
import com.bbles.automator.node.kernel.config.Configuration;

public class TokenManager {
    private SecurityHandler kernel;
    private TokenGenerator tokenGenerator;
    private Configuration config;


    public TokenManager(SecurityHandler kernel, Configuration config) {
        this.kernel = kernel;
        this.tokenGenerator = TokenGenerator.getInstance(config);
        this.config = config;
    }
}
