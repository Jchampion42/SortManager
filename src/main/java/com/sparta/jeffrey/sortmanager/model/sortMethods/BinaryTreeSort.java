package com.sparta.jeffrey.sortmanager.model.sortMethods;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        Tree binaryTree = new Tree(arrayToSort);
        List <Integer> output= binaryTree.getTreeValueLayout();
        return output.stream().mapToInt(i->i).toArray();
    }



    private class Tree{
        private int value;
        private Node leftNode = null;
        private Node rightNode = null;
        private int copyCount = 0;
        private int countUpToCopy=0;
        private List<Integer> treeValueLayout = new ArrayList<>();
        Tree(int[] inputArray){
            int maxValue = inputArray[0];
            int minValue = inputArray[0];

            for (int i : inputArray) {
                if (i > maxValue) {
                    maxValue = i;
                }
                if (i < minValue) {
                    minValue = i;
                }
            }
            value = minValue + (maxValue - minValue) / 2;
            for (int i : inputArray) {
                if (i < value) {
                    if (leftNode != null) {
                        leftNode.createNode(i);
                    } else leftNode = new Node(i);
                }
                if (i > value) {
                    if (rightNode != null) {
                        rightNode.createNode(i);
                    } else rightNode = new Node(i);
                }
                if (i == value) {
                    copyCount++;
                }
            }
        }
        public List<Integer> getTreeValueLayout(){
            treeValueLayout.clear();
            getNodeValue(leftNode);
            for (int i = 0; i<copyCount ; i++) {
                treeValueLayout.add(value);
            }
            getNodeValue(rightNode);
            return treeValueLayout;
        }
        private void getNodeValue(Node node){
            if (node.leftNode!=null) {
                    getNodeValue(node.leftNode);
            }
                for (int i=0 ; i<node.copyCount; i++){
                    treeValueLayout.add(node.value);
                }
            if (node.rightNode!=null) {
                    getNodeValue(node.rightNode);
            }
        }
    }

    class Node{
        Integer value;
        Node leftNode;
        Node rightNode;
        int copyCount;

        boolean gotOwnValue=false;


        Node(int value){
            this.value=value;
            copyCount=1;
        }
        void createNode(int value){
            if (value<this.value){
                if (leftNode!=null){
                    leftNode.createNode(value);
                }
                else leftNode=new Node(value);
            }
            if (value>this.value){
                if (rightNode!=null){
                    rightNode.createNode(value);
                }
                else rightNode=new Node(value);
            }
            if (value==this.value){
                copyCount++;
            }
        }

    }
}
