// Print the sum, difference and product of two complex numbers by creating a
// class named 'Complex' with separate methods for each operation whose real and imaginary 
// parts are entered by the user.
import java.util.*;
class Complex {
    int real;
    int imaginary;

    Complex( int real , int imaginary ) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static Complex add( Complex a, Complex b ) {
        Complex c = new Complex(0, 0);
        c.real = a.real + b.real;
        c.imaginary = a.imaginary + b.imaginary;
        return c;
    }

    public static Complex sub( Complex a , Complex b ) {
        Complex c = new Complex(0, 0);
        c.real = a.real - b.real;
        c.imaginary = a.imaginary - b.imaginary;
        return c;
    }

    public static Complex mul( Complex a , Complex b ) {
        Complex c = new Complex( 0 , 0);
        c.real = (a.real*b.real) - (a.imaginary*b.imaginary);
        c.imaginary = (a.real*b.imaginary) + (a.imaginary*b.real);
        return c;
    }

    public static Complex diff( Complex a , Complex b ) {
        Complex c = new Complex(0, 0);
        c.real = a.real - b.real;
        c.imaginary = a.imaginary - b.imaginary;
        return c;
    }

    public void printComplex() {
        if( real == 0 && imaginary != 0 ) {
            System.out.println(imaginary+"i");
        } else if( real != 0 && imaginary == 0 ) {
            System.out.println(real);
        } else {
            System.out.println(real+"+"+imaginary+"i");
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter real part of first number : ");
        int r1 = sc.nextInt();
        System.out.print("Enter imaginary part of first number : ");
        int i1 = sc.nextInt();
        Complex a = new Complex( r1,  i1);
        // a.printComplex();

        System.out.print("Enter real part of second number : ");
        int r2 = sc.nextInt();
        System.out.print("Enter imaginary part of seconde number : ");
        int i2 = sc.nextInt();
        Complex b = new Complex(r2, i2);
        // b.printComplex();

        Complex c =  Complex.add(a, b);
        System.out.print("Sum = ");
        c.printComplex();

        Complex d = Complex.sub(a, b);
        System.out.print("Sub = ");
        d.printComplex();

        Complex e = Complex.mul(a, b);
        System.out.print("MUl = ");
        e.printComplex();

        Complex f = Complex.diff(a, b);
        System.out.print("Diff = ");
        f.printComplex();

        sc.close();
    }
}