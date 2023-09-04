package com.exceptions;

import java.util.Random;
import java.util.random.RandomGenerator;

public class ExceptionTest {
    public static void main(String[] args)  {

        int arr [] = {3,6,1,2,8,4,5};
        int value = 7;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > value){
                i++;
            }else{
                if(arr[i] + arr[i+1] == value){
                    System.out.println("index are "+ i + " "+(i+1));
                }
                for(int j = i+2; j< arr.length; j++){
                    if(arr[i]+arr[j] == value){
                        System.out.println("index are "+ i + " "+j);
                    }
                }
            }

        }

        /*try {
            while (true) {
                int i = RandomGenerator.getDefault().nextInt();
                System.out.println(i);
                if (i < 1) {
                    throw new CustomException("can't be less zero");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

}
