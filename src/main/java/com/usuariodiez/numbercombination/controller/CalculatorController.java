package com.usuariodiez.numbercombination.controller;

import com.usuariodiez.numbercombination.model.IntegerArrayRequest;
import com.usuariodiez.numbercombination.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/test")
    @ResponseBody
    public List<List<Integer>> testing(@RequestBody IntegerArrayRequest integerArrayRequest){
        return calculatorService.findCombinations(integerArrayRequest.getIntegers());
    }
}
