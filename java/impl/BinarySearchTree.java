/*
 * Copyright (c) 2001-2020 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package impl;

/**
 * 二叉搜索树
 *
 * @author fankun
 * @version V1.0
 * @since 2020-02-01 21:03
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data){
        Node p = tree;
        while(p != null){
            if(p.data == data){
                return p;
            }else if(data < p.data){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        return null;
    }

    public void insert(int data){
        if(tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while(p!=null){
            if(data > p.data){
                if(p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else{
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除节点是叶子节点或只有一个子节点，
     * @param data
     */
    public void delete(int data){
        Node p = tree;

        //找到要删除节点和其父节点
        Node pp = null;
        while( p!=null && p.data != data){
            pp = p;
            if(data > p.data){
                p = p.right;
            }else{
                p = p.left;
            }
            if(p == null){
                return;
            }
        }

        //要删除的节点有两个子节点,寻找右子树的最左节点，将其值复制过来，再将其删除
        if(p.left != null && p.right != null){
            Node minP = p.right;
            Node minPP = null;
            while (p.left != null){
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            //移动完成，现在开始删除minP。由于最左节点肯定只有右节点一个子节点，所以可以复用下面的逻辑
            p = minP;
            pp = minPP;
        }

        //删除叶子节点或只有单个子节点的节点。
        Node child;
        if(p.left != null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else{
            child = null;
        }

        if(pp == null){
            tree = child;
        }else if(pp.left == p){
            pp.left = child;
        }else{
            pp.right = child;
        }
    }

    public Node findMin(){
        Node p = tree;
        if(p == null){
            return null;
        }
        while(p.left != null){
            p = p.left;
        }
        return p;
    }

    public Node findMax(){
        Node p = tree;
        if(p == null){
            p = null;
        }
        while (p.right != null){
            p = p.right;
        }
        return p;
    }

    public static class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data){
            this.data = data;
        }
    }
}
