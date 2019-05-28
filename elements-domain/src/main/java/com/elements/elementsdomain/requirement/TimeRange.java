package com.elements.elementsdomain.requirement;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalTime;

@Data
class TimeRange {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
    private LocalTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
    private LocalTime end;
}
