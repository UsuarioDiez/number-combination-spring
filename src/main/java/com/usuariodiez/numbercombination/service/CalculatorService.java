package com.usuariodiez.numbercombination.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CalculatorService {
    public List<List<Integer>> findCombinations(List<Integer> integers){
        List<List<Integer>> successfulCombinations=new ArrayList<>();
        int maxValue=Collections.max(integers);
        integers.removeIf(integer -> integer==maxValue);
        var binaryArrays=getBinaryArrays(integers);
        binaryArrays.forEach(binaryArray->{
            int sum=0;
            List<Integer> combination=IntStream.range(0,integers.size()).map(i->integers.get(i)*binaryArray.get(i)).boxed().filter(i->i!=0).collect(Collectors.toList());
            if (combination.stream().mapToInt(Integer::intValue).sum()==maxValue) successfulCombinations.add(combination);
        });
        return successfulCombinations;
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
