/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
            fileReader.close();
            bufferedReader.close();
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
     * What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 2020 grid.
     * Solve Again.
     * @return 
     */
    public String problemEleven() {
        Integer[][] grid = new Integer[][]{
            {8, 02, 22, 97, 38, 15, 0, 40, 0, 75, 04, 5, 7, 78, 52, 12, 50, 77, 91, 8},
            {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00},
            {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65},
            {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91},
            {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
            {24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
            {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
            {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
            {24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
            {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
            {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 0, 80, 4, 62, 16, 14, 9, 53, 56, 92},
            {16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57},
            {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
            {19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40},
            {04, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
            {88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
            {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
            {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16},
            {20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54},
            {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48},};

        int rows = 20;
        int columns = 20;

        int greatest = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (c < columns - 3) {
                    // Right and "Left"
                    if (greatest < grid[r][c] * grid[r][c + 1] * grid[r][c + 2] * grid[r][c + 3]) {
                        greatest = grid[r][c] * grid[r][c + 1] * grid[r][c + 2] * grid[r][c + 3];
                    }
                }

                if (r < rows - 3) {
                    // Down and "Up"
                    if (greatest < grid[r][c] * grid[r + 1][c] * grid[r + 2][c] * grid[r + 3][c]) {
                        greatest = grid[r][c] * grid[r + 1][c] * grid[r + 2][c] * grid[r + 3][c];
                    }

                    // Diagonally][ down to the right
                    if (c < columns - 3) {
                        if (greatest < grid[r][c] * grid[r + 1][c + 1] * grid[r + 2][c + 2] * grid[r + 3][c + 3]) {
                            greatest = grid[r][c] * grid[r + 1][c + 1] * grid[r + 2][c + 2] * grid[r + 3][c + 3];
                        }
                    }

                    // Diagonally][ down to the left
                    if (c > 3) {
                        if (greatest < grid[r][c] * grid[r + 1][c - 1] * grid[r + 2][c - 2] * grid[r + 3][c - 3]) {
                            greatest = grid[r][c] * grid[r + 1][c - 1] * grid[r + 2][c - 2] * grid[r + 3][c - 3];
                        }
                    }
                }
            }
        }
        int answer = greatest;
        return Integer.toString(answer);
    }

    public String problemTwelve() {

        int divisors = 0;
        int triangleNumber = 0;

        for (int i = 500; i < 10000; i++) {
            for (int j = 1; j <= i; j++) {
                triangleNumber += j;
            }
            for (int k = triangleNumber; k > 0; k--) {
                if (triangleNumber % k == 0) {
                    divisors++;
                }
            }
            if (divisors == 500) {
                return Integer.toString(triangleNumber);
            } else {
                divisors = 0;
                triangleNumber = 0;
            }
        }
        return "Error";
    }
}
