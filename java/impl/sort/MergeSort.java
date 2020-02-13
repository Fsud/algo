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
 * 排序实现归并排序、快速排序、插入排序、冒泡排序、选择排序
 * 编程实现 O(n) 时间复杂度内找到一组数据的第 K 大元素
 *
 * 二分查找
 * 实现一个有序数组的二分查找算法
 * 实现模糊二分查找算法（比如大于等于给定值的第一个元素）
 *
 * 对应的 LeetCode 练习题（@Smallfly 整理）
 * Sqrt(x) （x 的平方根）
 * 英文版：https://leetcode.com/problems/sqrtx/
 * 中文版：https://leetcode-cn.com/problems/sqrtx/
 *
 *
 * 归并排序，采用分治法的思想，分别排序，再合并在一起
 * 时间复杂度 O(nlogn)
 * 空间复杂度 O(n)
 * 稳定排序
 * @author fankun
 * @version V1.0
 * @since 2020-01-29 23:48
 */
public class MergeSort {

    public static void mergeSort(int[] a,int n){
        mergeSortInternal(a,0,n-1);
    }

    //归并排序内部方法，p开始指针，r结束指针
    private static void mergeSortInternal(int[] a, int p, int r) {
        if(p>=r){
            return;
        }
        int q = p + (r-p)/2;  //不使用简单的两数相加/2，防止溢出
        mergeSortInternal(a,p,q);
        mergeSortInternal(a,q+1,r);
        merge(a,p,q,r);

    }

    //合并
    private static void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i = p; //左数组指针
        int j = q+1; // 右数组指针
        int k = 0; //tmp指针
        while (i<q+1 && j <=r){
            if(a[i] < a [j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if(i > q){
            start = j;
            end = r;
        }
        while (start <= end){
            tmp[k++] = a[start++];
        }
        for (int l = 0; l <= r - p; l++) {
            a[p+l] = tmp[l];
        }

    }

    public static void main(String[] args) {
        int[] ints = { 3, 2, 1,8,7,6 };
        MergeSort.mergeSort(ints,6);
        System.out.println(Arrays.toString(ints));
    }
}
