package com.plano.saude.cadastro.beneficiario.service.domain.auth;

public record CriarUsuarioDto(

        String email,
        String senha,
        NomeRole role

) {
}