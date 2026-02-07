package com.infuse.credito.historico.service;

import com.infuse.credito.commom.lib.dto.LogDTO;
import com.infuse.credito.historico.converter.LogDTOModelConverter;
import com.infuse.credito.historico.model.LogModel;
import com.infuse.credito.historico.repository.LogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HistoryListener {
    private final LogRepository repository;

    public HistoryListener(LogRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "credito-hist", groupId = "hist-group")
    public void save(LogDTO dto) {
        System.out.println("Received message: " + dto);
        LogModel logModel = LogDTOModelConverter.convertToModel(dto);
        repository.save(logModel);
    }
}
