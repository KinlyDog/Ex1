public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] wordsFromString = s.split(" ");
        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < wordsFromString.length; i++) {
            while (wordsFromString[i].equals("")) {
                i++;
            }

            while (wordsFromString[i].length() > len) {
                bld.append(wordsFromString[i].substring(0, len) + " ");
                wordsFromString[i] = wordsFromString[i].substring(len);
            }

            bld.append(wordsFromString[i]);

            if (i < wordsFromString.length - 1) {
                bld.append(" ");
            }
        }

        String str = bld.toString();

        int masLen = str.length() / (len / 2) + 1;
        String[] limitedRows = new String[masLen]; // ?

        int stringNumber = 0;
        while (str.length() != 0) {
            int ind = str.lastIndexOf(' ', len - 1);
            int sLen = str.length();

            if (sLen <= len) {
                limitedRows[stringNumber] = str.substring(0, sLen);
                str = str.substring(sLen);
            }

            else if (str.charAt(len) == ' ') {
                limitedRows[stringNumber] = str.substring(0, len);
                str = str.substring(len + 1);
            }

            else if (ind != -1) {
                limitedRows[stringNumber] = str.substring(0, ind);
                str = str.substring(ind + 1);
            }

            stringNumber++;
        }

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
