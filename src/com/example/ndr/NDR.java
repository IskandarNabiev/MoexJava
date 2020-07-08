package com.example.ndr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NDR {

    static String baseToBase(String num, int base1, int base2) {
        int no = FromBaseToDec(num, base1);
        return FromDecToBase(no, base2);
    }

    static String FromDecToBase(int num, int base) {

        String result = "";
        int remain;
        // Преобразование входного числа задается основанием путем
        // многократного деления его на основание и получения остатка
        while (num > 0) {
            remain = num % base;
            if (base == 16) {
                if (remain == 10)
                    result += 'A';
                else if (remain == 11)
                    result += 'B';
                else if (remain == 12)
                    result += 'C';
                else if (remain == 13)
                    result += 'D';
                else if (remain == 14)
                    result += 'E';
                else if (remain == 15)
                    result += 'F';
                else
                    result += remain;
            } else
                result += remain;

            num /= base;
        }

        return new StringBuffer(result).reverse().toString();
    }

    static int FromBaseToDec(String num, int base) {

        if (base < 2 || (base > 10 && base != 16))
            return -1;

        int val = 0;
        int power = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = digitToVal(num.charAt(i));

            if (digit < 0 || digit >= base)
                return -1;

            val += digit * power;
            power = power * base;
        }

        return val;
    }

    static int digitToVal(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    public static void main(String [] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число, допустимых в системе счисления: ");
        String num = reader.readLine();
        System.out.print("Введите основание исходной системы счисления: ");
        int base1 = Integer.parseInt(reader.readLine());
        System.out.print("Введите основание целевой системы счисления: ");
        int base2 = Integer.parseInt(reader.readLine());
        System.out.println(baseToBase(num, base1, base2));

    }
}

