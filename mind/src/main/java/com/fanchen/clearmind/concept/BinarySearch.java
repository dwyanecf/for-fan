package com.fanchen.clearmind.concept;

public class BinarySearch {

    private static int binarySearch0(short[] a, int fromIndex, int toIndex,
                                     short key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    public static void main(String[] args) {
        short[] a = new short[]{2, 4};
        int fromIndex = 0;
        int toIndex = 2;
        short key1 = 1;
        short key2 = 2;
        short key3 = 3;
        short key4 = 4;
        short key5 = 5;
        short key6 = 6;

        System.out.println(binarySearch0(a, fromIndex, toIndex, key1));
        System.out.println(binarySearch0(a, fromIndex, toIndex, key2));
        System.out.println(binarySearch0(a, fromIndex, toIndex, key3));
        System.out.println(binarySearch0(a, fromIndex, toIndex, key4));
        System.out.println(binarySearch0(a, fromIndex, toIndex, key5));
        System.out.println(binarySearch0(a, fromIndex, toIndex, key6));
    }
}
