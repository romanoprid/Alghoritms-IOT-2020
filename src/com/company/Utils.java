package com.company;

import java.util.List;

public class Utils {
    public static void quickSort(List<Integer> source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source.get((leftMarker + rightMarker) / 2);
        do {



            while (source.get(leftMarker) < pivot) {
                leftMarker++;
            }


            while (source.get(rightMarker) > pivot) {
                rightMarker--;
            }


            if (leftMarker <= rightMarker) {


                if (leftMarker < rightMarker) {
                    int tmp = source.get(leftMarker);
                    source.set(leftMarker, source.get(rightMarker));
                    source.set(rightMarker, tmp);
                }


                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);



        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
