package com.infuse.credito.historico.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
@Data
@NoArgsConstructor
public class LogModel {
    @Id
    private String id;
    private String endPoint;
    private String method;
    private String request;
    private String response;
    private LocalDateTime timestamp;

    public LogModel(String endPoint, String method, String request, String response, LocalDateTime timestamp) {
        this.endPoint = endPoint;
        this.method = method;
        this.request = request;
        this.response = response;
        this.timestamp = timestamp;
    }
}
