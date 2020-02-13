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
 * 快速排序
 *
 * @author fankun
 * @version V1.0
 * @伪代码 快速排序，A是数组，n表示数组的大小
 * quick_sort(A, n) {
 *  * quick_sort_c(A, 0, n-1)
 *  * }
 * // 快速排序递归函数，p,r为下标
 * quick_sort_c(A, p, r) {
 * if p >= r then return
 * <p>
 * q = partition(A, p, r) // 获取分区点
 * quick_sort_c(A, p, q-1)
 * quick_sort_c(A, q+1, r)
 * }
 * <p>
 * <p>
 * partition(A, p, r) {
 * pivot := A[r]
 * i := p
 * for j := p to r-1 do {
 * if A[j] < pivot {
 * swap A[i] with A[j]
 * i := i+1
 * }
 * }
 * swap A[i] with A[r]
 * return i
 *
 * 想法：通过选择最右数为pivot，然后将数组变为小于和大于pivot的两段，然后不断分治。
 *
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(1)
 * 比归并的优点是原地排序。
 *
 * 可以用于得到第K大的元素
 *
 * @since 2020-01-30 11:30
 */
public class QuickSort {
    public static void sort(int[] a,int n) {
        sortInternal(a,0,n-1);
    }

    private static void sortInternal(int[] a, int p, int r) {
        //终止条件，分区只有一个元素
        if(p >= r)
            return;
        int q = partition(a,p,r);
        //递归进行分治
        sortInternal(a,p,q-1);
        sortInternal(a,q+1,r);
    }

    //进行分区，并返回分区点的位置
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i=p,j = p; // i，j两个坐标用来swap，如果小于pivot，才进行swap并且i++
        for (; j < r ; j++){
            if(a[j] < pivot){
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i = i+1;
            }
        }
        //对pivot元素和a[i]进行交换
        int tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] ints = { 3, 2, 1,8,7,6,5,4,9 };
        QuickSort.sort(ints,9);
        System.out.println(Arrays.toString(ints));
    }
}
