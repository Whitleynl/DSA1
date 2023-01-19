package src;

class Rational {
    long num; // The numerator
    long den; // The denominator
    public Rational(long x, long y) {
        num = x;
        den = y; }
    public Rational add(Rational a) {
        return reduce(new Rational(num * a.den + a.num * den, den * a.den));
    }//add1
    public Rational add(long a) {
        return reduce(new Rational(num + a * den, den));
    }//add2
    public Rational sub(Rational a) {
        return reduce(new Rational(num * a.den - a.num * den, den * a.den));
    }//sub1
    public Rational sub(long a) {
        return reduce(new Rational(num - a * den, den));
    }// sub2
    public Rational mult(Rational a) {
        return reduce(new Rational(num * a.num, den * a.den));
    }//mult1
    public Rational mult(long n) {
        return reduce(new Rational(num * n, den));
    }//mult2
    public Rational div(Rational a) {
        return reduce(new Rational(num * a.den, den * a.num));
    }//div1
    public Rational div(long n) {
        return reduce(new Rational(num, den * n));
    }//div2
    public Rational reduce(Rational a) {
        long gcd;
        if (a.den < 0) {
            a.den = -a.den;
        }  a.num = -a.num;
        gcd = euclid(Math.abs(a.num), Math.abs(a.den));
        a.num /= gcd;
        a.den /= gcd;
        return a;
    }//reduce
    // Euclid's algorithm
    private long euclid(long a, long b) {
        if (b == 0)
            return a;
        else return euclid(b, a % b); }//euclid
    // will display a rational number in the form num / den
    public String toString() {
        if (num==0)
            return "0";
        else if (num==den)
            return "1";
        else return (num+"/"+den); }//toString
}//src.Rational