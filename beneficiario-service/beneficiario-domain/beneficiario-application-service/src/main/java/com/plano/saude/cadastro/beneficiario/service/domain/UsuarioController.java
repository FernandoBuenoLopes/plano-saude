package com.plano.saude.cadastro.beneficiario.service.domain;

import com.plano.saude.cadastro.beneficiario.service.domain.auth.CriarUsuarioDto;
import com.plano.saude.cadastro.beneficiario.service.domain.auth.LoginUsuarioDto;
import com.plano.saude.cadastro.beneficiario.service.domain.auth.RecoveryJwtTokenDto;
import com.plano.saude.cadastro.beneficiario.service.domain.auth.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUsuario(@RequestBody LoginUsuarioDto loginUsuarioDto) {
        RecoveryJwtTokenDto token = usuarioService.authenticateUsuario(loginUsuarioDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> createUsuario(@RequestBody CriarUsuarioDto criarUsuarioDto) {
        usuarioService.createUsuario(criarUsuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}