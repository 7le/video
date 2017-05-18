package com.shine.video.util;

public class StringUtil {

    public static boolean isNotEmpty(String input){
        return !isEmpty(input);
    }

    public static boolean isEmpty(String input){
        if (input == null || input.trim().equals("")){
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
}
