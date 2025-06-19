package Materia.controllers;

import Materia.model.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }

        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        }
        if (value < node.getValue()) {
            return searchRec(node.getLeft(), value);
        } else {
            return searchRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getWeight() {
        return getWeightRec(root);
    }

    private int getWeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getWeightRec(node.getLeft()) + getWeightRec(node.getRight());
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
    }

    public void printBinaryTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.getLeft());
            System.out.print(node.getValue() + ", ");
            printTree(node.getRight());
        }
    }

    public void printHeight() {
        printHeightTree(root);
    }

    private void printHeightTree(Node node) {
        if (node != null) {
            printHeightTree(node.getLeft());
            int height = getHeightRec(node);
            System.out.print(node.getValue() + "(h: " + height + "), ");
            printHeightTree(node.getRight());
        }
    }

    public void printBalance() {
        printBalanceTree(root);
    }

    private void printBalanceTree(Node node) {
        if (node != null) {
            printBalanceTree(node.getLeft());
            int balance = getBalanceFactor(node);
            System.out.print(node.getValue() + "(bf: " + balance + "), ");
            printBalanceTree(node.getRight());
        }
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalancedRec(node.getLeft()) && isBalancedRec(node.getRight());
    }

    public void printUnbalancedNodes() {
        System.out.print("Nodos desequilibrados");
        printUnbalancedNodesRec(root);
    }

    private void printUnbalancedNodesRec(Node node) {
        if (node != null) {
            printUnbalancedNodesRec(node.getLeft());
            int balanceFactor = getBalanceFactor(node);
            if (Math.abs(balanceFactor) > 1) {
                System.out.print(node.getValue() + "(fE = " + balanceFactor + ") ");
            }
            printUnbalancedNodesRec(node.getRight());
        }
    }
}