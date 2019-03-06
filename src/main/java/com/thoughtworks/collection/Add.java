package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return getSumOfOddsOrEven(leftBorder, rightBorder, 0);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return getSumOfOddsOrEven(leftBorder, rightBorder, 1);
    }

    public int getSumOfOddsOrEven(int leftBorder, int rightBorder, int oddOrEven) {
        int firstNumber = Math.min(leftBorder, rightBorder);
        int lastNumber = Math.max(leftBorder, rightBorder);
        int firstOddOrEven = (firstNumber % 2 == oddOrEven) ? firstNumber : firstNumber + 1;
        int sum = 0;
        while (firstOddOrEven <= lastNumber) {
            sum += firstOddOrEven;
            firstOddOrEven += 2;
        }
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
        List evenArray = getEvenOrOdd(arrayList, 0);
        return evenArray.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List evenArray = getEvenOrOdd(arrayList, 0);
        List unrepeatedArray = new ArrayList();
        for (int i = 0; i < evenArray.size(); i++) {
            if (!unrepeatedArray.contains(evenArray.get(i))) {
                unrepeatedArray.add(evenArray.get(i));
            }
        }
        return unrepeatedArray;
    }

    public List<Integer> getEvenOrOdd(List<Integer> arrayList, int evenOrOdd) {
        List evenOrOddArray = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == evenOrOdd) {
                evenOrOddArray.add(arrayList.get(i));
            }
        }
        return evenOrOddArray;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List evenArray = getEvenOrOdd(arrayList, 0);
        List oddArray = getEvenOrOdd(arrayList, 1);
        Collections.sort(evenArray);
        Collections.sort(oddArray, Collections.reverseOrder());
        evenArray.addAll(oddArray);
        return evenArray;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List processedList = new ArrayList();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            processedList.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return processedList;
    }
}
