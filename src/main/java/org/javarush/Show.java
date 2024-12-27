package org.javarush;

import java.util.Scanner;

public class Show {
    static Scanner scan = new Scanner(System.in);

    private Show() {
    }

    public static int menu() {
        boolean isOk = false;
        int result = 4;
        while (!isOk) {
            System.out.println("Выберите опцию: ");
            System.out.println("1. Зашифровать текст");
            System.out.println("2. Расшифровать текст");
            System.out.println("3. Попробовать взломать текст");
            System.out.println("4. Выход");

            String str = scan.nextLine();
            if (isNumber(str)) {
                result = Integer.parseInt(str);
                if (result > 0 && result < 5)
                    isOk = true;
                else
                    System.out.println("Нет пункта с таким номером. Попробуйте еще раз");
            } else
                System.out.println("Введите номер пункта. Попробуйте еще раз");
        }
        return result;
    }

    public static boolean isNumber(String str) {
        boolean isDigits = true;
        for (int i = 0; i < str.length() && isDigits; i++) {
            if (str.charAt(0) == '-')
                continue;
            if (!Character.isDigit(str.charAt(i))) {
                isDigits = false;
            }
        }
        return isDigits;
    }
}
