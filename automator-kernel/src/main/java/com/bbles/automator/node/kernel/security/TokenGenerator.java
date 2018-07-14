package com.bbles.automator.node.kernel.security;

import com.bbles.automator.node.kernel.config.Configuration;

/**
 * Class for generating tokens.
 * when sending the token through the wire, it should be encrypted by the kerberos shared secret
 */
public class TokenGenerator {
    private Configuration config;

    public static TokenGenerator getInstance(Configuration config) {
        return new TokenGenerator(config);
    }

    public TokenGenerator(Configuration config) {
        //TODO: Do something with the configuraiton
        this.config = config;
    }
}
