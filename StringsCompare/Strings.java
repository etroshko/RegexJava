package StringsCompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringsCompare implements Comparator<String>
{
    private static Comparator<String> comparator=new StringsCompare();
    private static String stringOfConsonants="bcdfghjklmnpqrstvwxyz";
    public static Comparator<String> getComparator()
    {
        return comparator;
    }
    public static boolean isConsonant(Character character)
    {
        return stringOfConsonants.indexOf(Character.toLowerCase(character))!=-1;
    }
    private Character getFirstConsonant(String string)
    {
        for (int i=0; i<string.length(); ++i)
            if (isConsonant(string.charAt(i)))
                return string.charAt(i);
        return Character.MIN_VALUE;
    }
    @Override
    public int compare(String a, String b)
    {
        Character consonantA=getFirstConsonant(a);
        Character consonantB=getFirstConsonant(b);
        return consonantA.compareTo(consonantB);
    }
}
public class Strings
{
    public static void main(String[] args)
    {
        String text = "  important meeting. And only at 8 o'clock he came home.";
        System.out.println(text);
        Pattern p = Pattern.compile(",+|-+|\\d+|'|\\.+");
        Matcher m = p.matcher(text);
        text = m.replaceAll("");
        Pattern p2 = Pattern.compile("\\s+");
        Matcher m2 = p2.matcher(text);
        text = m2.replaceAll("  ");
        Pattern p1 = Pattern.compile("\\s[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ][a-z]+");
        Matcher m1 = p1.matcher(text);
        text = m1.replaceAll("");
        Pattern p3 = Pattern.compile("\\s+");
        Matcher m3 = p3.matcher(text);
        text = m3.replaceAll(" ");
        ArrayList<String> wordsMod = new ArrayList<String>(Arrays.asList(text.split(" ")));
        Collections.sort(wordsMod, StringsCompare.getComparator());
        System.out.println(wordsMod);
    }
}