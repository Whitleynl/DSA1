package src;

import java.util.Scanner;

public class Bernoulli {

    public static long getFactorial(int n){
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static Rational getBinomialCoefficient(int n, int k){ //
        long num = getFactorial(n);
        long den = getFactorial(n-k) * (getFactorial(k));
        return new Rational(num, den);
    }

    public static Rational getAofN(int n) {
        if(n==0) {
            return new Rational(1,1);
        }
        Rational sum = new Rational(0, 1);
        for (int k = 0; k <= n-1; k++) {
            Rational binomialCoeff = getBinomialCoefficient(n+1, k);
            Rational aOfK = getAofN(k);
            sum = sum.add(aOfK.mult(binomialCoeff));
        }
        return sum.mult(new Rational(-1, n+1));
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a non-negative integer: ");
        int n = input.nextInt();
        Rational aOfN = getAofN(n);
        System.out.println("The value of A(" + n + ") is: " + aOfN);
        input.close();
    }
}








