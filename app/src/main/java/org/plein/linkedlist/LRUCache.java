package org.plein.linkedlist;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    
    final Map<Integer, Node> nodeMap;
    final int capacity;
    Integer size;
    Node lastNode;
    Node firstNode;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>(capacity, 1);
        this.capacity = capacity;
        this.lastNode = null;
        this.firstNode = null;
        this.size = 0;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        } else{
            moveLast(node);
            return node.getValue();
        }
    }
    
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.setValue(value);
            moveLast(node);
        } else {
            Node newNode = new Node(key, value, null, lastNode);
            nodeMap.put(key, newNode);
            if (lastNode == null) {
                lastNode = newNode;
            } else {
                lastNode.setNext(newNode);
                lastNode = newNode;
            }
            if (firstNode == null) {
                firstNode = newNode;
            }
            size++;
            if (size > capacity) {
                remove(firstNode);
            }
        }
    }

    public void remove(Node node) {
        nodeMap.remove(node.getKey());
        if (node != null) {
            Node previous = node.getPrevious();
            if (previous != null) {
                previous.setNext(node.getNext()) ;
            }

            Node next = node.getNext();
            if (next != null) {
                next.setPrevious(node.getPrevious());
            }

            if (lastNode.equals(node)) {
                lastNode = node.getPrevious();
            }
            if (firstNode.equals(node)) {
                firstNode = node.getNext();
            }
            size--;
        }
        
    }

    public Integer moveLast(Node node) {
        if (!lastNode.equals(node)) {
            Node previous = node.getPrevious();
            if (previous != null) {
                previous.setNext(node.getNext()) ;
            }

            Node next = node.getNext();
            if (next != null) {
                next.setPrevious(node.getPrevious());
            }

            if (firstNode.equals(node)) {
                firstNode = node.getNext();
            }

            if (lastNode == null) {
                lastNode = node;
            } else {
                Node last = lastNode;
                last.setNext(node);
                node.setPrevious(last);
                lastNode = node;
            }
            
            return node.getValue();
        }
        return node.getValue();
    }

    private class Node {
        Integer key;
        Integer value;
        Node next;
        Node previous;
        
        public Node(Integer key, Integer value, Node next, Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Integer getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Integer getKey() {
            return key;
        }   
    }
}
