package org.javarush;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CryptoAnalyzer {

    static List<Character> ALPHABET = Alphabet.create();

    private CryptoAnalyzer() {
    }

    public static void encryptedDecrypted(Path fileIn, Path fileOut)  {

        try (BufferedReader reader = Files.newBufferedReader(fileIn)){

            Files.deleteIfExists(fileOut);
            Files.createFile(fileOut);

            if(!Files.exists(fileIn))
                Files.createFile(fileIn);

            Integer key = FindSymbol.getKey();
            String valueIn;

            while ((valueIn = reader.readLine()) != null) {
                String valueOut = buildValueOut(valueIn, key);
                Files.write(fileOut, valueOut.getBytes(), StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static String buildValueOut(String valueIn, Integer key) {

        StringBuilder valueOut = new StringBuilder();
        char symbol;

        for (int i = 0; i < valueIn.length(); i++) {
            symbol = valueIn.charAt(i);

            if (ALPHABET.contains(symbol))
                symbol = FindSymbol.getSymbol(symbol, key);

            valueOut.append(symbol);
        }

        return valueOut.append("\n").toString();
    }
}
