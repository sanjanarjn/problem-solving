package com.self.dsa.recursion;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.

23

ad
ae
af
bd
be
bf
cd
ce
cf

 */
public class Keypad {

    public static String[] keypad(int n){

        Map<Integer, Character[]> keypad = getKeypad();
        return getKeypadStrings(n, keypad);
    }


    private static String[] getKeypadStrings(int n, Map<Integer, Character[]> keypad) {
        if(n == 0 || n == 1) {
            return new String[]{""};
        }

        String[] smallStrings = getKeypadStrings(n/10, keypad);

        int lastDigit = n % 10;
        Character[] padChars = keypad.get(lastDigit);

        String[] answer = new String[padChars.length * smallStrings.length];
        int i = 0;
        for (char c: padChars) {
            for(String s:  smallStrings) {
                String newString = s + c;
                answer[i++] = newString;
            }
        }
        return answer;

    }

    private static Map<Integer, Character[]> getKeypad() {

        Map<Integer, Character[]> keypad = new HashMap<>(10);

        keypad.put(2, new Character[]{'a', 'b', 'c'});
        keypad.put(3, new Character[]{'d', 'e', 'f'});
        keypad.put(4, new Character[]{'g', 'h', 'i'});
        keypad.put(5, new Character[]{'j', 'k', 'l'});
        keypad.put(6, new Character[]{'m', 'n', 'o'});
        keypad.put(7, new Character[]{'p', 'q', 'r', 's'});
        keypad.put(8, new Character[]{'t', 'u', 'v'});
        keypad.put(9, new Character[]{'w','x', 'y', 'z'});

        return keypad;
    }
}
