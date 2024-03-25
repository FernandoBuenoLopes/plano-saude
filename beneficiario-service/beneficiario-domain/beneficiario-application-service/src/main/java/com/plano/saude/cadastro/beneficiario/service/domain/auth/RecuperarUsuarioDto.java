package com.plano.saude.cadastro.beneficiario.service.domain.auth;

import java.util.List;

public record RecuperarUsuarioDto(

        Long id,
        String email,
        List<RoleEntity> roles

) {
}