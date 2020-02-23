package sw2_1;

import javax.swing.*;

/**
 * @author Mingjing Li This class contains the solution for Worksheet1
 */

public class Worksheet1 {
    private static int index=0;
    // Exercise 1

    static int power(int m, int n) {
        if(n==0)
            return 1;
        else
            return m*power(m,n-1);
    }

    static int fastPower(int m, int n) {
        if(n==0)
            return 1;
        if(n%2==0)
            return fastPower(m,n/2)*fastPower(m,n/2);
        else
            return m*fastPower(m,n-1);
    }

    // Exercise 2

    static List<Integer> negateAll(List<Integer> a) {
        if(a.isEmpty())
            return new List<Integer>();
        else
            return new List<Integer>(-a.getHead(),negateAll(a.getTail()));
    }

    // Exercise 3

    static int find(int x, List<Integer> a) {
        if(a.isEmpty())
            throw new IllegalArgumentException(x+" do not exist in the list!");
        if(!a.isEmpty()) {
            if (a.getHead() == x) {
                return index;
            }
            else {
                index++;
                return find(x, a.getTail());
            }
        }
        return index;
    }

    // Exercise 4

    static boolean allEven(List<Integer> a) {
        if(a.isEmpty())
            throw new IllegalArgumentException("This list is empty!");
        if(a.getTail().isEmpty())
            return a.getHead()%2==0;
        if(a.getHead()%2==0)
            return allEven(a.getTail());
        else
            return false;
    }

    // Exercise 5

    static List<Integer> evenNumbers(List<Integer> a) {
        if(a.isEmpty())
            return a;
        if(a.getHead()%2==0)
            return  new List<Integer>(a.getHead(),evenNumbers(a.getTail()));
        else
            return evenNumbers(a.getTail());
    }

    // Exercise 6

    static boolean sorted(List<Integer> a) {
        if(a.getTail().isEmpty())
        return true;
        if(a.getHead()<a.getTail().getHead())
            return false;
        if(a.getHead()>=a.getTail().getHead())
            return sorted(a.getTail());
        else
            return true;
    }

    // Exercise 7

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        if(a.isEmpty())
            return b;
        if(b.isEmpty())
            return a;
        if(a.getHead()>=b.getHead())
            return new List<Integer>(a.getHead(),merge(a.getTail(),b));
        else
            return new List<Integer>(b.getHead(),merge(a,b.getTail()));
    }

    // Exercise 8

    static List<Integer> removeDuplicates(List<Integer> a) {
        if(a.getTail().isEmpty())
            return new List<Integer>(a.getHead(),new List<Integer>());
        if(a.getHead()==a.getTail().getHead())
            return removeDuplicates(a.getTail());
        else
            return new List<Integer>(a.getHead(),removeDuplicates(a.getTail()));
    }
}
