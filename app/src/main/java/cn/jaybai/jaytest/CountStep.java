package cn.jaybai.jaytest;

import java.util.Arrays;

/**
 * Created by jaybai on 2017/5/8.
 */

public class CountStep {
    /** 台阶数 */
//    private int _mStep = 0;
//
//    public CountStep(int n){
//        this._mStep = n;
//    }

    /** 交换数组的2个值 */
    private void swap(int[] array, int a, int b){
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    /** 从start后开始全排列 */
    public void permute(int[] array, int start){

        if (array == null)  return;
        if (start == array.length){
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; ++i){

                swap(array, start, i);
                while (array[start] == array[i] && start < array.length - 1){
                    start++;
                }
                if (start < array.length) {
                    permute(array, start + 1);
                }
                swap(array, start, i);
            }
        }
    }





//    public void printMethod(){
//        if (_mStep <= 0)
//            System.out.print("0步没法走呀");
//
//        if (_mStep == 1)
//            System.out.print("" + _mStep);
//
//        int twoCount = _mStep / 2;
//
//        for (int two = 0;  two <= twoCount; two ++) {
//            int one = _mStep - two; //本循环内有多少个1
//            final int amount = one + two;
//
//            if (one == 0) { //如果没有1
//                for (int j = 0; j < two; j++)
//                    System.out.print("2 ");
//                continue;
//            }
//
//            if (two == 0) { //如果没有2
//                for (int j = 0; j < _mStep; j++)
//                    System.out.print("1 ");
//                continue;
//            }
//
//            int[] oneTwo = new int[amount];
//            for (int i = 0, j = 0; i < amount; i++, j++) {
//                if(j < two)
//                    oneTwo[i] = 2;
//                else
//                    oneTwo[i] = 1;
//            }
//
//        }
//
//    }
}
