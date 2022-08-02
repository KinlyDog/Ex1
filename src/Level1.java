public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] strSplit = s.split(" ");
        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < strSplit.length; i++) {
            while (strSplit[i].equals("")) {
                i++;
            }

            while (strSplit[i].length() > len) {
                bld.append(strSplit[i].substring(0, len) + " ");
                strSplit[i] = strSplit[i].substring(len);
            }

            bld.append(strSplit[i]);

            if (i < strSplit.length - 1) {
                bld.append(" ");
            }
        }
        String str = bld.toString();

        int masLen = str.length() / (len / 2) + 1;
        String[] mas = new String[masLen]; // ?

        int t = 0;
        while (str.length() != 0) {
            int ind = str.lastIndexOf(' ', len - 1);
            int sLen = str.length();

            if (sLen <= len) {
                mas[t] = str.substring(0, sLen);
                str = str.substring(sLen);
            }

            else if (str.charAt(len) == ' ') {
                mas[t] = str.substring(0, len);
                str = str.substring(len + 1);
            }

            else if (ind != -1) {
                mas[t] = str.substring(0, ind);
                str = str.substring(ind + 1);
            }

            t++;
        }

        int[] ma = new int[t];
        for (int i = 0; i < ma.length; i++) {
            if (mas[i].matches("(?s).*\\b" + subs + "\\b.*")) {
                ma[i] = 1;
            } else {
                ma[i] = 0;
            }
        }

        return ma;
    }

}
