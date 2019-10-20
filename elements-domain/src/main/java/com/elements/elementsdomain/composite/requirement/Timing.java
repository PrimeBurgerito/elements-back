package com.elements.elementsdomain.composite.requirement;

import lombok.Data;

import java.io.Serializable;
import java.time.Month;
import java.util.Set;

@Data
public class Timing implements Serializable {
    private static final long serialVersionUID = 1170054597065302007L;
    private int[] weekDays;
    private int[] monthDays;
    private Set<Month> months;
    private Set<TimeRange> time;
}
