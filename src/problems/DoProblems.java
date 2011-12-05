/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/** This is my collection of Euler Problems I have solved.
 *
 * @author Cameron
 */
public class DoProblems {

     /**
      * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600,851,475,143?
      * Status - Completed.
      * @return 
      */
     public String problemThree() {
          int largestPrimeFactor = 0;
          int count = 0;
          final long COMPOSITE_NUMBER = 600851475143L;
          Integer[] primes = new Integer[1000];
          Boolean[] numbers = new Boolean[7919];
          Arrays.fill(numbers, true);
          for (int i = 2; i < numbers.length; i++) {
               for (int j = 2 * i; j < numbers.length; j += i) {
                    numbers[j] = false;
               }
          }
          for (int k = 2; k < numbers.length && count < 1000; k++) {
               if (numbers[k] == true) {
                    primes[count] = k;
                    count++;
               }
          }
          for (int i = 998; i > 0; i--) {
               if (COMPOSITE_NUMBER % primes[i] == 0) {
                    largestPrimeFactor = primes[i];
                    return Integer.toString(largestPrimeFactor);
               }
          }
          return Integer.toString(largestPrimeFactor);
     }

     /**
      * A palindromic number reads the same both ways. 
      * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
      * Find the largest palindrome made from the product of two 3-digit numbers.
      * Status - Completed.
      * @return 
      */
     public String problemFour() {
          boolean equal = true;
          StringBuilder product = new StringBuilder();
          String pallindrome = "0";
          for (int i = 999; i > 99; i--) {
               for (int j = 999; j > 99; j--) {
                    product = new StringBuilder();
                    product.append(i * j);
                    String temp = product.toString();
                    if (temp.equals(product.reverse().toString())) {
                         if (Integer.parseInt(temp) > Integer.parseInt(pallindrome)) {
                              pallindrome = temp;
                         }
                    }
               }
          }
          return pallindrome;
     }

     /**
      * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
      * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
      * Status - Completed.
      * @return 
      */
     public String problemFive() {
          boolean dividesEvenly;
          long i = 0;
          do {
               i++;
               dividesEvenly = true;
               for (int j = 2; j <= 20 && dividesEvenly == true; j++) {
                    if (i % j != 0) {
                         dividesEvenly = false;
                    }
               }

          } while (dividesEvenly == false);
          return Long.toString(i);
     }

     /**
      * The sum of the squares of the first ten natural numbers is, 
      * 12 + 22 + ... + 102 = 385
      * The square of the sum of the first ten natural numbers is,
      * (1 + 2 + ... + 10)2 = 552 = 3025
      * Hence the difference between the sum of the squares of the first ten 
      * natural numbers and the square of the sum is 3025 385 = 2640. Find the 
      * difference between the sum of the squares of the first one hundred natural 
      * numbers and the square of the sum.
      * Status - Completed.
      * @return 
      */
     public String problemSix() {
          long sumOfSquares = 0;
          long squareOfSums = 0;
          for (int i = 0; i <= 100; i++) {
               sumOfSquares += i * i;
               squareOfSums += i;
          }
          squareOfSums = squareOfSums * squareOfSums;
          return Long.toString(squareOfSums - sumOfSquares);
     }

     /**
      * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
      * What is the 10 001st prime number?
      * Status - Completed
      * @return 
      */
     public String problemSeven() {
          Boolean[] primes = new Boolean[500000];
          Arrays.fill(primes, true);
          int count = 0;
          for (int i = 2; i < primes.length - 1; i++) {
               for (int j = i + i; j < 500000; j += i) {
                    primes[j] = false;
               }
          }
          for (int k = 2; k < primes.length - 1; k++) {

               if (primes[k] == true) {
                    count++;
               }
               if (count == 10001) {
                    return Integer.toString(k);
               }
          }
          return "Error";
     }

