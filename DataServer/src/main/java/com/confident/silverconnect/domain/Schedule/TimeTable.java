package com.confident.silverconnect.domain.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public class TimeTable {
    private static List<LocalDateTime> timeTable = List.of(
            LocalDateTime.of(1, 1, 1, 9, 0),
            LocalDateTime.of(1, 1, 1, 11, 0),
            LocalDateTime.of(1, 1, 1, 13, 0),
            LocalDateTime.of(1, 1, 1, 15, 0),
            LocalDateTime.of(1, 1, 1, 17, 0)
    );

    public static LocalDateTime getTime(int index) {
        return timeTable.get(index);
    }

    public static int size() {
        return timeTable.size();
    }
}
