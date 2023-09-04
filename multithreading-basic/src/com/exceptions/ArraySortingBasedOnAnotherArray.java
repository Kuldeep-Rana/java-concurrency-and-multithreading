package com.exceptions;
import java.util.Arrays;
public class ArraySortingBasedOnAnotherArray {
    public static void main(String[] args) {
        int arr1 [] = {3,5,7,1,3,7,4,6,3,9,7,8,3,2,1};
        int arr2 [] = {1,3,7};
        for(int i = 0; i < arr1.length; i ++) {
            for (int j = i+1; j < arr1.length; j++) {
                 int a = getIndexInArr2(arr1[i],arr2);
                 int b = getIndexInArr2(arr1[j],arr2);
                 if(a > b || (a == b && arr1[i] > arr1[j])){
                     int temp = arr1[i];
                     arr1[i] = arr1[j];
                     arr1[j] = temp;
                 }
             }
        }
        System.out.println(Arrays.toString(arr1));
    }
    private static int getIndexInArr2(int value, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            if (value == arr2[i]) {
                return i;
            }
        }
        return arr2.length;
    }
}
