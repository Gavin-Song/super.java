/** Alternative to System.out
 * Features:
 *  > Displays all array contents instead of memory location
 *  > Multi parameter print
 *  > println() simply makes a newline */

import java.util.Arrays;

public class SuperPrint {
    private SuperPrint(){}

    public static void print(Object x) {
        System.out.print(x);
    }
    public static void print(char x) {
        System.out.print(x);
    }
    public static void print(int x) {
        System.out.print(x);
    }
    public static void print(double x) {
        System.out.print(x);
    }
    public static void print(float x) {
        System.out.print(x);
    }
    public static void print(short x) {
        System.out.print(x);
    }
    public static void print(long x) {
        System.out.print(x);
    }
    public static void print(boolean x) {
        System.out.print(x);
    }
    public static void print(byte x) {
        System.out.print(x);
    }

    public static void println() {
        System.out.println("");
    }
    public static void println(Object x) {
        System.out.println(x);
    }
    public static void println(char x) {
        System.out.println(x);
    }
    public static void println(int x) {
        System.out.println(x);
    }
    public static void println(double x) {
        System.out.println(x);
    }
    public static void println(float x) {
        System.out.println(x);
    }
    public static void println(short x) {
        System.out.println(x);
    }
    public static void println(long x) {
        System.out.println(x);
    }
    public static void println(boolean x) {
        System.out.println(x);
    }
    public static void println(byte x) {
        System.out.println(x);
    }

    public static <T> void print(T... a) {
        System.out.print(Arrays.deepToString(a));
    }
    public static void print(char... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(int...a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(double... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(float... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(short... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(long... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(boolean... a) {
        System.out.print(Arrays.toString(a));
    }
    public static void print(byte... a) {
        System.out.print(Arrays.toString(a));
    }

    public static <T> void println(T... a) {
        System.out.println(Arrays.deepToString(a));
    }
    public static void println(char... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(int... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(double... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(float... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(short... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(long... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(boolean... a) {
        System.out.println(Arrays.toString(a));
    }
    public static void println(byte... a) {
        System.out.println(Arrays.toString(a));
    }
}
