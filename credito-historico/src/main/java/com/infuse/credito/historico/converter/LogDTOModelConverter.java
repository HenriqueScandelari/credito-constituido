package com.infuse.credito.historico.converter;

import com.infuse.credito.commom.lib.dto.LogDTO;
import com.infuse.credito.historico.model.LogModel;

public abstract class LogDTOModelConverter {

    public static LogModel convertToModel(LogDTO dto) {
        return new LogModel(
                dto.endPoint(),
                dto.method(),
                dto.request(),
                dto.response(),
                dto.timestamp());
    }
}
