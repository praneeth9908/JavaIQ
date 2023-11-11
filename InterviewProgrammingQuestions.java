// Programming Questions

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class InterviewProgrammingQuestions{
// 1. Reverse a String:
// Write a Java program to reverse a given string

// Ex:- 
// Input:- Java Programing Language
// Output:- egaugnaL gnimargorP avaJ
    public static String reverseString(String s){

        String res = "";
        for(int i = s.length()-1; i>=0; i--){
            res+=s.charAt(i);
        }
        return res;

    }

// 2. Find the Largest Element in an Array:
// Find and print the largest element in an array.

// Ex:-
// Input:- 1 2 3 4 5 6 3
// Output:- 6
    public static int largestElementInArray(int arr[]){

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;

    }

// 3. Check for Palindrome:
// Determine if a given string is a palindrome (reads the same backward as forward).

// Ex:-
// Input:- Madam
// Yes, given string is Polindrome
    public static String isPolindrome(String s){

        String revStr = reverseString(s);
        if(s.equals(revStr)){
            return "Yes, given string is a Polindrome";
        }
        else{
            return "No, given string is not a Polindrome";
        }

    }

// 4. Factorial Calculation:
// Write a function to calculate the factorial of a number.

// Ex:-
// Input:- 5
// Output:- 120

// 20. Recursive Algorithm:
// Solve a problem using recursion.
    public static int factorialNumber(int n){

        if(n==1)return 1;
        return n*factorialNumber(n-1);

        // int res = 1;
        // int i = 1;

        // while(i <= n){
        //     res *= i;
        //     i += 1;
        // }
        // return res;
        
    }

// 5. Fibonacci Series:
// Generate the first n numbers in the Fibonacci sequence.

// Ex:-
// Input:- 7
// Output:- 0 1 1 2 3 5 8
    public static int[] fibonacciSeries(int n){

        int[] res = new int[n];
        int f0 = 0, f1 = 1, f2;
        for(int i = 0; i < n; i++){

            res[i] = f0;
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return res;

    }

// 6. Check for Prime Number:
// Write a program to check if a given number is prime.

// Ex:- 
// Input 7
// Ouput Prime Number
// 1<=n
    public static String isPrime(int n){

        if(n == 1)return "Not a Prime Number";
        for(int i = 2; i <= (int)Math.sqrt(n); i++){

            if(n%i == 0){
                return "Not a Prime Number";
            }
        }
        return "Prime Number";
    }

// 7. String Anagrams:
// Determine if two strings are anagrams of each other.

// Ex:-       Input                 Output
        // 1. listen silent -->     Anagrams
        // 2. triangle integral --> Anagrams
        // 3. credit debit -->      Not Anagrams
    public static String isAnagrams(String s1, String s2){

        char arr1[] = s1.toCharArray();//{l,i,s,t,e,n}
        char arr2[] = s2.toCharArray();//{s,i,l,e,n,t}
        Arrays.sort(arr1);//{e,i,l,n,s,t}
        Arrays.sort(arr2);//{e,i,l,n,s,t}

        if(arr1.length != arr2.length)return "Not Anagrams";

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return "Not Anagrams";
            }
        }
        return "Anagrams";
    }

// 8. Array Sorting:
// Implement sorting algorithms like bubble sort, merge sort, or quicksort.
// 
// Bubble Sort:-
    public static int[] bubbleSort(int[] arr){

        int temp;
        boolean flag;
        for(int i = 0; i < arr.length-1; i++){
            flag = true;
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if(flag)return arr;
        }
        return arr;
    }

// Merge Sort
    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m;
            m = l + (r-l)/2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, r, m);
        }
    }

    private static void merge(int[] arr, int l, int r,int m) {
        int[] arr1 = new int[m - l + 1];
        int[] arr2 = new int[r - m];

        for(int i = 0; i < arr1.length; i++){
            arr1[i] = arr[l + i];
        }
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                i++;
            }
            else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1.length){  
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){  
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

// Quick Sort
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int l, int r){

        int pivot = r;
        int i = l-1;
        for(int j = l; j < r; j++){
            if(arr[j] < arr[pivot]){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivot);
        return i + 1;
    }
    public static void quickSort(int[] arr, int l, int r){

        if(l < r){

            int p = partition(arr, l, r);

            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);
        }
    }

