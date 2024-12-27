package org.javarush;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.javarush.Item.encryptedPath;

public class BrutForce {
    static String dictionary;
    static String encrypted;

    private static Integer beginOfKeyInterval;
    private static Integer endOfKeyInterval;

    private BrutForce() {
    }

    static void brutForce(){
        Path dictionaryPath = Path.of("src/main/resources/dictionary.txt");

        String[] words = getWordsForDecrypt(dictionaryPath);
        Integer key = getKeyForDecrypt(words);

        if(key != 0)
            System.out.println("Ключ для дешифровки может быть таким: " + key + " Попробуйте.");
        else
            System.out.println("В этом диапазоне ключ не найден...");
    }

    private static String[] getWordsForDecrypt(Path dictionaryPath) {
        String[] words = {};
        try {
            dictionary = Files.readString(dictionaryPath);
            encrypted = Files.readString(encryptedPath);
            words = encrypted.split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;
    }

    private static Integer getKeyForDecrypt(String[] words) {
        enterTheKeyInterval();
        for (Integer key = beginOfKeyInterval; key < endOfKeyInterval; key++) {
            long countSuccessfulDecrypt = 0;
            for (String word : words) {
                    countSuccessfulDecrypt = countWordsDecryptSuccessful(word, key, countSuccessfulDecrypt);
                    if(key == possibleKeyForDecrypt(words, key, countSuccessfulDecrypt))
                        return key;
            }
        }

        return 0;
    }

    private static void enterTheKeyInterval() {
        System.out.println("Интервал ключей для перебора.");
        System.out.print("Начало:  ");
        beginOfKeyInterval = FindSymbol.getKey();
        System.out.print("Конец:  ");
        endOfKeyInterval = FindSymbol.getKey();
    }

    private static long countWordsDecryptSuccessful(String word, Integer key, long countSuccessfulDecrypt) {
        String wordDecrypt = CryptoAnalyzer.buildValueOut(word, key);
        wordDecrypt = wordDecrypt.replace("\n", "");
        if (dictionary.contains(wordDecrypt))
            countSuccessfulDecrypt++;

        return countSuccessfulDecrypt;
    }

    private static Integer possibleKeyForDecrypt(String[] words, Integer key, long countSuccessfulDecrypt){
        long countOfWords = words.length;
        if (countSuccessfulDecrypt > 0 && countSuccessfulDecrypt * 100 / countOfWords >= 60) {

            return key;
        }

        return 0;
    }
}
