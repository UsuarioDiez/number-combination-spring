package com.usuariodiez.numbercombination.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {
    public List<Integer> findCombinations(List<Integer> numbers){
        return List.of(1);
    }

    public String  getBinaryArrays(List<Integer> numbers){
        int nBinaryArrays= (int) (Math.pow(2,numbers.size())-1); 
        StringBuilder result= new StringBuilder();
        for (int i=0; i<nBinaryArrays; i++){
            result.append(Integer.toBinaryString(i));
        }
        return result.toString();
    }
}
