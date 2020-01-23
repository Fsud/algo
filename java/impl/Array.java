package impl;

import java.util.Arrays;

public class Array<T> {

    /**
     * 数组负载
     */
    private T data[];

    /**
     * 数组中元素的个数，对外表现为数组的可用大小
     */
    private int size;

    public Array(int n){
        data = (T[])new Object[n];
    }

    public void set(int index,T d){
        validate(index);
        data[index] = d;
    }

    public void add(int index,T d){
        validate(index);

        //动态扩容
        if(size == data.length){
            resize(2 * data.length);
        }

        //移动元素
        for (int i = size-1 ; i>= index;i--){
            data[i+1] = data[i];
        }

        //设置数据
        data[index] = d;
        size ++;
    }

    //校验边界
    private void validate(int index) {
        if(index < 0 || index > size){
            throw new IllegalArgumentException("操作越界");
        }
    }

    private void resize(int n) {
        T[] newData = (T[])new Object[n];
        for (int i = 0; i<size; i++ ) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        Array<Integer> integerArray = new Array<>(3);
        integerArray.add(0,1);
        integerArray.add(0,2);
        integerArray.add(0,3);
        integerArray.add(0,4);
        System.out.println(integerArray.toString());
    }
}
