package com.fanchen.clearmind.leetcode.string;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        return checkNoTwoA(s) && checkNoContinueL(s);
    }

    private boolean checkNoContinueL(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1)== s.charAt(i + 2)&& s.charAt(i) == 'L') {
                return false;
            }
        }
        return true;
    }

    private boolean checkNoTwoA(String s) {
        boolean flag = true;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
