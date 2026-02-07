package com.infuse.credito.api.service;

import com.infuse.credito.api.controller.dto.CreditoDTO;
import com.infuse.credito.api.repository.CreditoRepository;
import com.infuse.credito.commom.lib.dto.LogDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditoService {
	private final CreditoRepository repository;
	private final KafkaTemplate<String, Object> kafkaTemplate;

    public CreditoService(CreditoRepository repository, KafkaTemplate kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<CreditoDTO> getByNumeroNfse(String nfse) {
		List<CreditoDTO> list = repository.findByNumeroNfse(nfse).stream().map(CreditoDTO::fromModel).toList();
		LogDTO log = new LogDTO("/api/creditos", "GET", nfse, list.toString(), java.time.LocalDateTime.now());
		kafkaTemplate.send("credito-hist", log);
        return list;
    }

	public CreditoDTO getByNumeroCredito(String numeroCredito) {
		CreditoDTO dto = repository.findByNumeroCredito(numeroCredito).map(CreditoDTO::fromModel).orElse(null);
		LogDTO log = new LogDTO("/api/creditos/credito", "GET", numeroCredito, dto.toString(), java.time.LocalDateTime.now());
		kafkaTemplate.send("credito-hist", log);
		return dto;
	}
}
