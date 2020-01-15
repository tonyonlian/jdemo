package com.tunyl.macher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author create by Tunyl on 2019/11/19
 * @version 1.0
 */
public class PatternDemo {
    public static void main(String[] args) {
        String regx = "\\bcat\\b";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher("cat this  catttt catro cat");
        while (matcher.find()) {
            System.out.println(matcher.start()+":"+matcher.end()+" result="+matcher.group());
        }
    }
}
