package com.elements.elementsdomain.requirement;

import lombok.Data;
import org.springframework.data.util.Pair;

import java.time.LocalTime;
import java.time.Month;
import java.util.Set;

@Data
class Timing {
    private int[] weekDays;
    private int[] monthDays;
    private Set<Month> months;
    private Pair<LocalTime, LocalTime> time;
}
