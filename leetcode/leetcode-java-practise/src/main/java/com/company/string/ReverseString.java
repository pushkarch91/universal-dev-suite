package com.company.string;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String name = "Pushkar";
        System.out.println(name);
        System.out.println(reverseString.reverse(name));
    }

    private String reverse(String name) {
        char[] chars = name.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

}