     /**
      * Find the greatest product of five consecutive digits in the 1000-digit number.
      * 731671765313306249192251196744265747423553491949349698352031277450632623
      * 957831801698480186947885184385861560789112949495459501737958331952853208
      * 805511125406987471585238630507156932909632952274430435576689664895044524
      * 452316173185640309871112172238311362229893423380308135336276614282806444
      * 486645238749303589072962904915604407723907138105158593079608667017242712
      * 188399879790879227492190169972088809377665727333001053367881220235421809
      * 751254540594752243525849077116705560136048395864467063244157221553975369
      * 781797784617406495514929086256932197846862248283972241375657056057490261
      * 407972968652414535100474821663704844031998900088952434506585412275886668
      * 811642717147992444292823086346567481391912316282458617866458359124566529
      * 476545682848912883142607690042242190226710556263211111093705442175069416
      * 589604080719840385096245544436298123098787992724428490918884580156166097
      * 919133875499200524063689912560717606058861164671094050775410022569831552
      * 0005593572972571636269561882670428252483600823257530420752963450
      * Status - Completed
      * @return 
      */
     public String problemEight() {
          Integer[] number = new Integer[1000];
          int temp = 0;
          int largestProduct = 0;
          try {
               FileReader fileReader = new FileReader("src/1000DigitNumber.txt");
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               for (int i = 0; i < number.length - 1; i++) {
                    number[i] = bufferedReader.read() - 48;
               }
          } catch (IOException e) {
               System.err.print(e.toString());
          }
          for (int j = 0; j < number.length - 5; j++) {
               temp = 0;
               for (int k = 0; k < 5; k++) {
                    if (k == 0) {
                         temp += number[j + k];
                    } else {
                         temp *= number[j + k];
                    }
               }
               if (temp > largestProduct) {
                    largestProduct = temp;
               }
          }
          return Integer.toString(largestProduct);
     }

     /**
      * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which, 
      * a2 + b2 = c2 
      * For example, 32 + 42 = 9 + 16 = 25 = 52. 
      * There exists exactly one Pythagorean triplet for which a + b + c = 1000. 
      * Find the product abc.
      * Solved with help...
      * 
      * @return 
      */
     public String problemNine() {

          int a = 0;
          int b = 0;
          int c = 0;
          int sum = 0;
          for (a = 1; a < 500; a++) {
               for (b = a; b < 500; b++) {
                    c = 1000 - b - a;
                    if ((a * a) + (b * b) == c * c) {
                         return Integer.toString(a * b * c);
                    }
               }
          }
          return "Error.";
     }

     /**The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
      * Find the sum of all the primes below two million.
      * Status - Completed!
      * @return 
      */
     public String problemTen() {
          Boolean[] primes = new Boolean[2000000];
          Arrays.fill(primes, true);
          long sum = 0;
          for (int i = 2; i < primes.length - 1; i++) {
               for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
               }
          }
          for (int k = 1; k < primes.length; k++) {
               if (primes[k] == true) {
                    sum += k;
               }
          }
          return Long.toString(sum);
     }

     /**
      * What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 2020 grid
      * @return 
      */
     public String problemEleven() {
          Integer[][] grid = new Integer[20][20];
          StringTokenizer tok;
          String line = "";
          int product = 0;
          int productRev = 0;
          try {
               FileReader fileReader = new FileReader("src/20X20grid.txt");
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               for (int i = 0; i < 20; i++) {
                    line = bufferedReader.readLine();
                    tok = new StringTokenizer(line, " ");
                    for (int j = 0; j < 20; j++) {
                         grid[i][j] = Integer.parseInt(tok.nextToken());
                    }
               }
          } catch (IOException e) {
               System.err.print(e.toString());
          }
          
          //Rows
          for(int i = 0; i < 19; i++) {
               for(int j = 0; j < 15; j++) {
                    
               }
          }
          
          //Cols
          
          //Diagonals
          

          return "";
     }
}
