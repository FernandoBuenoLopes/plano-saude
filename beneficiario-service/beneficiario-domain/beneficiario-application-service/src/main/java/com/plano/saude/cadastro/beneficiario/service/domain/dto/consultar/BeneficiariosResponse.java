package com.plano.saude.cadastro.beneficiario.service.domain.dto.consultar;

import com.sistema.saude.cadastro.beneficiario.service.domain.entity.Beneficiario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BeneficiariosResponse {
    @NotNull
    private final List<Beneficiario> beneficiarios;
}