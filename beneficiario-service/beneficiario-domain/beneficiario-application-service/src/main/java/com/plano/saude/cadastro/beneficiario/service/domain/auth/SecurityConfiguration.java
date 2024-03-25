package com.plano.saude.cadastro.beneficiario.service.domain.auth;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UsuarioAuthenticationFilter usuarioAuthenticationFilter;

    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
            "/usuario/login",
            "/usuario/criar",
            "/swagger-ui.html",
            "/swagger-ui/index.html",
            "/v2/api-docs",
            "/swagger-resources/*",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/*",
            "/v3/api-docs/*",
            "/swagger-ui/*",
            "/v3/api-docs/swagger-config/*",
            "/v3/api-docs"
    };


    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_REQUIRED = {
            "/beneficiario/listar"
    };


    public static final String [] ENDPOINTS_ATENDENTE = {
            "/beneficiario/atualizar",
            "/beneficiario/documentos"
    };


    public static final String [] ENDPOINTS_FINANCEIRO = {
            "/beneficiario/criar",
            "/beneficiario/remover/*"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).permitAll()
                .requestMatchers(ENDPOINTS_WITH_AUTHENTICATION_REQUIRED).authenticated()
                .requestMatchers(ENDPOINTS_FINANCEIRO).hasAuthority("ROLE_FINANCEIRO")
                .requestMatchers(ENDPOINTS_ATENDENTE).hasAuthority("ROLE_ATENDENTE")
                .anyRequest().denyAll()

                .and().addFilterBefore(usuarioAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("My REST API")
                        .description("Plano de saúde - beneficiários")
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}