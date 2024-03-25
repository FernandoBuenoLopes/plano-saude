package com.sistema.saude.cadastro.beneficiario.service.domain;

public class DomainConstants {
    private DomainConstants() {
    }
    public static final String ERRO_INESPERADO = "Erro inesperado";
    public static final String ATUALIZADO = "atualizado";
    public static final String REMOVIDO = "removido";
    public static final String CRIADO = "criado";
    public static final String SALVAR = "salvar";
    public static final String ATUALIZAR = "atualizar";
    public static final String REMOVER = "remover";
    public static final String ERRO_REMOCAO_BENEFICIARIO = "Erro no acesso dos dados para remoção de beneficiário";
    public static final String BENEFICIARIO_NAO_ENCONTRADO = "Beneficiário não encontrado na base de dados";
    public static final String CONSULTANDO_BENEFICIARIOS = "Consultando beneficiários";
    public static final String CONSULTA_BENEFICIARIOS_BEM_SUCEDIDA = "Consulta de beneficiários bem sucedida";
    public static final String CADASTRANDO_BENEFICIARIO = "Cadastrando o beneficiário '{}'";
    public static final String BENEFICIARIO_CADASTRADO_SUCESSO = "Beneficiário '{}' cadastrado com sucesso. Id: '{}'";
    public static final String ATUALIZANDO_BENEFICIARIO = "Atualizando beneficiário. id '{}'";
    public static final String BENEFICIARIO_ATUALIZADO_SUCESSO = "Beneficiário atualizado com sucesso. Id: '{}'";
    public static final String REMOVENDO_BENEFICIARIO = "Removendo beneficiário. id '{}'";
    public static final String BENEFICIARIO_REMOVIDO_SUCESSO = "Beneficiário removido com sucesso. Id: '{}'";
    public static final String BENEFICIARIO_CRIADO = "Beneficiário foi criado. '{}'";
    public static final String BENEFICIARIO_ATUALIZADO = "Beneficiário foi atualizado. Id '{}'";
    public static final String BENEFICIARIO_REMOVIDO = "Beneficiário foi removido. Id '{}'";
    public static String BENEFICIARIO_X_COM_SUCESSO(String x) {
        return "Beneficiário " + x + " com sucesso";
    }
    public static String IMPOSSIVEL_X_BENEFICIARIO(String x) {
        return "Impossível " + x + " o beneficiário";
    }
}