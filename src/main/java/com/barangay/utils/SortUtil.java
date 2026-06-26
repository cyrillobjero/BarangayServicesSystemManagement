package com.barangay.utils;

import java.util.Comparator;
import java.util.List;

public class SortUtil {

    public static <T> void sort(
            List<T> list,
            Comparator<T> comparator) {

        list.sort(comparator);
    }
}
