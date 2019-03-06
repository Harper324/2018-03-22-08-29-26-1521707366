package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List result = new ArrayList();
        if (left < right) {
            while (left <= right) {
                result.add(left);
                left++;
            }
        } else {
            while (left >= right) {
                result.add(left);
                left--;
            }
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        Add add = new Add();
        List allNumber = getListByInterval(left, right);
        List evenList = add.getEvenOrOdd(allNumber, 0);
        return evenList;
    }

    public List<Integer> popEvenElments(int[] array) {
        List evenList = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenList.add(array[i]);
            }
        }
        return evenList;
    }

    public int popLastElment(int[] array) {
        int lastElement;
        lastElement = array[array.length - 1];
        return lastElement;
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List commonElement = new ArrayList();
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    commonElement.add(firstArray[i]);
                    break;
                }
            }
        }
        return commonElement;
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
