package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        Stream<Integer> stream = array.stream();
        return stream.map(ele -> ele * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        Stream<Integer> stream = array.stream();
        Stream<String> letterStream = stream.map(ele -> (Character.toString((char) (ele + 96))));
        return letterStream.collect(Collectors.toList());
    }


    public List<String> mapLetters() {
        Stream<String> letterStreamA=array.stream().filter(number->number<26).map(number->Character.toString((char)(number+96)));
        Stream<String> letterStreamB=array.stream().filter(number->number>=26).map(number->((char)((number-1)/26+96)+
                Character.toString((char)(((number-1)%26)+97))));
        List<String> letterList=Stream.concat(letterStreamA,letterStreamB).collect(Collectors.toList());
        return letterList;
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
