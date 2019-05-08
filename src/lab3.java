//TODO
//(1)隨機成生一個arraylist(可以輸入不同的n)
//(2)定義bubble sort 演算法
//(3)定義selection sort 演算法
//(4)定義insertion sort 演算法
//(5)定義Array.sort 演算法
//(6)每一個演算法進行排序的時候記錄花費時間


import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

public class lab3 {

    public static int[] arrayGenerator(int size, int lowerBound, int upperBound){
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(upperBound-lowerBound) + lowerBound;
        }
        return array;
    }

    public static void showArrayElements(int[] array){
        for (int i = 0; i <array.length; i++){
            System.out.printf("%2d ", array[i]);
        }
    }

    public static void swap(int[] array, int indexA, int indexB) {
        int tmpArray = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmpArray;
    }

    public static int[] cpArray(int[] array){
        int[] tmpArray = new int[array.length];
        for (int i = 0; i < tmpArray.length; i++){
            tmpArray[i] = array[i];
        }
        return tmpArray;
    }

    public static Object bubbleSort(int[] array)throws JSONException {
        JSONObject resultObj = new JSONObject();
        resultObj.put("originalArray", array);

        //cp tmp array
        int[] tmpArray = cpArray(array);

        long startTime = System.nanoTime();
        //bubbleSort algorithm here
        Boolean swappedTag;
        do {
            swappedTag = false;
            for (int i = 0; i < tmpArray.length; i++) {
                if (i == tmpArray.length-1){
                    continue;
                }
                if (tmpArray[i] > tmpArray[i + 1]) {
                    swap(tmpArray, i, (i+1));
                    swappedTag = true;
                }
            }
        } while (swappedTag);
        long endTime = System.nanoTime();
        double elapasedTimeToMillisecond = (endTime-startTime) / 1000000.0;

        resultObj.put("newArray", tmpArray);
        resultObj.put("elapasedTime", elapasedTimeToMillisecond);
        return resultObj;
    }

    public static Object selectionSort(int[] array)throws JSONException{
        JSONObject resultObj = new JSONObject();
        resultObj.put("originalArray", array);

        //cp tmp array
        int[] tmpArray = cpArray(array);

        long startTime = System.nanoTime();
        //selection sort algorithm here
        int min;
        for (int i = 0; i < tmpArray.length; i++){
            min = i;
            for (int j = 0 + i; j < tmpArray.length; j++){
                if (j == (tmpArray.length-1)){
                    break;
                }
                if (tmpArray[min] > tmpArray[j+1]){
                    min = j+1;
                }
            }
            swap(tmpArray, i, min);
        }
        long endTime = System.nanoTime();
        double elapasedTimeToMillisecond = (endTime-startTime) / 1000000.0;

        resultObj.put("newArray", tmpArray);
        resultObj.put("elapasedTime", elapasedTimeToMillisecond);
        return resultObj;
    }

    public static Object insertionSort(int[] array) throws JSONException{
        JSONObject resultObj = new JSONObject();
        resultObj.put("originalArray", array);

        //cp tmp array
        int[] tmpArray = cpArray(array);

        long startTime = System.nanoTime();
        //selection insertion algorithm here
        int tmpElement;
        for (int i = 1; i < tmpArray.length; i++){
            tmpElement = array[i];
            for (int j = i-1; j >= 0 && tmpElement < tmpArray[j] ; j--){
                swap(tmpArray, j, (j+1));
            }
        }
        long endTime = System.nanoTime();
        double elapasedTimeToMillisecond = (endTime-startTime) / 1000000.0;

        resultObj.put("newArray", tmpArray);
        resultObj.put("elapasedTime", elapasedTimeToMillisecond);
        return resultObj;
    }

    public static Object arraySort(int[] array) throws JSONException {
        JSONObject resultObj = new JSONObject();
        resultObj.put("originalArray", array);

        //cp tmp array
        int[] tmpArray = cpArray(array);

        long startTime = System.nanoTime();
        //Arrays sort algorithm here
        Arrays.sort(tmpArray);
        long endTime = System.nanoTime();
        double elapasedTimeToMillisecond = (endTime-startTime) / 1000000.0;

        resultObj.put("newArray", tmpArray);
        resultObj.put("elapasedTime", elapasedTimeToMillisecond);
        return resultObj;
    }

    public static void main(String[] args) throws JSONException, FileNotFoundException {

        int[] listN = new int[]{1000,2000,4000,8000,16000,32000,64000};

        //輸出.txt
        PrintWriter outputStream = new PrintWriter("lab3.txt");
        outputStream.println(String.format("%s", "Benchmark(TimeUnit:ms)"));
        outputStream.println(String.format("%s %s %s %s %s", "Size", "BubbleSort", "SelectionSort", "InsertionSort", "ArraysSort"));

        //實驗不同的size
        for (int n:listN){
            int[] tmpArray = arrayGenerator(n,-1000,1000);
//        showArrayElements(tmpArray);
//        System.out.println();
//
            JSONObject bubbleSortResult = (JSONObject) bubbleSort(tmpArray);
            JSONObject selectSortResult = (JSONObject) selectionSort(tmpArray);
            JSONObject insertSortResult = (JSONObject) insertionSort(tmpArray);
            JSONObject arraySortResult = (JSONObject) arraySort(tmpArray);

            outputStream.println(String.format("%s %s %s %s %s", n,
                    bubbleSortResult.get("elapasedTime"),
                    selectSortResult.get("elapasedTime"),
                    insertSortResult.get("elapasedTime"),
                    arraySortResult.get("elapasedTime")
            ));
        }
        outputStream.close();




    }

}
