package com.infuse.credito_api.service;

import com.infuse.credito_api.model.CreditoDTO;
import org.springframework.stereotype.Service;

@Service
public class CreditoService {
    public CreditoDTO getByNumeroNfse(Long nfse) {
        CreditoDTO creditoDTO = new CreditoDTO("123456",
                	"7891011",
                	"2024-02-25",
                	1500.75,
                	"ISSQN",
                	"Sim",
                	5.0,
                	30000.00,
                	5000.00,
                	25000.00);
        return creditoDTO;
    }
}
