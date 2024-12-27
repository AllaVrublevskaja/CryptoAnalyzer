package org.javarush;

import java.nio.file.Path;

public class Item {

    static Path dataPath = Path.of("src/main/resources/data.txt");
    static Path encryptedPath = Path.of("src/main/resources/encrypted.txt");
    static Path decryptedPath = Path.of("src/main/resources/decrypted.txt");


    private Item() {}

    public static void executeTheItemOfMenu(int punkt) {
        switch (punkt) {
            case 1 -> CryptoAnalyzer.encryptedDecrypted(dataPath, encryptedPath);

            case 2 ->
                CryptoAnalyzer.encryptedDecrypted(encryptedPath, decryptedPath);

            case 3 -> BrutForce.brutForce();
        }
    }
}
