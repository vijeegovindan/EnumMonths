package com.packageForEnum.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Vijee on 7/25/17.
 */

public enum Month
{
    JANUARY("JANUARY"), FEBRUARY("FEBRUARY"), MARCH("MARCH"), APRIL("APRIL"), MAY("MAY"), JUNE("JUNE"),
    JULY("JULY"), AUGUST("AUGUST"), SEPTEMBER("SEPTEMBER"), OCTOBER("OCTOBER"), NOVEMBER("NOVEMBER"), DECEMBER("DECEMBER");


    private static String englishName;

    Month(String s) {
    }

    @JsonValue
    public static String getEnglishName() {
        return englishName;
    }

    public static void setEnglishName(String englishName) {
        Month.englishName = englishName;
    }
}


