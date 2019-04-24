package com.fanchen.clearmind.lianjia;

/**
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(indexA>=0 || indexB>=0){
            int sum =carry;
            if(indexA >=0){
                sum = sum + aChar[indexA--]-'0';
            }
            if(indexB >=0){
                sum = sum + bChar[indexB--]-'0';
            }
            carry = sum/2;
            sum = sum%2;
            sb.append(sum);
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
