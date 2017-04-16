package com.IoA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Honsen on 2016/10/25.
 * @author Honsen
 */
public class Sort {
    /**
     * 插入排序
     * @param a 传入的arrayList
     *
     */
    public static void insertSort(ArrayList<Map.Entry<String,Integer>> a){
        int length=a.size(); //数组长度
        int j;				 //当前值的位置
        int i;				 //指向j前的位置
        Map.Entry<String,Integer> key;			 //当前要进行插入排序的值
        //从数组的第二个位置开始遍历值
        for(j=1;j<length;j++){
            key=a.get(j);
            i=j-1;
            //a[i]比当前值小时，a[i]后移一位,空出i的位置，好让下一次循环的值后移
            while(i>=0 &&(a.get(i).getValue()<key.getValue()||
                        (Objects.equals(a.get(i).getValue(), key.getValue()) &&
                                ( countUpper(a.get(i).getKey())<countUpper(key.getKey())||
                                compareFirstLetter(a.get(i).getKey(),key.getKey()))))){
                a.set(i+1,a.get(i)); //将a[i]值后移
                i--;   		 //i前移
            }
            //跳出循环(找到要插入的中间位置或已遍历到0下标)
            a.set(i+1,key);    //将当前值插入
        }
    }

    /**
     * 堆排序
     * @param array 进行排序的arrayList
     */
    public static void heapSort(ArrayList<Map.Entry<String,Integer>> array) {
        if (array == null || array.size() <= 1) {
            return;
        }
        buildMinHeap(array);

        for (int i = array.size() - 1; i >= 1; i--) {
            Collections.swap(array,0,i);
            minHeap(array, i, 0);
        }
        //
        insertSort(array);
    }

    /**
     * 建堆
     * @param array
     */
    private static void buildMinHeap(ArrayList<Map.Entry<String,Integer>> array) {
        if (array == null || array.size() <= 1) {
            return;
        }

        int half = array.size() / 2;
        for (int i = half; i >= 0; i--) {
            minHeap(array, array.size(), i);
        }
    }

    private static void minHeap(ArrayList<Map.Entry<String,Integer>> array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array.get(left).getValue()< array.get(index).getValue()) {
            largest = left;
        }

        if (right < heapSize && array.get(right).getValue() < array.get(largest).getValue()) {
            largest = right;
        }

        if (index != largest) {
            Collections.swap(array,index,largest);
            minHeap(array, heapSize, largest);
        }
    }

    /**
     * 归并排序
     * 稳定排序方式
     * @param array 待排序list
     */
    public static void mergeSort(ArrayList<Map.Entry<String,Integer>> array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(array, low, mid);
            // 右边
            mergeSort(array, mid + 1, high);
            // 左右归并
            merge(array, low, mid, high);
        }
    }

    private static void merge(ArrayList<Map.Entry<String,Integer>> array, int low, int mid, int high) {
        ArrayList<Map.Entry<String,Integer>> temp = new ArrayList<Map.Entry<String,Integer>>();
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (array.get(i).getValue() > array.get(j).getValue()||
                    (Objects.equals(array.get(i).getValue(), array.get(j).getValue())&&
                            (countUpper(array.get(i).getKey())>countUpper(array.get(j).getKey())||
                                    !compareFirstLetter(array.get(i).getKey(),array.get(j).getKey())))) {
                //
                temp.add(array.get(i++));
            } else {
                temp.add(array.get(j++));
            }
        }
        while (i <= mid) {
            temp.add(array.get(i++));
        }

//        (Objects.equals(array.get(i).getValue(), array.get(j).getValue())
//                ||countUpper(array.get(i).getKey())>countUpper(array.get(j).getKey()))
        while (j <= high)
            temp.add(array.get(j++));

        for (int k2 = 0; k2 < temp.size(); k2++) {
//            array[k2 + low] = temp[k2];
            array.set(k2+low,temp.get(k2));
        }
    }

    /**
     * 快速排序
     * @param array 待排链表
     * @param left 左起始位
     * @param right 右起始位
     *
     */
    public static void quickSort(ArrayList<Map.Entry<String,Integer>> array, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(array, left, right);
            quickSort(array, left, dp - 1);
            quickSort(array, dp + 1, right);
        }
//        insertSort(array);
    }

    private static int partition(ArrayList<Map.Entry<String, Integer>> array, int left, int right) {
        //取最右侧
        Map.Entry<String,Integer> pivot = array.get(right);

        while (left < right) {
            //左侧先移动 直到
            while (left < right && (array.get(left).getValue() >= pivot.getValue()))
                left++;
            if (left < right)
                array.set(right--,array.get(left));
            //右侧后移动
            while (left < right && (array.get(right).getValue() <= pivot.getValue()))
                right--;
            if (left < right)
                array.set(left++,array.get(right));
        }
        array.set(left,pivot);
        return left;
    }


    /**
     * 统计大小写
     * @param str 待统计字符串
     * @return 计数
     *
     */
    private static int countUpper(String str){
        int count=0;
        for (char c:str.toCharArray()){
            if (Character.isUpperCase(c))
                count++;
        }
        return count;
    }

    /**
     *
     * @param a 比较的第一个字符串
     * @param b 比较的第二个字符串
     * @return 若a的字符串ascii码在b之前则返回为true
     */
    private static boolean compareFirstLetter(String a,String b){
        return Character.toUpperCase(a.charAt(0))>Character.toUpperCase(b.charAt(0));
    }

}