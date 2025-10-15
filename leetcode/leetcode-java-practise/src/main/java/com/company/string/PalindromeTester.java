package com.company.string;

import org.apache.commons.lang3.StringUtils;

public class PalindromeTester {

    public static void main(String[] args) {
        PalindromeTester tester = new PalindromeTester();
        System.out.println(tester.isPalindrome("aba"));
        System.out.println(tester.isPalindrome("abba"));
        System.out.println(tester.isPalindrome("abca"));
    }

    private boolean isPalindrome(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
