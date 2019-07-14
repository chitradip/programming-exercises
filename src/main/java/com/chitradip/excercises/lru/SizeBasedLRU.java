package com.chitradip.excercises.lru;

import java.util.HashMap;
import java.util.Map;

public class SizeBasedLRU<K, V> {

    private final int maxSize;

    public int getSize() {

        //Mailnly for testing - to make sure we don't make a mistake. This would not heb in production code.
        if ( currSize != map.size() ) {
            throw new IllegalStateException("");
        }
        return currSize;
    }

    private  int currSize=0;

    private final Map<K, Node<K,V>> map = new HashMap<>();
    private final Node<K, V>  head = new Node<>(null, null);
    private final Node<K, V>  tail = new Node<>(null, null);

    public SizeBasedLRU(int maxSize) {
        this.maxSize = maxSize;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }


    public void putCache(K key, V value) {

        assert map.size() == currSize;
        //If it has reached the maximum size, then remove the last node
        if ( currSize >= maxSize) {
            //Evict
            Node<K, V> node = removeNode(tail.prev);
            map.remove(node.key);

        }



        //Create a node and insert into head;
        Node<K, V> newNode = atHeadNode(key, value);

        //Put it in the map for retreival.
        map.put(key, newNode);
    }


    public V getFromCache(K key) {
        Node<K, V> node = map.get(key);

        if ( node != null ) {

            //Detach the node from the list.
            removeNode(node);

            //Re insert it at the head position (marked as "used").
            insertNodeAfter(node, head);

            return node.val;
        } else {
            return null;
        }
    }


    private Node<K, V> atHeadNode(K key, V val) {
        var newNode = new Node<>(key, val);
        insertNodeAfter(newNode, head);
        return newNode;
    }

    //THis will destory this node
    private void insertNodeAfter(Node<K, V> node, Node<K, V> after) {


        //Set the prev next of this node.
        node.prev = after;
        node.next = after.next;

        //AFter's next has now changed.
        after.next = node;

        //Also update the next node's previous which is still pointing to after.
        node.next.prev = node;

        currSize++;
    }

    //THis will destory this node
    // returns the removed node.
    private Node<K, V> removeNode(Node<K, V> node) {

        //Don't remove head or tail
        if ( node == head || node == tail ) {
            throw new IllegalArgumentException("Trying to delete head/tail node");
        }

        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;

        free(node);

        //Make the prev and next point to each other.
        prev.next = next;
        next.prev = prev;
        currSize--;

        return node;

    }

    //For safety in case there are some circular dependencies left
    private void free(Node<K, V> node) {
        node.prev = null;
        node.next = null;
    }


    private static class Node<K,V> {

        final K key;
        final V val;
        Node<K,V> next;
        Node<K,V> prev;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }


    }

}
