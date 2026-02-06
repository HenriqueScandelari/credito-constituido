package com.infuse.credito.api.infra.logging.dto;

import java.time.LocalDateTime;

public record LogDTO(String endPoint, String method, String request, String response, LocalDateTime timestamp) {
}
