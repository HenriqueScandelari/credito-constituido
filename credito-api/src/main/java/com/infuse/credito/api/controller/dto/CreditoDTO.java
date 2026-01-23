package com.infuse.credito.api.controller.dto;

import com.infuse.credito.api.model.Credito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;

public record CreditoDTO(String numeroCredito, String numeroNfse, String dataConstituicao,
                         BigDecimal valorIssqn, String tipoCredito, String simplesNacional,
                         BigDecimal aliquota, BigDecimal valorFaturado, BigDecimal valorDeducao,
                         BigDecimal baseCalculo) {

    public static CreditoDTO fromModel(Credito model) {
        return new CreditoDTO(model.getNumeroCredito(), model.getNumeroNfse(), model.getDataConstituicao().format(DateTimeFormatter.ISO_LOCAL_DATE),
                model.getValorIssqn(), model.getTipoCredito(), model.isSimplesNacional() ? "Sim" : "Não",
                model.getAliquota().setScale(2, RoundingMode.HALF_UP), model.getValorFaturado(), model.getValorDeducao(),
                model.getBaseCalculo()
                );
    }
}