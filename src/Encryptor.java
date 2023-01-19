import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;


class Encryptor {
    static void encryptFile(String inputFileName, String outputFileName, int key) throws IOException {

        char[] abc = InitClass.getAbc();
        char[] charArray = InitClass.initTextPlain(inputFileName);

        StringBuilder stringBuilder = new StringBuilder();

//        for (char c : charArray) {
//            for (int j = 0; j < abc.length; j++) {
//                if (abc[j].toString().equalsIgnoreCase(String.valueOf(c))) {
//                    try {
//                        stringBuilder.append(abc[j + key]);
//                    } catch (ArrayIndexOutOfBoundsException e) {
//                        stringBuilder.append(abc[j - abc.length + key]);
//                    }
//                }
//            }
//        }
        for (char c : charArray) {
            if (c == '\n'){
                stringBuilder.append(c);
            }
            for (int j = 0; j < abc.length; j++) {
                if (abc[j] == (c)) {
                    try {
                        stringBuilder.append(abc[j + key]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        stringBuilder.append(abc[j - abc.length + key]);
                    }
                }
            }
        }
        String textToCipherFile = stringBuilder.toString();
        Path pathToCipherTextFile = Path.of(outputFileName);
        System.out.println("Зашифрованный текст: \n" + textToCipherFile);
        Files.write(pathToCipherTextFile, Collections.singleton(textToCipherFile));
    }
}
