package com.plano.saude.cadastro.beneficiario.service.domain.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;


    public RecoveryJwtTokenDto authenticateUsuario(LoginUsuarioDto loginUserDto) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.senha());


        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);


        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }


    public void createUsuario(CriarUsuarioDto criarUsuarioDto) {


        UsuarioEntity newUser = UsuarioEntity.builder()
                .email(criarUsuarioDto.email())

                .password(securityConfiguration.passwordEncoder().encode(criarUsuarioDto.senha()))

                .roles(List.of(RoleEntity.builder().name(criarUsuarioDto.role()).build()))
                .build();


        usuarioRepository.save(newUser);
    }
}