package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    private String stringReverse(@PathVariable String string) {
        String reversedString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString = reversedString + string.charAt(i);
        }
        return reversedString;
    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    private String stringCaps(@PathVariable String string) {
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    private String stringBoth(@PathVariable String string) {
        return stringCaps(stringReverse(string));
    }

//    @GetMapping("/string/{string}")
//    @ResponseBody
//    private String queryString(@RequestParam(value = "reverse", required = false), @PathVariable String string) {
//
//    }
    //  returns = string reversed or in caps or both based on parameters passed to the Query string
    //  (research how to capture Query string values in Spring MVC)
    //  (for example... "/string/steve?reverse=true&caps=false" should return "evets")
}
