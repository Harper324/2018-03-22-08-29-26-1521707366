package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        Collections.sort(arrayList);
        return arrayList.get(arrayList.size() - 1);
    }

    public double getMinimum() {
        Collections.sort(arrayList);
        return (double) arrayList.get(0);
    }

    public double getAverage() {
        double sum = 0;
        for (Integer ele : arrayList) {
            sum += ele;
        }
        return sum / arrayList.size();
    }

    public double getOrderedMedian() {
        double length = arrayList.size() - 1;

        int leftMedian = arrayList.get((int) Math.floor(length / 2));
        int rightMedian = arrayList.get((int) Math.ceil(length / 2));

        return (double) (leftMedian + rightMedian) / 2;
    }

    public int getFirstEven() {
        int firstEven = 0;
        for (Integer ele : arrayList) {
            if (ele % 2 == 0) {
                firstEven = ele;
                break;
            }
        }
        return firstEven;
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
        SingleLinkList<Integer> singleLinkList=new SingleLinkList<Integer>();
     for(Integer element:arrayList){
         singleLinkList.addTailPointer(element);

     }
     double lastIndex=singleLinkList.size()-1;
     int leftMedian=(int)singleLinkList.getNode((int)Math.floor(lastIndex/2));
     int rightMedian=(int)singleLinkList.getNode((int)Math.ceil(lastIndex/2));
     double median=(leftMedian+rightMedian)/2;
     return median;
    }

    public int getLastOdd() {
        Add add=new Add();
        List evenList=add.getEvenOrOdd(arrayList,1);

        return (int) evenList.get(evenList.size()-1);
    }

    public int getIndexOfLastOdd() {
    int indexOfLastOdd=0;
    for(int i=0;i<arrayList.size();i++){
        if(arrayList.get(i)%2==1) {
            indexOfLastOdd=i;
        }
    }
    return indexOfLastOdd;
    }
}
