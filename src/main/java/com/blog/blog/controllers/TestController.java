package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    @ResponseBody
    private String sayHi() {
        return "<h1>Well, hi!</h1>";
    }

    @RequestMapping(path = "/howdy", method = RequestMethod.GET)
    @ResponseBody
    private String sayHowdy() {
        return "Howdy";
    }

    @GetMapping(path = "/greetings")
    @ResponseBody
    private String greet() {
        return "Greetings";
    }
    @RequestMapping("/name/{name}")
    @ResponseBody
    private String sayName(@PathVariable String name) {
        return name;
    }

    @GetMapping("favnum/{favnum}/leastfavnum/{leastnum}")
    @ResponseBody
    private String numMessage(@PathVariable int favnum, @PathVariable int leastnum) {
        String message = "";
        message += "Fav num is: " + favnum;
        message += "<br>";
        message += "Least fav num is: " + leastnum;
        return message;
    }
}
