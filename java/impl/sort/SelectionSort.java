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
 * 选择排序类似于插入排序，也分已排序和未排序区间。
 * 但是和插入排序不同，选择排序是从未排序中选择最小的，放入已排序部分的末尾
 *
 * @author fankun
 * @version V1.0
 * @since 2020-01-30 11:49
 */
public class SelectionSort {

    public static void sort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = a[i];
            int minc = i;
            for (int j = i+1; j < length; j++) {
                if(a[j] < min) {
                    min = a[j];
                    minc = j;
                }
            }
            min = a[minc];
            a[minc] = a[i];
            a[i] = min;
        }

    }

    public static void main(String[] args) {
        int[] ints = { 3, 2, 1,8,7,6,5,4 };
        SelectionSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
