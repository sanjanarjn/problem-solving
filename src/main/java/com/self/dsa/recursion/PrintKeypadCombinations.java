package com.self.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintKeypadCombinations {

    public static void printKeypad(int input){
        Map<Integer, Character[]> keypad = getKeypad();

        int tens = 1;
        int temp = input;
        while(temp >= 9) {
            temp /= 10;
            tens *= 10;
        }
        List<String> output = new ArrayList<>();
        output.add("");
        printKeypadStrings(input, keypad, tens, output);
    }

    private static void printKeypadStrings(int n, Map<Integer, Character[]> keypad, int tens, List<String> output) {

        int firstDigit = tens > 0 ? n / tens : 0;
        if(firstDigit <= 1) {
            for(String out : output) {
                System.out.println(out);
            }
            return;
        }

        Character[] padChars = keypad.get(firstDigit);
        List<String> updatedOut = new ArrayList<>();

        //System.out.println("Digit is : "+firstDigit);
        for (char c : padChars) {
            for(String out: output) {
                updatedOut.add(out + c);
            }
        }
        printKeypadStrings(n % tens, keypad, tens/10, updatedOut);

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
