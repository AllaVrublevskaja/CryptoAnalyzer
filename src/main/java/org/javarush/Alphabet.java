package org.javarush;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    private Alphabet(){
    }

    public static List<Character> create(){
       List<Character> ALPHABET = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            ALPHABET.add(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            ALPHABET.add(ch);
        }
        for (char ch = 'А'; ch <= 'я'; ch++) {
            ALPHABET.add(ch);
        }
        for (char ch = ','; ch <= '.'; ch++) {
            ALPHABET.add(ch);
        }
        for (char ch = ':'; ch <= ';'; ch++) {
            ALPHABET.add(ch);
        }
        ALPHABET.add('!');

        return ALPHABET;
    }
}
