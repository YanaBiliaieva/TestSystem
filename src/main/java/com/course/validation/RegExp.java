package com.course.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static boolean isCorrectLoginName(String data){
        if(data.equals(null))return false;
        if(data.length()<3)return false;

        String scriptStartCondition = "<script>\\w+";
        Pattern p = Pattern.compile(scriptStartCondition);
        Matcher m = p.matcher(data);
        if(m.matches()) return false;

        String scriptEndCondition = "\\w+</script>";
        p = Pattern.compile(scriptEndCondition);
        m = p.matcher(data);
        if(m.matches()) return false;

        //if not correct, has <script>
        String scriptCondition= "<script>\\w+</script>";
        p = Pattern.compile(scriptCondition);
        m = p.matcher(data);
        if(m.matches()) return false;

        ///if login start from number
        String firstNumberCondition = "\\d+\\w+";
        p = Pattern.compile(firstNumberCondition);
        m = p.matcher(data);
        if(m.matches()) return false;

        return true;
    }

    public static boolean isCorrectPassword(String data){
        if(data.equals(null))return false;
        if(data.length()<5)return false;

        ///if password start from number
        String firstNumberCondition = "\\d+\\w+";
        Pattern p = Pattern.compile(firstNumberCondition);
        Matcher m = p.matcher(data);
        if(m.matches()) return false;

        return true;
    }


}
