package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Filter {
    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        Stream<Integer> stream=array.stream();
        Stream<Integer> evenStream=stream.filter(ele->ele%2==0);
        return evenStream.collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        Stream<Integer> stream=array.stream();
        Stream<Integer> evenStream=stream.filter(ele->ele%3==0);
        return evenStream.collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        Stream<Integer> firstStream=firstList.stream();
        Stream<Integer> commonStream=firstStream.filter(ele->secondList.contains(ele));
        return commonStream.collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        Stream<Integer> stream=array.stream();
        Stream<Integer> noRepeatedStream=stream.distinct();
        return noRepeatedStream.collect(Collectors.toList());
    }
}