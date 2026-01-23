package com.infuse.credito.api.service;

import com.infuse.credito.api.controller.dto.CreditoDTO;
import com.infuse.credito.api.repository.CreditoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditoService {
	private final CreditoRepository repository;

    public CreditoService(CreditoRepository repository) {
        this.repository = repository;
    }

    public List<CreditoDTO> getByNumeroNfse(String nfse) {
		List<CreditoDTO> list = repository.findByNumeroNfse(nfse).stream().map(CreditoDTO::fromModel).toList();
        CreditoDTO creditoDTO = new CreditoDTO("123456",
                	"7891011",
                	"2024-02-25",
                	BigDecimal.valueOf(1500.75),
                	"ISSQN",
                	"Sim",
					BigDecimal.valueOf(5.0),
					BigDecimal.valueOf(30000.00),
					BigDecimal.valueOf(5000.00),
					BigDecimal.valueOf(25000.00));
        return list;
    }

	public CreditoDTO getByNumeroCredito(String numeroCredito) {
		CreditoDTO dto = repository.findByNumeroCredito(numeroCredito).map(CreditoDTO::fromModel).orElse(null);
		return dto;
	}
}
