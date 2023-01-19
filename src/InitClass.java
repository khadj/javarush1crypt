import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class InitClass {
//    private final static Character[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
//            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', ':', '\"', '-', ' ', '?', '!'};
    private final static char[] abc = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л',
            'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы','Ь','Э','Ю','Я',
        'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
        'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы','ь','э','ю','я',
        '.', ',', ':', '\"', '-', ' ', '?', '!'};

    public static char[] getAbc() {
        return abc;
    }

    public static char[] initTextPlain(String inputFileName) throws IOException {

        Path pathToPlainTextFile = Path.of(inputFileName);

        String textFromPlainFile = Files.readString(pathToPlainTextFile);
        System.out.println("Исходный текст: \n" + textFromPlainFile + '\n');
        return textFromPlainFile.toCharArray();
    }

    public static int getKey() {
        Scanner console = new Scanner(System.in);
        int key = console.nextInt();

        //Алгоритм для попадания в диапазон ключей для abc.length в классе Encryptor

        boolean isKey = key > -1 && key < 74;
        if (!isKey) {
            while (!(key > -1 && key < 74)) {
                System.out.println("Введен ключ вне диапазона. Повторите попытку: ");
                key = console.nextInt();
            }
        }
        return key;
    }
}
