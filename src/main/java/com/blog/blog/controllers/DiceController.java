package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("roll-dice")
    public String returnRollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String returnResults(@PathVariable int num, Model viewModel) {
        viewModel.addAttribute("answer", generateRandomNumber());
        viewModel.addAttribute("userGuess", num);
        return "roll-results";
    }

    private int generateRandomNumber() {
        return new Random().nextInt((6-1)+1)+1;
    }
}
