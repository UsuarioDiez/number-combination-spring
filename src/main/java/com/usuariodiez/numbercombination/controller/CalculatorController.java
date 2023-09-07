package com.usuariodiez.numbercombination.controller;

import com.usuariodiez.numbercombination.model.IntegerArrayRequest;
import com.usuariodiez.numbercombination.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/find-combinations")
    @ResponseBody
    public List<List<Integer>> findSuccessfulCombinations(@RequestBody IntegerArrayRequest integerArrayRequest){
        return calculatorService.findCombinations(integerArrayRequest.getIntegers());
    }
}
