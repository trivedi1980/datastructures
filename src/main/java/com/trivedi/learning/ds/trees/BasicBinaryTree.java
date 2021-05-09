package com.trivedi.learning.ds.trees;
public class BasicBinaryTree <T extends Comparable<T>> {
    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public int size() {
        return this.size;
    }

    public void add(T item) {
        Node newNode = createNode(item);
        if (this.root == null) {
            this.root = newNode;
            this.size++;
        } else {
            insert(this.root, newNode);
        }
    }

    public void delete(T item) {
        if (this.root != null) {
            delete(this.root, item);
        }
    }

    public boolean contains(T item) {
        Node node = find(this.root, item);
        return node != null;
    }

    public void print() {
        System.out.println();
        display(this.root);
    }

    private void display(Node parent) {
        if (parent == null) return;
        display(parent.left);
        System.out.print(parent.value + " ,");
        display(parent.right);
    }

    private void delete(Node parent, T item) {
        Node node = find(parent, item);
        if (node != null) {
            boolean isLeftChild = node.parent.left == node;
            // if node is leaf node
            if (node.left == null && node.right ==  null) {
                if (isLeftChild) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            } else if (node.left == null) {

                if (isLeftChild) {
                    node.parent.left = node.right;
                } else {
                    node.parent.right = node.right;
                }
            } else if (node.right == null) {
                if (isLeftChild) {
                    node.parent.left = node.left;
                } else {
                    node.parent.right = node.left;
                }
            } else {
                Node minNode = findMin(node.right);
                node.value = minNode.value;
                delete(node.right, minNode.value);
            }
        }
    }

    private Node findMin(Node parent) {
        if (parent.left == null) return parent;
        return findMin(parent.left);
    }

    private Node createNode(T item) {
        Node newNode = new Node();
        newNode.setValue(item);
        return newNode;
    }

    private Node find(Node parent, T item) {
        if (parent == null) return null;

        int compValue = parent.value.compareTo(item);
        if (compValue == 0) {
            return parent;
        } else if (compValue < 0) {
            return find(parent.right, item);
        } else {
            return find(parent.left, item);
        }
    }

    private void insert(Node parent, Node child) {
        if (parent.getValue().compareTo(child.getValue()) > 0) {
            if (parent.left == null) {
                parent.left = child;
                child.parent = parent;
                this.size++;
            } else {
                insert(parent.left, child);
            }

        } else {
            if (parent.right == null) {
                parent.right = child;
                child.parent = parent;
                this.size++;
            } else {
                insert(parent.right, child);
            }
        }
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private T value;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
