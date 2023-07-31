package com.example.ggwp;

import com.example.ggwp.repositories.game.GamesDataAccessInterface;
import com.example.ggwp.repositories.game.GamesDataServiceForRepository;
import com.example.ggwp.repositories.user.UsersDataAccessInterface;
import com.example.ggwp.repositories.user.UsersDataServiceForRepository;
import com.example.ggwp.services.game.GamesBusinessService;
import com.example.ggwp.services.game.GamesBusinessServiceInterface;
import com.example.ggwp.services.user.UsersBusinessService;
import com.example.ggwp.services.user.UsersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean(name = "userBusinessService")
//    @RequestScope
    public UsersBusinessServiceInterface getUserBusiness() {
        return new UsersBusinessService();
    }

    @Autowired
    DataSource dataSource;
    @Bean(name = "usersDAO")
//    @RequestScope
    public UsersDataAccessInterface getDataService() {
        return new UsersDataServiceForRepository(dataSource);
    }

    @Bean(name = "gameBusinessService")
    GamesBusinessServiceInterface getGameBusiness() {
        return new GamesBusinessService();
    }
    @Bean(name = "gamesDAO")
    public GamesDataAccessInterface getGameDataService() {
        return new GamesDataServiceForRepository(dataSource);
    }

    @Bean
    public ClassLoaderTemplateResolver secondaryTemplateResolver() {
        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
        secondaryTemplateResolver.setPrefix("templates/layouts/");
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);
        return secondaryTemplateResolver;
    }

}


