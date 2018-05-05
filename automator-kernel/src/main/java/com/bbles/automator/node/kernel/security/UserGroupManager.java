package com.bbles.automator.node.kernel.security;

import com.bbles.automator.node.kernel.config.Configuration;

import javax.security.auth.Subject;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;

public class UserGroupManager {
    private Subject subject;
    private Configuration config;

    public String[] getUserGroup(UserManager userManager) {
        return new String[]{"prod", "test"};
    }

    UserGroupManager(Subject subject, Configuration configuration) {
        this.subject = subject;
        this.config = configuration;
    }
}
