package net.therap.dao;

import net.therap.domain.Login;

/**
 * Created by imran.azad on 6/19/14.
 */
public interface LoginDao {
    public Login getLoginByUsername(String username);
}
