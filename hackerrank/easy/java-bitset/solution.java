import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void performOperation(BitSet b1, BitSet b2, String operation, int value) {
        switch (operation) {
            case "AND":
                b1.and(b2);
                break;
            case "OR":
                b1.or(b2);
                break;
            case "XOR":
                b1.xor(b2);
                break;
            case "FLIP":
                b1.flip(value);
                break;
            case "SET":
                b1.set(value);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        
        while (m-->0){
            String operation = scan.next();
            int bitIdentifier = scan.nextInt();
            int value = scan.nextInt();
            
            if (bitIdentifier == 1) {
                performOperation(b1, b2, operation, value);
            } else if (bitIdentifier == 2) {
                performOperation(b2, b1, operation, value);
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        scan.close(); 
}
}
