package io.security.corespringsecurity.security.configs;

import lombok.extern.slf4j.Slf4j;
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

    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return new MapBasedMethodSecurityMetadataSource();
    }
}
