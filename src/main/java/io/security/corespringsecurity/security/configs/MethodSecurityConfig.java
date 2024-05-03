package io.security.corespringsecurity.security.configs;

import io.security.corespringsecurity.security.factory.MethodResourcesFactoryBean;
import io.security.corespringsecurity.service.SecurityResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) -> DB를 참조하므로 false
@Configuration
@EnableGlobalMethodSecurity
@Slf4j
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private SecurityResourceService securityResourceService;

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return mapBasedMethodSecurityMetadataSource();
    }

    @Bean
    public MapBasedMethodSecurityMetadataSource mapBasedMethodSecurityMetadataSource() {
        return new MapBasedMethodSecurityMetadataSource(methodResourcesFactoryBean().getObject());
    }

    @Bean
    public MethodResourcesFactoryBean methodResourcesFactoryBean() {
        MethodResourcesFactoryBean methodResourcesFactoryBean = new MethodResourcesFactoryBean();
        methodResourcesFactoryBean.setSecurityResourceService(securityResourceService);
//        methodResourcesFactoryBean.setResourceType("method");
        return methodResourcesFactoryBean;
    }
}
