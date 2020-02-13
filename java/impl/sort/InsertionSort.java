/*
 * Copyright (c) 2001-2020 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package impl.sort;

import java.util.Arrays;

/**
 * 插入排序，原地排序，前段有序，后段无序。不断将后段数字插入到前段中。
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1)
 * 是稳定的排序算法
 *
 * @author fankun
 * @version V1.0
 * @since 2020-01-30 11:48
 */
public class InsertionSort {

    public static void sort(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j]>a[i]){
                    int tmp = a[i];
                    for (int k = i; k >j ; k--) {
                        a[k] = a[k-1];
                    }
                    a[j] = tmp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = { 3, 2, 1,8,7,6,5,4 };
        InsertionSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
