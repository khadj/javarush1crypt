import java.io.IOException;
import java.util.Scanner;
/*
C:\Users\AcerNitro5\Desktop\JavaRushProject1\textPlain.txt
-       Исходный текст
C:\Users\AcerNitro5\Desktop\JavaRushProject1\textCipher.txt
-       Зашифрованный текст
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к файлу с исходным текстом: ");
        String plainText = console.next();
        System.out.println("Введите путь к файлу с зашифрованным текстом: ");
        String cipherText = console.next();


        System.out.println("Что хотите сделать с файлом?\n" +
                "1. Шифровка\n" +
                "2. Подбор ключа методом BruteForce\n" +
                "3. Расшифровка\n" + "Сделайте выбор: 1, 2 или 3?");
        var variant = console.nextInt();


        switch (variant) {
            case 1: {
                System.out.println("Введите ключ для шифрования: ");
                int key = InitClass.getKey();
                Encryptor.encryptFile(plainText, cipherText, key);
                break;
            }

            case 2: {
                BruteForceKeyFinder.bruteForceForKey(cipherText);
                break;
            }

            case 3: {
                System.out.println("Введите ключ для расшифрования: ");
                int key = InitClass.getKey();
                Decryptor.decryptFile(cipherText, plainText, key);
                break;
            }
        }
    }
}
