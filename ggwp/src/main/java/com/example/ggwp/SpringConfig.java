package com.example.ggwp;

import com.example.ggwp.repositories.user.UsersDataAccessInterface;
import com.example.ggwp.repositories.user.UsersDataServiceForRepository;
import com.example.ggwp.services.user.UsersBusinessService;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    @Bean(name = "userBusinessService")
    @RequestScope
    public UsersBusinessServiceInterface getUserBusiness() {
        return new UsersBusinessService();
    }

    @Autowired
    DataSource dataSource;
    @Bean(name = "usersDAO")
    @RequestScope
    public UsersDataAccessInterface getDataService() {
        return new UsersDataServiceForRepository(dataSource);
    }
}
