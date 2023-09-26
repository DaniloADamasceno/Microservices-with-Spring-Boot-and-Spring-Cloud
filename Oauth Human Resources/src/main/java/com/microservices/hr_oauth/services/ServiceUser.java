package com.microservices.hr_oauth.services;

import com.microservices.hr_oauth.entities.User;
import com.microservices.hr_oauth.feighClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements UserDetailsService {

   private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);

    //?---------------------------------------  Injeção de Dependência  ------------------------------------------------
    @Autowired
    private UserFeignClient userFeignClient;


    //?--------------------------------------------   Methods   --------------------------------------------------------
    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("⚠️ ⚠️ E-mail not found / E-mail não Encontrado : ⚠️ ⚠️" + email);
            throw new IllegalArgumentException("⚠️ ⚠️Email not found ⚠️ ⚠️");
        }
        logger.info("✅ ✅Email found / E-mail Encontrado ✅ ✅: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            logger.error("⚠️ ⚠️ E-mail not found / E-mail não Encontrado : ⚠️ ⚠️" + username);
            throw new UsernameNotFoundException("⚠️ ⚠️Email not found ⚠️ ⚠️");
        }
        logger.info("✅ ✅Email found / E-mail Encontrado ✅ ✅: " + username);
        return user;
    }
}
