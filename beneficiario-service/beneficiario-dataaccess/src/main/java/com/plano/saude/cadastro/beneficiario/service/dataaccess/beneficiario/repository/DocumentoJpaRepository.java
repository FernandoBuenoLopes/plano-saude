package com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.repository;

import com.plano.saude.cadastro.beneficiario.service.dataaccess.beneficiario.entity.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentoJpaRepository extends JpaRepository<DocumentoEntity, UUID> {
    List<DocumentoEntity> findAllByBeneficiarioId(final UUID beneficiarioId);
    void deleteAllByBeneficiarioId(final UUID beneficiarioId);
}
