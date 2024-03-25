package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioEntityId implements Serializable {
    private UUID id;
    private BeneficiarioEntity beneficiario;
}
