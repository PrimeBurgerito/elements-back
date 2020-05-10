package com.elements.elementsdomain.shared.requirement;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Data
class TimeRange implements Serializable {
    private static final long serialVersionUID = -4737433097133702330L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
    private LocalTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
    private LocalTime end;
}
