package com.elements.elementsdomain.requirement;

import lombok.Data;

import java.time.Month;
import java.util.Set;

@Data
class Timing {
    private int[] weekDays;
    private int[] monthDays;
    private Set<Month> months;
    private Set<TimeRange> time;
}
