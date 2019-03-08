package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.*;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        Optional<Integer> max = arrayList.stream().sorted(Comparator.reverseOrder()).findFirst();
        return max.get();
    }


    public double getMinimum() {
        Optional<Integer> min = arrayList.stream().sorted().findFirst();
        return min.get();
    }


    public double getAverage() {
        Stream<Integer> stream = arrayList.stream();
        return (double)stream.reduce(0, (a, b) -> a + b)/arrayList.size();
    }

    public double getOrderedMedian() {
        double length = arrayList.size() - 1;
        int leftMedian = arrayList.get((int) Math.floor(length / 2));
        int rightMedian = arrayList.get((int) Math.ceil(length / 2));
        return (double) (leftMedian + rightMedian) / 2;
    }

    public int getFirstEven() {
        Stream<Integer> stream = arrayList.stream();
        return stream.filter(ele -> ele % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEvenIndex = 0;
        for (Integer ele : arrayList) {
            if (ele % 2 == 0) {
                firstEvenIndex = arrayList.indexOf(ele);
                break;
            }
        }
        return firstEvenIndex;
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean result = true;
        if (this.arrayList.size() == arrayList.size()) {
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (!this.arrayList.get(i).equals(arrayList.get(i))) {
                    result = false;
                    break;
                }
            }
            return result;
        } else {
            return false;
        }
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        SingleLinkList<Integer> singleLinkList = new SingleLinkList<Integer>();
        for (Integer element : arrayList) {
            singleLinkList.addTailPointer(element);
            singleLink.addTailPointer(element);
        }
        double lastIndex = singleLinkList.size() - 1;
        int leftMedian = (int) singleLinkList.getNode((int) Math.floor(lastIndex / 2));
        int rightMedian = (int) singleLinkList.getNode((int) Math.ceil(lastIndex / 2));
        double median = (leftMedian + rightMedian) / 2.0;
        return median;
    }

    public int getLastOdd() {
        Add add = new Add();
        Stream<Integer> evenStream = add.getEvenOrOdd(arrayList, 1);
        List<Integer> evenList = evenStream.collect(Collectors.toList());
        return evenList.get(evenList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int indexOfLastOdd = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 1) {
                indexOfLastOdd = i;
            }
        }
        return indexOfLastOdd;
    }


}
