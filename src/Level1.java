public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] wordsFromString = s.split(" ");
        final int WORD_COUNT = wordsFromString.length;

        // производим разбивку строк по заданной ширине
        // если строка больше заданной ширины, разделяем строку пробелами
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < WORD_COUNT; i++) {
            while (wordsFromString[i].equals("")) {
                i++;
            }

            while (wordsFromString[i].length() > len) {
                tempString.append(wordsFromString[i], 0, len).append(" ");
                wordsFromString[i] = wordsFromString[i].substring(len);
            }

            tempString.append(wordsFromString[i]);

            if (i < WORD_COUNT - 1) {
                tempString.append(" ");
            }
        }

        // строка со словами не более заданной длины
        String splitString = tempString.toString();

        final int LIMITED_ROWS_LENGTH = splitString.length() / (len / 2) + 1;
        String[] limitedRows = new String[LIMITED_ROWS_LENGTH];

        // получаем массив строк заданной длинны
        int stringNumber = 0;
        while (splitString.length() != 0) {
            int ind = splitString.lastIndexOf(' ', len - 1);
            int sLen = splitString.length();

            if (sLen <= len) {
                limitedRows[stringNumber] = splitString.substring(0, sLen);
                splitString = splitString.substring(sLen);
            }

            else if (splitString.charAt(len) == ' ') {
                limitedRows[stringNumber] = splitString.substring(0, len);
                splitString = splitString.substring(len + 1);
            }

            else if (ind != -1) {
                limitedRows[stringNumber] = splitString.substring(0, ind);
                splitString = splitString.substring(ind + 1);
            }

            stringNumber++;
        }

        // создаем массив-маску для проверки
        // проверяем наличие искомого слова в строках
        int[] checkInKey = new int[stringNumber];
        for (int i = 0; i < checkInKey.length; i++) {
            if (limitedRows[i].matches("(?s).*\\b" + subs + "\\b.*")) {
                checkInKey[i] = 1;
            } else {
                checkInKey[i] = 0;
            }
        }

        return checkInKey;
    }

}
