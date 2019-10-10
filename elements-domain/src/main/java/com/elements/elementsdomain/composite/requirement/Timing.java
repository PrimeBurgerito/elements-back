package com.elements.elementsdomain.composite.requirement;

import lombok.Data;

import java.time.Month;
import java.util.Set;

@Data
public class Timing {
    private int[] weekDays;
    private int[] monthDays;
    private Set<Month> months;
    private Set<TimeRange> time;
}
