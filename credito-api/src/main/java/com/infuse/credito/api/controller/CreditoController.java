package com.infuse.credito.api.controller;

import com.infuse.credito.api.controller.dto.CreditoDTO;
import com.infuse.credito.api.service.CreditoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("{numeroNfse}")
    public List<CreditoDTO> getByNumeroNfes(@PathVariable String numeroNfse) {

        List<CreditoDTO> result = creditoService.getByNumeroNfse(numeroNfse);
        return result;
    }

    @GetMapping("/credito/{numeroCredito}")
    public CreditoDTO getByNumeroCredito(@PathVariable String numeroCredito) {

        CreditoDTO result = creditoService.getByNumeroCredito(numeroCredito);
        return result;
    }
}
