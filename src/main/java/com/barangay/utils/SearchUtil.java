package com.barangay.utils;

import java.util.List;

public class SearchUtil {

    public static <T> T search(
            List<T> list,
            java.util.function.Predicate<T> condition) {

        for (T item : list) {

            if (condition.test(item)) {
                return item;
            }
        }

        return null;
    }
}
