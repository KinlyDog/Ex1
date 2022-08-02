public class Level1 {
    public static String[] testFunc(String str, int len) {
        double strLen = str.length();
        int size = (int)(strLen / len + 1);
        if (strLen / len != (int)(strLen / len)) {
            size++;
        }

        String[] tst = new String[size];
        for (int i = 0; i < tst.length; i++) {
            tst[i] = "";
        }

        char[] ca = str.toCharArray();
        int t = 1;
        int u = 0;

        for (int i = 0; i < strLen; i++) {
            if (u < len * t) {
                tst[t - 1] += ca[i];
                u++;
            }
            if (u == len * t) {
                t++;
            }
        }

        return tst;

    }
    public static int[] WordSearch(int len, String s, String subs) {
        String[] str = s.split(" ");
        String[] strTemp = new String[str.length];
        String[] strFin = new String[str.length];
        int t = 1;

        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > len * t) {
                String[] mas = testFunc(str[i], len);
                strTemp[i + t - 1] = mas[t - 1];
                t++;

            } else {
                strTemp[i] = str[i];
            }

        }

        for (int i = 0; i < str.length; i++) {
            strFin[i] = "";
        }

        int tmpCount = 0;
        String c;

        for (int i = 0; i < str.length; i++) {
            if (strFin[tmpCount].equals("")) c = "";
            else c = " ";

            if (strFin[tmpCount].length() + str[i].length() < len) {
                strFin[tmpCount] += c + str[i];
            } else {
                tmpCount++;
                strFin[tmpCount] += str[i];
            }

        }
        int[] ma = new int[tmpCount + 1];

        for (int i = 0; i < ma.length; i++) {
            if (strFin[i].matches("(?s).*\\b" + subs + "\\b.*")) {
                ma[i] = 1;
            } else
                ma[i] = 0;
        }


        return ma;
    }

    public static void main(String[] args) {
        int len = 12;
        String s = "1) разбивается на набор строк через выравнивание по заданной ширине. строк строк пристрочной 123456789112";
        String subs = "строк";
        testFunc("123456789012 123456789012 12345678910", len);
        WordSearch(len, s, subs);

        String[] oo = new String[100];

        for (int i = 0; i < 100; i++) {
            if (s.indexOf(" ") <= len) {
                oo[i] = s.substring(0, s.indexOf(" "));
                s = s.substring(s.indexOf(" ") + 1);
            }
        }
    }
}
