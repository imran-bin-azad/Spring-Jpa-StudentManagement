package net.therap.dao.jpa;

import net.therap.domain.Login;
import net.therap.dao.LoginDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by imran.azad on 6/19/14.
 */
@Repository
@Qualifier("jpaLoginRepositoryImpl")
public class JpaLoginDaoImpl implements LoginDao {
    Logger logger = LoggerFactory.getLogger(JpaLoginDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Login getLoginByUsername(String username) {
        Login login = entityManager.find(Login.class, username);

        logger.debug(username + " contains " + login);

        if (login == null) {
//            TODO: throw a custom exception instead of returning null
            return null;
        }
        return login;
    }
}
