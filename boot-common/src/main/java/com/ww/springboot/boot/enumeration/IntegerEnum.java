package com.ww.springboot.boot.enumeration;

import java.util.HashMap;
import java.util.Map;

public interface IntegerEnum {
    Integer getValue();

    String getDisplayValue();

    static <E extends IntegerEnum> E getEnum(final Class<E> enumClass, final Integer enumValue) {
        if (enumValue == null) {
            return null;
        }
        try {
            return getValueOf(enumClass, enumValue);
        } catch (final IllegalArgumentException ex) {
            return null;
        }
    }

    static <E extends IntegerEnum> E getValueOf(Class<E> enumClass, Integer enumValue) {
        if (enumValue == null) throw new NullPointerException("EnumValue is null");
        return getEnumMap(enumClass).get(enumValue);
    }

    static <E extends IntegerEnum> Map<Integer, E> getEnumMap(Class<E> enumClass) {
        E[] enums = enumClass.getEnumConstants();
        if (enums == null)
            throw new IllegalArgumentException(enumClass.getSimpleName() + " does not represent an enum type.");
        Map<Integer, E> map = new HashMap<>(2 * enums.length);
        for (E t : enums) {
            map.put(t.getValue(), t);
        }
        return map;
    }
}
