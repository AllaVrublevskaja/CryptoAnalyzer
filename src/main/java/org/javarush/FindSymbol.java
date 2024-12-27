package org.javarush;

import static java.lang.Math.abs;

public class FindSymbol {

    private FindSymbol(){}

    static Integer getKey() {
        Integer key = 0;
        boolean isOk = false;
        while (!isOk) {
            System.out.println("Введите цифровой ключ.");
            String str = Show.scan.nextLine();
            if (Show.isNumber(str)) {
                key = Integer.parseInt(str);
                isOk = true;
            } else
                System.out.println("Попробуйте еще раз.");
        }

        return key;
    }

    static char getSymbol(char symbol, Integer key) {
        Integer index;
        index = CryptoAnalyzer.ALPHABET.indexOf(symbol);

        if (key > 0)
            for (int j = 1; j <= key; j++) {
                if (index == CryptoAnalyzer.ALPHABET.size() - 1)
                    index = 0;
                else
                    index += 1;
            }
        else {
            key = abs(key);
            for (int j = 1; j <= abs(key); j++) {
                if (index == 0)
                    index = CryptoAnalyzer.ALPHABET.size() - 1;
                else
                    index -= 1;
            }
        }

        return CryptoAnalyzer.ALPHABET.get(index);
    }
}
