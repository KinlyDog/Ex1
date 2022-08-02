public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] mas = new String[s.length() / len + 1];
        String str = s;

        int t = 0;
        while (str.length() != 0) {
            int ind = str.lastIndexOf(' ', len - 1);
            int sLen = str.length();

            if (ind != -1) {
                mas[t] = str.substring(0, ind);
                str = str.substring(ind + 1);

            } else if (sLen >= len) {
                mas[t] = str.substring(0, len);
                str = str.substring(len + 1);

            } else {
                mas[t] = str.substring(0, sLen);
                str = str.substring(sLen);
            }

            t++;
        }

        int[] ma = new int[mas.length];
        for (int i = 0; i < ma.length; i++) {
            if (mas[i].matches("(?s).*\\b" + subs + "\\b.*")) {
                ma[i] = 1;
            } else
                ma[i] = 0;
        }

        return ma;
    }

    public static void main(String[] args) {
        int len = 12;
        String s = "1) строка разбивается на набор строк через выравнивание по заданной ширине.";
        String subs = "строк";
        WordSearch(len, s, subs);
    }
}
