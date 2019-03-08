package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Stream<Integer> series = getSeries(leftBorder, rightBorder);
        int sum = 0;
        sum = series.filter(ele -> ele % 2 == 0).reduce(0, (a, b) -> a + b);
        return sum;
    }

    public Stream<Integer> getSeries(int leftBorder, int rightBorder) {
        int firstNumber = Math.min(leftBorder, rightBorder);
        int lastNumber = Math.max(leftBorder, rightBorder);
        long length = lastNumber - firstNumber + 1;
        Stream<Integer> series = Stream.iterate(firstNumber, n -> n + 1).limit(length);
        return series;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Stream series = getSeries(leftBorder, rightBorder);
        int sum = 0;
        sum = (int) series.filter(ele -> (int) ele % 2 == 1).reduce(0, (a, b) -> (int) a + (int) b);
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        Stream<Integer> stream = arrayList.stream().map(ele -> 3 * ele + 2);
        return stream.reduce(0, (a, b) -> a + b);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 1) {
                result.add(arrayList.get(i) * 3 + 2);
            } else {
                result.add(arrayList.get(i));
            }
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        Stream<Integer> oddStream = arrayList.stream();
        int sum = oddStream.filter(element -> element % 2 == 1).
                map(element -> element * 3 + 5).reduce(0, (a, b) -> a + b);
        return sum;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        Stream<Integer> stream = arrayList.stream();
        Stream<Integer> evenStream = stream.filter(ele -> ele % 2 == 0);
        List evenArray = new ArrayList();
        for (int i = 0; i < arrayList.size(); i += 2) {
            evenArray.add(arrayList.get(i));
        }
        Reduce reduce = new Reduce(evenArray);
        return reduce.getOrderedMedian();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        double sum = 0;
        int number = 0;
        for (int i = 0; i < arrayList.size(); i += 2) {
            sum += arrayList.get(i);
            number++;
        }
        return sum / number;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        Stream<Integer> evenStream = getEvenOrOdd(arrayList, 0);
        return evenStream.anyMatch(ele -> ele == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        Stream<Integer> evenStream = getEvenOrOdd(arrayList, 0);
        List<Integer> unrepeated = evenStream.distinct().sorted().collect(Collectors.toList());
        return unrepeated;
    }

    public Stream<Integer> getEvenOrOdd(List<Integer> arrayList, int evenOrOdd) {
        Stream<Integer> evenOrOddStream = arrayList.stream().filter(ele -> ele % 2 == evenOrOdd);
        return evenOrOddStream;

    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Stream<Integer> evenArray = getEvenOrOdd(arrayList, 0).sorted();
        Stream<Integer> oddArray = getEvenOrOdd(arrayList, 1).sorted(Comparator.reverseOrder());
        Stream<Integer> result = concat(evenArray, oddArray);
        return result.collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List processedList = new ArrayList();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            processedList.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return processedList;
    }
}
