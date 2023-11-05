// Programming Questions

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
    public static void largestElementInArray(int arr[]){

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);

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
    public static int factorialNumber(int n){

        int res = 1;
        int i = 1;

        while(i <= n){

            res *= i;
            i += 1;

        }
        return res;
        
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


    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args){

        // String str = "Java Programing Language";
        // System.out.println(reverseString(str));

        // int arr[] = {1, 2, 3, 4, 5, 6, 3};
        // int res[] = largestElementInArray(arr);
        // printArray(res)

        // String s = "MadaM";
        // System.err.println(isPolindrome(s));

        // int n = 5;
        // System.out.println(factorialNumber(n));

        // int n = 7;
        // int[] res = fibonacciSeries(n);
        // printArray(res);

        // int n = 121;
        // System.out.println(isPrime(n));

    }
}