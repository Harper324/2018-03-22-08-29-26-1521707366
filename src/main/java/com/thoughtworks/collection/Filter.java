package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Filter {
    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> evenList = new ArrayList<Integer>();
        for (Integer ele : array) {
            if (ele % 2 == 0) {
                evenList.add(ele);
            }
        }
        return evenList;
    }

    public List<Integer> filterMultipleOfThree() {
        ArrayList threeList = new ArrayList();
        for (Integer ele : array) {
            if (ele % 3 == 0) {
                threeList.add(ele);
            }
        }
        return threeList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        ArrayList<Integer> commonList = new ArrayList<>();
        for (Integer ele : firstList) {
            if (secondList.contains(ele)) {
                commonList.add(ele);
            }
        }
        return commonList;
    }

    public List<Integer> getDifferentElements() {
        ArrayList differentList = new ArrayList();
        for (Integer ele : array) {
            if (!differentList.contains(ele)) {
                differentList.add(ele);
            }
        }
        return differentList;
    }
}