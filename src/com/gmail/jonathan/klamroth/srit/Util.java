package com.gmail.jonathan.klamroth.srit;

/**
 * Created by jonny on 24.06.16, added by CaM/7oCe6e on 05.09.24
 */
public class Util {

    public static void exitWithError (String msg) {
        System.out.println("error" + (msg != null ? ": " + msg : ""));
        System.exit(1);
    }

    public static String unescapeUnicode (String in) {
        String working = in;
        int index = working.indexOf("\\u");
        while (index > -1) {
            try {
                int length = working.length();
                if (index > length - 6) {
                    break;
                }
                int numStart = index + 2;
                int numFinish = numStart + 4;
                String substring = working.substring(numStart, numFinish);
                int number = Integer.parseInt(substring, 16);
                String stringStart = working.substring(0, index);
                String stringEnd = working.substring(numFinish);
                working = stringStart + ((char) number) + stringEnd;
                index = working.indexOf("\\u");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "ERROR_UNESCAPE_UNICODE";
            }
        }
        return working;
    }
}
