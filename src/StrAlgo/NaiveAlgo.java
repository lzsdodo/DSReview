package StrAlgo;

public class NaiveAlgo implements MatchString {

    @Override
    public boolean matchString(String s, String p) {
        if (s.length() < p.length()) return false;

        char[] sChars = s.toLowerCase().toCharArray();
        char[] pChars = p.toLowerCase().toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            for (int j = 0; j < pChars.length; j++) {
                if (pChars[j] != sChars[i+j]) break;
                if (j == pChars.length - 1) return true;
            }
        }
        return false;
    }
}
