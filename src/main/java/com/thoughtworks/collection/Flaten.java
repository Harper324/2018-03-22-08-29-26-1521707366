package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List oneDimensionalList = new ArrayList();
        for (Integer[] arr : array) {
            for (Integer ele : arr) {
                oneDimensionalList.add(ele);
            }
        }
        return oneDimensionalList;
    }


    public List<Integer> transformToUnrepeatedOneDimesional() {
        List oneDimensionalList = transformToOneDimesional();
        List noRepeatedList = new ArrayList();
        for (Object ele : oneDimensionalList) {
            if (!noRepeatedList.contains(ele)) {
                noRepeatedList.add(ele);
            }
        }
        return noRepeatedList;
    }


}
