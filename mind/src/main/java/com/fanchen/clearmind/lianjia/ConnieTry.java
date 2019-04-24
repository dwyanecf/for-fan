package com.fanchen.clearmind.lianjia;

import java.util.Scanner;

/**
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class ConnieTry {

    public static void main(String[] args) {
        int auditingscore = 0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your auditing socre:");
        auditingscore = keyboard.nextInt();

        if (auditingscore >= 75) {
            System.out.println("your result for cpa is " + "Pass");

            System.out.println("Congratulations!!!");
        } else {
            System.out.println("your result for cpa is " + "Failed");

            System.out.println("Come on, review for next time !!!");

        }
    }
}
