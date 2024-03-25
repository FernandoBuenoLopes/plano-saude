package com.plano.saude.cadastro.beneficiario.service.domain.ports.output.repository;

import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository {
    List<Beneficiario> listar();
    Beneficiario salvar(Beneficiario beneficiario);

    Beneficiario atualizar(Beneficiario beneficiario);

    Beneficiario remover(Beneficiario beneficiario);
}
