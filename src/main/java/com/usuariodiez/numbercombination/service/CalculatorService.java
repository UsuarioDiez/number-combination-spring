package com.usuariodiez.numbercombination.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculatorService {
    public List<List<Integer>> findCombinations(List<Integer> integers){
        System.out.println(integers);
        int maxValue=Collections.max(integers);
        integers.removeIf(integer -> integer==maxValue);
        System.out.println(integers);
        return getBinaryArrays(integers);
    }

    public List<List<Integer>> getBinaryArrays(List<Integer> integersToCombine){
        int nBinaryArrays= (int) (Math.pow(2,integersToCombine.size())-1);
        List<List<Integer>> result=new ArrayList<>();
        for (int i=1; i<=nBinaryArrays; i++){
            List<Integer> binary=new ArrayList<>();
            List<Integer> tmpBinary= Arrays.stream(Integer.toBinaryString(i).split("")).map(Integer::parseInt).collect(Collectors.toList());
            if (tmpBinary.size()<integersToCombine.size()){
                for (int j=0; j<(integersToCombine.size()-tmpBinary.size()); j++) binary.add(0);
            }
            binary.addAll(tmpBinary);
            result.add(binary);
        }
        return result;
    }
}
