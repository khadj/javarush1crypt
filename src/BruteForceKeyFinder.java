import java.io.IOException;


class BruteForceKeyFinder {


    static void bruteForceForKey(String cipherText) throws IOException {
//      System.out.println("Исходный текст: " + textFromPlainFile);
        char[] abc = InitClass.getAbc();
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = InitClass.initTextPlain(cipherText);


/*
Делаю массив строк из вариантов расшифрованных текстов перебираю ключи по алфавиту
Но получается массив, каждый новый элемент которого = предыдущий элемент + новый
*/
        int key = 0;
        String[] varsOfDecryptText = new String[abc.length];

//        while (key < abc.length) {
//            for (char c : charArray) {
//                for (int j = 0; j < abc.length; j++) {
//                    if (abc[j].toString().equalsIgnoreCase(String.valueOf(c))) {
//                        try {
//                            stringBuilder.append(abc[j + key]);
//                        } catch (ArrayIndexOutOfBoundsException e) {
//                            stringBuilder.append(abc[j - abc.length + key]);
//                        }
//                    }
//                    varsOfDecryptText[key] = stringBuilder.toString();
//                }
//            }
//            key++;
//        }
        while (key < abc.length) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '\n'){
                    stringBuilder.append(charArray[i]);
                }
                for (int j = 0; j < abc.length; j++) {
                    if (abc[j]==charArray[i]) {
                        try {
                            stringBuilder.append(abc[j + key]);
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            stringBuilder.append(abc[j - abc.length + key]);
                        }
                    }
                }
            }
            varsOfDecryptText[key] = stringBuilder.toString();
            key++;
        }

//        System.out.println(Arrays.toString(varsOfDecryptText));

//--------------------------------------------------------------------------------------------------------------------------


/*
Исходя из предыдущего алгоритма устанавливаю, что нулевой элемент массива это шифрованный текст,
а последний элемент массива это необходимый массив строк, с переборомвсех расшифрованных вариантов с ключами.
Последний элемент массива разбиваю на нужный массив расшифрованных строк.
*/

        String last = varsOfDecryptText[varsOfDecryptText.length - 1];
        String encText = varsOfDecryptText[0];

        String[] results = new String[abc.length];
        int count = 0;
        for (int i = 0; i < last.length(); i = i + (encText.length())) {
            results[count] = last.substring(i, encText.length() + i);
            count++;
        }
//        System.out.println(Arrays.toString(results));
//--------------------------------------------------------------------------------------------------------------------------


/*
Вытаскиваю наиболее, подходящий вариант, по условию
*/

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < results.length; i++) {
//            if ((results[i].endsWith("!\n") ||
//                    results[i].endsWith("?\n") ||
//                    results[i].endsWith(".\n"))) {
//                if ((results[i].contains(", ") || results[i].contains("! ") || results[i].contains("? ") || results[i].contains(". ") || results[i].contains(",\n")
////                                || results[i].contains("!\n")|| results[i].contains("?\n")|| results[i].contains(".\n"))
//                        && ((!results[i].contains(" ,") || !results[i].contains(" !") || !results[i].contains(" ?") || !results[i].contains(" .")
//                        || !results[i].startsWith("!")|| !results[i].startsWith("?")|| !results[i].startsWith(".")|| !results[i].startsWith(",")
//                        || !results[i].contains("\n!")|| !results[i].contains("\n.")|| !results[i].contains("\n,")|| !results[i].contains("\n?"))))) {
//                    sb.append(results[i]);
//                }
//            }
//        }
//        String decode = sb.toString();
////                System.out.println(decode);



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            if ((results[i].endsWith("!\n") ||
                    results[i].endsWith("?\n") ||
                    results[i].endsWith(".\n"))) {
                if (!results[i].contains(", ") && !results[i].contains("? ") && !results[i].contains("! ")
                        && !results[i].contains("!") && !results[i].contains(",") && !results[i].contains("?")){
                    sb.append(results[i]);
                }
                else if ((results[i].contains(", ") || results[i].contains("! ") || results[i].contains("? ") || results[i].contains(". ") || results[i].contains(",\n")
//                                || results[i].contains("!\n")|| results[i].contains("?\n")|| results[i].contains(".\n"))
                        && ((!results[i].contains(" ,") || !results[i].contains(" !") || !results[i].contains(" ?") || !results[i].contains(" .")
                        || !results[i].startsWith("!")|| !results[i].startsWith("?")|| !results[i].startsWith(".")|| !results[i].startsWith(",")
                        || !results[i].contains("\n!")|| !results[i].contains("\n.")|| !results[i].contains("\n,")|| !results[i].contains("\n?"))))) {
                    sb.append(results[i]);
                }
            }
        }

        String decode = sb.toString();
        System.out.println(decode);





//--------------------------------------------------------------------------------------------------------------------------


/*
Исходя из позиции первых символов зашифрованного и расшифрованного текстов вычисляю ключ (result)
*/
        char[] charsOfDec = decode.toCharArray();
        char[] charsOfEnc = encText.toCharArray();

        int posOfDec = 0;
        int posOfEnc = 0;


        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == charsOfDec[0]) {
                posOfDec = i;
            }
        }
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == charsOfEnc[0]) {
                posOfEnc = i;
            }
        }

        int result = posOfDec > posOfEnc ? abc.length + posOfEnc - posOfDec : Math.abs(posOfDec - posOfEnc);
        System.out.println("The Key is: " + result);
    }
}
