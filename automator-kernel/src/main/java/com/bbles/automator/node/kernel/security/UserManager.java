package com.bbles.automator.node.kernel.security;

import javax.security.auth.login.LoginContext;

public abstract class UserManager {
    /**
     * Get the current login user:
     * -> Password/Unix
     * -> Kerberos (Cache)
     *
     * @param krb_token
     * @return
     */
    public abstract UserManager getLoginUser(byte[] krb_token);

    /**
     * Login the user from the keytab
     *
     * @return
     */
    public abstract UserManager logetFromKeytab();

    /**
     * Get the list of the user's group
     *
     * @param user
     * @return
     */
    public abstract UserGroupManager getUserGroup(UserManager user);
}
