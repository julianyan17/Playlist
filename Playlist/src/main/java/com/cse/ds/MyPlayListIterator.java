package com.cse.ds;

/**
 * Author: Julian Wai San Yan
 * Date: 4/17/19
 * File: MyPlayListIterator.java
 */

import java.util.*;

/**
 * This file includes the MyPlayListIterator class which acts as the list
 * iterator class. Included below are methods to change the iterator which will
 * keep track of the previous and next song node as well as setting the nodes to
 * a new element.
 */

/** ListIterator implementation */

/**
 * This class included methods that will create a MyPlayList object. There are
 * methods to get the previous and next song nodes as well setting the song to
 * a new element.
 */

public class MyPlayListIterator<E> implements MyListIterator<E> {
    Song prevSong;
    Song nextSong;
    private int index;
    private boolean prevCalled;
    private boolean nextCalled;
    private boolean direction;
    
    /**
     * Constructor for MyPlayListIterator
     *
     * @param
     * @param
     * @return      MyPlayListIterator object
     */

    public MyPlayListIterator(MyPlayList list) {
        this.prevSong = list.dummy;
        this.nextSong = this.prevSong.getNext();
        this.index = 0;
        this.prevCalled = false;
        this.nextCalled = false;
        this.direction = false;
    }

    /**
     * Return true if there are more elements other than dummy when going in
     * the forward direction
     *
     * @param none
     * @return     true if there are more elements other than dummy
     */

    @Override
    public boolean hasNext() {
        // if nextSong is not null
        if(this.nextSong != null) {
            return true;
        }
        return false; 
    }
    
    /**
     * Return the next element in the list when going forward, and move the 
     * iterator forward for one node
     *
     * @param none
     * @return     the next element in the list
     */

    @Override
    public E next() throws NoSuchElementException {
        // update nextCalled and direction
        this.nextCalled = true;
        this.direction = true;
        
        // if hasNext is false
        if(this.hasNext() == false) {
            throw new NoSuchElementException();
        }

        E nextElement = (E)(this.nextSong.getElement());
        
        // shift iterator
        this.prevSong = this.nextSong;
        this.nextSong = this.nextSong.getNext();
        index++;

        return nextElement;
    }

    /**
     * Return true if there are more elements other than dummy when going in the
     * reverse direction
     *
     * @param none
     * @return     true if there are more elements other than dummy when going 
     *             in reverse direction
     */

    @Override
    public boolean hasPrevious() {
        // if prevSong is not null
        if(this.prevSong.getElement() != null) {
            return true;
        }

        return false;
    }

    /**
     * Return the next element in the list when going backward, and move the
     * iterator backward for one node
     *
     * @param none 
     * @return     the next element in the list when going backward
     */

    @Override
    public E previous() throws NoSuchElementException {
        // update prevCalled and direction
        this.prevCalled = true;
        this.direction = false;
        
        // if hasPrevious is false
        if(this.hasPrevious() == false) {
            throw new NoSuchElementException();
        }

        E prevElement = (E)(this.prevSong.getElement());
        
        // shift iterator
        this.nextSong = this.prevSong;
        this.prevSong = this.prevSong.getPrev();
        index--;

        return prevElement;
    }
    
    /** 
     * Return the index of the element that would be returned by a call to
     * next() or return the last index if at the end of the list
     *
     * @param none 
     * @return     the index of the element that would be returned by a call to
     *             next() or the last index if at the end of the list
     */

    @Override
    public int nextIndex() {
        return index;
    }

    /**
     * Return the index of the element that would be returned by a call to 
     * previous() or return 1 if at the start of the list
     *
     * @param none 
     * @return     return the index of the element that would be returned by a call to 
     *             previous() or return 1 if at the start of the list
     */

    @Override
    public int previousIndex() {
        return index - 1;
    }
    
    /** 
     * Change the value in the node returned by the most recent next/previous
     * call with the new value
     *
     * @param o Song object to change
     * @return  none
     */

    @Override
    public void set(E o) throws NullPointerException, IllegalStateException {
        if(o == null) {
            throw new NullPointerException();
        }

        if(this.prevCalled == false && this.nextCalled == false) {
            throw new IllegalStateException();
        }

        // if prev was called 
        if(this.prevCalled == true && this.direction == false) {
            this.nextSong.setElement(o);
            prevCalled = false;
        }

        // if next was called
        if(this.nextCalled == true && this.direction == true) {
            this.prevSong.setElement(o);
            nextCalled = false;
        }
    }

}
