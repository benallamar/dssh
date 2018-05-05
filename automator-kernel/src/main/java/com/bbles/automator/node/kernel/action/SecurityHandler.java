package com.bbles.automator.node.kernel.action;

import com.bbles.automator.node.kernel.security.UserGroupManager;

public interface SecurityHandler extends SystemActionHandler {
    /**
     * Authenticate the current user and do all the operations
     * with the name of the current user
     *
     * @return
     */
    public UserGroupManager authenticate();
}
