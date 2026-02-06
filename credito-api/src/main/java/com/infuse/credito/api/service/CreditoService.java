package com.infuse.credito.api.service;

import com.infuse.credito.api.controller.dto.CreditoDTO;
import com.infuse.credito.api.infra.logging.dto.LogDTO;
import com.infuse.credito.api.repository.CreditoRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditoService {
	private final CreditoRepository repository;
	private final KafkaTemplate<String, String> kafkaTemplate;

    public CreditoService(CreditoRepository repository, KafkaTemplate kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<CreditoDTO> getByNumeroNfse(String nfse) {
		List<CreditoDTO> list = repository.findByNumeroNfse(nfse).stream().map(CreditoDTO::fromModel).toList();
		LogDTO log = new LogDTO("/credito/numeroNfse/" + nfse, "GET", nfse, list.toString(), java.time.LocalDateTime.now());
		kafkaTemplate.send("credito-hist", log.toString());
        return list;
    }

	public CreditoDTO getByNumeroCredito(String numeroCredito) {
		CreditoDTO dto = repository.findByNumeroCredito(numeroCredito).map(CreditoDTO::fromModel).orElse(null);
		return dto;
	}
}
