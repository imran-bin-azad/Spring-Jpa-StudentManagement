package net.therap.service;

import net.therap.dao.LoginDao;
import net.therap.domain.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by imran.azad on 6/19/14.
 */
@Service
@Transactional
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    @Qualifier("jpaLoginDaoImpl")
    private LoginDao loginDao;

    public Login verifyLoginAndGetDetails(Login login) {
        Login verifiedLogin = loginDao.getLoginByUsername(login.getUsername());
        Boolean loginCredentialIsValid = loginMatchesVerifiedLogin(login, verifiedLogin);

        logger.debug(login.getUsername() + " -> " + verifiedLogin);

        if (loginCredentialIsValid)
            return verifiedLogin;

//        TODO: throw a custom exception instead of returning null
        return null;
    }

    private boolean loginMatchesVerifiedLogin(Login login, Login verifiedLogin) {
        boolean matches = true;
        if (verifiedLogin == null)
            matches = false;
        else if (!login.getUsername().equals(verifiedLogin.getUsername()))
            matches = false;
        else if (!login.getPassword().equals(verifiedLogin.getPassword()))
            matches = false;

        return matches;
    }
}
