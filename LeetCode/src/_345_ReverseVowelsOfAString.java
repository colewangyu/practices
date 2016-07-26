import java.util.Scanner;

/**
 * Created by cole on 2016-04-30 Saturday.
 */
public class _345_ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("reca car"));
    }

    public static String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        char tmpChar;
        int i = 0,j = c.length - 1;
        for(; i < c.length; i++) {
            if(c[i] == 'a' ||c[i] == 'e' ||c[i] == 'i' ||c[i] == 'o' ||c[i] == 'u'||c[i] == 'A' ||c[i] == 'E' ||c[i] == 'I' ||c[i] == 'O' ||c[i] == 'U') {
                for(; j > i; j--) {
                    if(c[j] == 'a' ||c[j] == 'e' ||c[j] == 'i' ||c[j] == 'o' ||c[j] == 'u'||c[j] == 'A' ||c[j] == 'E' ||c[j] == 'I' ||c[j] == 'O' ||c[j] == 'U') {
                        tmpChar = c[i];
                        c[i] = c[j];
                        c[j] = tmpChar;
                        j--;
                        break;
                    }
                }
            }
        }
        for(char t : c) {
            sb.append(t);
        }
        return sb.toString();
    }
}
