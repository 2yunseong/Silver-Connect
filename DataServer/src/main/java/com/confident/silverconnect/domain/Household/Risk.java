package com.confident.silverconnect.domain.Household;

public enum Risk {
    SAFE,
    WARN,
    DANGER,
    EMERGENCY;

    public static Risk valueOfIndex(int index) {
        switch (index) {
            case 1:
                return Risk.EMERGENCY;
            case 2:
                return Risk.DANGER;
            case 3:
                return Risk.WARN;
            case 4:
            case 5:
            default:
                return Risk.SAFE;
        }
    }
}
