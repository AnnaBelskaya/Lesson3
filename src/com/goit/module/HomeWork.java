package com.goit.module;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HomeWork {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter array size:\t");
        int arraySize = Integer.parseInt(s.nextLine());
        int[] array = new int[arraySize];
        int fives = 0;
        for (int i = 0; i < arraySize; i++){
            array[i] = ThreadLocalRandom.current().nextInt(0,arraySize+1);
            System.out.print(array[i] + " ");
            if (array[i] == 5){
                fives++;
            }
        }
        findMinMax(array);
        System.out.println("\nFives in array:\t\t" + fives);
        bubbleSort(array);

        ///////////////Additional Task///////////////////

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arraySize; i++){
            if (map.containsKey(array[i])){
                int value = map.get(array[i]) + 1;
                map.put(array[i], value);
            } else {
                map.put(array[i], 1);
            }
        }
        int reps = map.get(array[0]);
        for (int value: map.values()){
            if (value > reps){
                reps = value;
            }
        }
        System.out.printf("\nAdditional Task:\nNumber repeats %d times in array.\n", reps);

        ///////////////Additional Task///////////////////
        System.out.print("Enter array numbers:\n");

        boolean checker = true;
        while (checker) {
            try {
                String[] line = s.nextLine().split(",");
                int[] newArray = new int[line.length];
                for (int i = 0; i < line.length; i++) {
                    newArray[i] = Integer.parseInt(line[i]);
                }
                System.out.println("Your new array is:");
                for (int a : newArray) {
                    System.out.print(a + " ");
                }
                checker = false;
            } catch (Exception e) {
                System.out.println("Enter only numbers, divided by ','!");
            }
        }

    }
    public static void findMinMax(int[] array){
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
            if (array[0] > max){
                max = array[0];
            }
        }
        System.out.print("\nMinimum in array:\t" + min);
        System.out.print("\nMaximum in array:\t" + max);
    }

    public static void bubbleSort(int[] array){
        boolean checker = true;
        int j = array.length - 1;
        while (checker == true){
            checker = false;
            for(int i = 0; i < j; i++){
                if (array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    checker = true;
                }
            }
            j--;
        }
        for (int a: array){
            System.out.print(a + " ");
        }
    }
}
