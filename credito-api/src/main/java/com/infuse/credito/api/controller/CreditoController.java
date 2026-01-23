package com.infuse.credito_api.controller;

import com.infuse.credito_api.model.CreditoDTO;
import com.infuse.credito_api.service.CreditoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping
    public CreditoDTO getByNumeroNfes() {

        Long nfse = 0L;
        CreditoDTO dto = creditoService.getByNumeroNfse(nfse);
        return dto;
    }
}
