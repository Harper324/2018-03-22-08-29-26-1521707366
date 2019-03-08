package com.thoughtworks.collection;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {

        if (left < right) {
            return Stream.iterate(left, n -> n + 1).limit(right - left + 1).collect(Collectors.toList());
        } else {
            return Stream.iterate(left, n -> n - 1).limit(left - right + 1).collect(Collectors.toList());

        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        Add add = new Add();
        List allNumber = getListByInterval(left, right);
        Stream<Integer> evenStream = add.getEvenOrOdd(allNumber, 0);
        return evenStream.collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {

        IntStream stream = Arrays.stream(array);
        IntStream stream1 = stream.filter(ele -> ele % 2 == 0);
        return stream1.boxed().collect(Collectors.toList());

    }

    public int popLastElment(int[] array) {
        int lastElement;
        lastElement = array[array.length - 1];
        return lastElement;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        Stream<Integer> firstStream = Arrays.stream(firstArray).boxed();
        List<Integer> secondList=IntStream.of(secondArray).boxed().collect(Collectors.toList());
        Stream<Integer> secondStream = Arrays.stream(secondArray).boxed();

        List<Integer> list = firstStream.filter(t -> secondList.contains(t)).collect(Collectors.toList());
        return list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List firstList = new ArrayList(Arrays.asList(firstArray));
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (!firstList.contains(secondArray[j])) {
                    firstList.add(secondArray[j]);
                    break;
                }
            }
        }
        return firstList;
    }
}