// 9. Binary Search:
// Implement a binary search algorithm to find an element in a sorted array.

// Ex:- 
// Input:- l = {1, 2, 3, 4, 5} k = 4
// Output:- true
    public static boolean binarySearch(int[] arr, int k){

        int l = 0, r = arr.length-1, m;
        // quickSort(arr, l, r); if array is not sorted.

        while(l < r){

            m = l + (r - l)/2;
            if(arr[m] == k){
                return true;
            }
            else if(arr[m] > k){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }

        return false;
    }

// 10. Duplicate Elements in an Array:
// Find and print duplicate elements in an array.

// Ex:- 
// Input:- arr[] = {3, 5, 1, 2, 3, 4, 5, 6, 3};
// Ouput:- {3, 5}

    public static ArrayList<Integer> duplicateElementsInArray(int[] arr){

        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> temp = new HashMap<>();
    
        for(int ele: arr){
            temp.put(ele, temp.getOrDefault(ele,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: temp.entrySet()){
            if(entry.getValue() > 1){
                res.add(entry.getKey());
            }
        }

        return res;
    }

// 16. Exception Handling:
// Write code that demonstrates the use of try-catch blocks to handle exceptions.
    public static void divisionExceptionHandling(int a, int b){
        int z;
        try{
            z = a/b;
            System.out.println("Result:- "+z);
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Denominator cannot be 0");
        }
        finally{
            System.out.println("Division Completed");
            
        }
    }

// 17. File I/O:
// Read from and write to a file using Java's file I/O capabilities.
    public static void readFile(String fileName) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
    }

    public static void writeFile(String fileName){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Hello!\n");
            writer.write("This is a Writer File.\n");
            writer.write("This file is used to write the file using BufferedWriter.\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    

    public static void main(String[] args) throws Exception{

        // String str = "Java Programing Language";
        // System.out.println(reverseString(str));

        // int arr[] = {1, 2, 3, 4, 5, 6, 3};
        // int res = largestElementInArray(arr);
        // System.out.println(res);

        // String s = "MadaM";
        // System.err.println(isPolindrome(s));

        // int n = 5;
        // System.out.println(factorialNumber(n));

        // int n = 7;
        // int[] res = fibonacciSeries(n);
        // printArray(res);

        // int n = 121;
        // System.out.println(isPrime(n));

        // String s1 = "credit";
        // String s2 = "credit";
        // System.out.println(isAnagrams(s1, s2));

        // int arr1[] = {3, 5, 1, 2, 3, 4, 5, 6, 3};
        // int res1[] = bubbleSort(arr1);
        // printArray(res1);

        // int arr[] = {3, 5, 1, 2, 3, 4, 5, 6, 3};
        // int l = 0, r = arr.length-1;
        // mergeSort(arr, l, r);
        // printArray(arr);

        // int arr[] = {3, 5, 1, 8, 7, 2345, 9876, 45, 987, 0, 2, 3, 4, 5, 6, 3};
        // int l = 0, r = arr.length-1;
        // quickSort(arr, l, r);
        // printArray(arr);

        // int arr[] = {3, 5, 1, 8, 7, 2345, 9876, 45, 987, 0, 2, 3, 4, 5, 6, 3};
        // int k = 2345;
        // boolean res = binarySearch(arr, k);
        // System.err.println(res);

        // int arr[] = {3, 5, 1, 2, 3, 4, 5, 6, 3};
        // ArrayList<Integer> res = duplicateElementsInArray(arr);
        // System.out.println(res);

        // int a = 2, b = 1;
        // divisionExceptionHandling(a, b);
        
        // String file= "reader.txt";
        // readFile(file);

        // String file = "writer.txt";
        // writeFile(file);
        // readFile(file);

    }
}