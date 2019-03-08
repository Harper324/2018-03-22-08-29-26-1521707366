package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        Stream<Integer[]> stream= Arrays.stream(array);
        Stream<Integer> oneDemensionalStream=stream.flatMap(ele->Arrays.stream(ele));
        return oneDemensionalStream.collect(Collectors.toList());
    }


    public List<Integer> transformToUnrepeatedOneDimesional() {
        List oneDimensionalList = transformToOneDimesional();
        Stream<Integer> stream=oneDimensionalList.stream().distinct();
        return stream.collect(Collectors.toList());
    }
}
