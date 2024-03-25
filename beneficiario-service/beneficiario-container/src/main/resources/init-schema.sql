DROP SCHEMA IF EXISTS "beneficiario" CASCADE;

CREATE SCHEMA "beneficiario";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS tipo_documento;
CREATE TYPE tipo_documento AS ENUM ('RG', 'CPF', 'HABILITACAO');

DROP TABLE IF EXISTS "beneficiario".beneficiarios CASCADE;

CREATE TABLE "beneficiario".beneficiarios
(
    id uuid NOT NULL,
    nome character varying COLLATE pg_catalog."default" NOT NULL,
    telefone  numeric(10,2) NOT NULL,
    data_nascimento date NOT NULL,
    data_inclusao date NOT NULL,
    data_atualizacao date NOT NULL,
    CONSTRAINT beneficiarios_pkey PRIMARY KEY (id)
);


DROP TABLE IF EXISTS "beneficiario".beneficiario_documentos CASCADE;

CREATE TABLE "beneficiario".beneficiario_documentos
(
    id bigint NOT NULL,
    beneficiario_id uuid NOT NULL,
    tipo_documento tipo_documento NOT NULL,
    descricao character varying COLLATE pg_catalog."default" NOT NULL,
    data_inclusao date NOT NULL,
    data_atualizacao date NOT NULL,
    CONSTRAINT beneficiario_documentos_pkey PRIMARY KEY (id, beneficiario_id)
);


ALTER TABLE "beneficiario".beneficiario_documentos
    ADD CONSTRAINT "FK_beneficiario_ID" FOREIGN KEY (beneficiario_id)
    REFERENCES "beneficiario".beneficiarios (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;