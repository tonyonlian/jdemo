package com.tunyl.macher;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author create by Tunyl on 2019/11/16
 * @version 1.0
 */
public class PatternTest {
    public static void main(String[] args) {
        String regex = "\\d{8}";
        String str = "12345678";
        System.out.println(str.matches(regex));
        find();
        findGroup();
        String regex1 = "\\s+";
        String str1 = "hello   world       goood";
        System.out.println(str1.replaceAll(regex1,""));
        String regex3 = "(\\d{4})-(\\d{2})-(\\d{2})";
        String str3 = "today is 2017-06-02";
        System.out.println(str3.replaceFirst(regex3,"$1/$2/$3"));
        replaceCat();
        String template = "Hi {name}, your code is {code}";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "tunyl");
        params.put("code",9000);
        System.out.println(templateEngine(template,params));
    }

    public static void find(){
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        String str = "today is 2017-06-02, yesterday is 2017-06-01";
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println("find "+ matcher.group() +" position: "+matcher.start()+"_"+matcher.end());
        }
    }
    public static void findGroup(){
        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        String str = "today is 2017-06-02, yesterday is 2017-06-01";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println("year:"+ matcher.group(1)+" month:"+matcher.group(2) +" day:"+matcher.group(3));
        }
    }
    public static void replaceCat(){
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat, two cat, three cat");
        StringBuffer sb = new StringBuffer();
        int foundNum = 0;
        while(m.find()){
            m.appendReplacement(sb,"dog");
            foundNum++;
            if(foundNum == 2){
                break;
            }
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }


    public static Pattern templatePattern = Pattern.compile("\\{(\\w+)\\}");

    public static String templateEngine(String templatem, Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        Matcher matcher = templatePattern.matcher(templatem);
        while (matcher.find()) {
            String key = matcher.group(1);
            Object value = params.get(key);
            matcher.appendReplacement(sb , value != null ? Matcher.quoteReplacement(value.toString()) : "");

        }
        matcher.appendTail(sb);
        return sb.toString();

    }

    public void test() {
        String str = "(map(+)('foo')";


    }
}
