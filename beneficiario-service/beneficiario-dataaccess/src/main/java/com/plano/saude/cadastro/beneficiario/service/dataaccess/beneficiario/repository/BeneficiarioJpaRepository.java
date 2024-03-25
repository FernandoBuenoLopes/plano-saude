package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.repository;

import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity.BeneficiarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface BeneficiarioJpaRepository extends JpaRepository<BeneficiarioEntity, UUID> {
}
