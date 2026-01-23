package com.infuse.credito_api.model;

public record CreditoDTO(String numeroCredito, String numeroNfse, String dataConstituicao,
                         double valorIssqn, String tipoCredito, String simplesNacional,
                         double aliquota, double valorFaturado, double valorDeducao,
                         double baseCalculo) {


}
