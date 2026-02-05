package com.infuse.credito.api.controller.dto;

import com.infuse.credito.api.model.emum.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
