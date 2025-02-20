package week04;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author japan
 */
public class Fraction {
    
    public int topN;
    public int btmN;

    public String toFraction() {
        return (topN + "/" + btmN);
    }

    public String toFloat() {
        return String.valueOf((double) topN / btmN);
    }

    public void addFraction(Fraction f) {
        if (btmN == f.btmN) {
            topN += f.topN;
        } else {
            topN = topN * f.btmN + f.topN * btmN;
            btmN *= f.btmN;
        }

    }

    public boolean myEquals(Fraction x) {
        double self = (double)topN / btmN;
        double other = (double)x.topN / x.btmN;
        return (Math.abs(self - other) < 0.00001);
    }

    public void LowestTermFrac() {
        int gcd;
        int b;
        int a;
        while (true) {
            a = topN;
            b = btmN;
            while (true) {
                if (b > a){
                    int temp = a;
                    a = b;
                    b = temp;
                }
                int remainder = a % b;
                if (remainder == 0) {
                    gcd = b;
                    break;
                }
                a = remainder;
            }
            if (gcd == 1) {
                return;
            } 
            topN /= gcd;
            btmN /= gcd;
        }
    }
}
