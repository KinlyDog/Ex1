public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        String[] strTmp = s.split(" ");
        String str = "";

        for (int i = 0; i < strTmp.length; i++) {
            while (strTmp[i].equals("")) {
                i++;
            }

            while (strTmp[i].length() > len) {
                str += strTmp[i].substring(0, len) + " ";
                strTmp[i] = strTmp[i].substring(len);
            }

            str += strTmp[i];

            if (i < strTmp.length - 1) {
                str += " ";
            }
        }

        String[] mas = new String[str.length() / len + 1];

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
        String s = "   1234567891123 1) строка разбивается на набор строк через выравнивание по заданной ширине. еще теккста добавиммммммм для проверкеиии";
        String subs = "строк";
        WordSearch(len, s, subs);
    }
}
