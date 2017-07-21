package com.course;

import com.course.validation.RegExp;

/**
 * Created by Яна on 21.07.2017.
 */
public class Start {
    public static void main(String[] args) {
//        String data = "<script>q4</script>";
        String data = "we";
        System.out.println(RegExp.isCorrectLoginName(data));
    }
    
}
