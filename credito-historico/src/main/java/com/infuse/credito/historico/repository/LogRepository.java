package com.infuse.credito.historico.repository;

import com.infuse.credito.historico.model.LogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogModel, String> {
}
