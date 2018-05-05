package com.bbles.automator.node.kernel.security;

import com.bbles.automator.node.kernel.action.SecurityHandler;
import com.bbles.automator.node.kernel.config.Configuration;

public class TokenManager {
    private TokenGenerator tokenGenerator;
    private SecurityHandler securityHandler;

    public TokenManager(SecurityHandler securityHandler, Configuration config) {
        this.tokenGenerator = TokenGenerator.getInstance(config);
        this.securityHandler = securityHandler;
    }

    public boolean tokenIsValid(Token token) {
        //TODO: Check if the given token is valid
        return true;
    }
}
