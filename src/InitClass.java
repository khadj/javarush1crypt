import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class InitClass {
    private final static Character[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', ':', '\"', '-', ' ', '?', '!'};

    public static Character[] getAbc() {
        return abc;
    }

    public static char[] initTextPlain(String inputFileName) throws IOException {

        Path pathToPlainTextFile = Path.of(inputFileName);

        String textFromPlainFile = Files.readString(pathToPlainTextFile);
        System.out.println("Исходный текст: " + textFromPlainFile);
        char[] charArray = textFromPlainFile.toCharArray();
        return charArray;
    }

    public static int getKey() {
        Scanner console = new Scanner(System.in);
        int key = console.nextInt();

        //Алгоритм для попадания в диапазон ключей для abc.length в классе Encryptor

        boolean isKey = key > -1 && key < 35;
        if (!isKey) {
            while (!(key > -1 && key < 35)) {
                System.out.println("Введен ключ вне диапазона. Повторите попытку: ");
                key = console.nextInt();
            }
        }
        return key;
    }

}
