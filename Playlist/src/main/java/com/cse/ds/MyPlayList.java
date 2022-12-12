package com.cse.ds;

/**
 * Author: Julian Wai San Yan
 * Date: 4/17/19
 * File: MyPlayList.java
 */

/**
 * This file includes the MyPlayList class which acts as the doubly linked list
 * class. Included below are methods to change the MyPlayList object,
 * specifically adding Songs, removing Songs, shuffling the list, and even 
 * reversing the list.
 */

import java.util.*;

/**
 * This class includes methods that will create a MyPlayList object. In the 
 * methods that will change the MyPlayList object, the pointers of the Song
 * objects are redirected to point to the proper object whether it is another
 * Song object or the dummy Song object.
 */

public class MyPlayList<E> extends AbstractList<E> {

    private int nsongs;
    Song dummy;

    static final int SEED_SIZE = 1234;

    //  Implementation of the MyPlayList Class

    /** 
     * Only 0-argument constructor is define 
     *
     * @param none
     * @return     MyPlaylist object
     */

    public MyPlayList() {
        nsongs = 0;
        dummy = new Song(null);
    }
    
    /**
     * The number of songs being stored
     *
     * @param none
     * @return     the number of songs being stored
     */

    @Override
    public int size() {
        return this.nsongs;

    }
    
    /**
     * Gets the music data within the node at position
     *
     * @param index index of the data
     * @return      music data at the index
     */

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // if index is greater than the size or if it is less than 0, throw
        // an IndexOutOfBoundsException
        if(index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        // gets the element from the song at the index
        E wantedElement = (E)(this.getNth(index).getElement());

        return wantedElement;
    }
    
    /**
     * Gets the song at the index
     *
     * @param index index of the data
     * @return      song at the index
     */

    private Song getNth(int index) throws IndexOutOfBoundsException {
        // if index is greater than the size or if it is less than 0, throw
        // an IndexOutOfBoundsException
        if(index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    
        Song getSong = dummy;
        // get next song from getSong
        for(int i = 0; i < index + 1; i++) {
            getSong = getSong.getNext();
        }    
        
        return getSong;
    }

    /** 
     * Add a node into this list by index with element as data
     *
     * @param index   index to add node
     * @param element data to add into the list
     * @return        none
     */

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException,
        NullPointerException {
            // if index is greater than the size or if it is less than 0, 
            // throw an IndexOutOfBoundException
            if(index > this.size() || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            
            // if element is null, throw a NullPointerException
            if(element == null) {
                throw new NullPointerException();
            }
            
            // creates newSong with the element
            Song newSong = new Song(element);

            // if index is 0
            if(index == 0) {
                // if size is 0
                if(this.size() == 0) {
                    // set newSong's previous to dummy, set newSong's next to
                    // null, set dummy's next to newSong
                    newSong.setPrev(dummy);
                    newSong.setNext(null);
                    dummy.setNext(newSong);
                }
                // if size is greater than 0
                if(this.size() > 0) {
                    // get the nextSong
                    Song nextSong = this.getNth(index);
                    
                    // set newSong's previous to dummy, set dummy's next to
                    // newSong
                    newSong.setPrev(dummy);
                    dummy.setNext(newSong);
                    
                    // set newSong's next to nextSong, set nextSong's previous
                    // to newSong
                    newSong.setNext(nextSong);
                    nextSong.setPrev(newSong);            
                }
                // increment nsongs and return
                nsongs++;
                return;
            }
            
            // if index is equal to size
            if(index == this.size()) {
                // get the prevSong
                Song prevSong = this.getNth(index - 1);
                
                // set newSong's previous to prevSong, set prevSong's next to
                // newSong, set newSong's next to null
                newSong.setPrev(prevSong);
                prevSong.setNext(newSong);
                newSong.setNext(null);
            }
            
            else {
                // get nextSong and prevSong
                Song nextSong = this.getNth(index);               
                Song prevSong = this.getNth(index - 1);
                
                // set newSong's previous to prevSong, set prevSong's next to
                // newSong
                newSong.setPrev(prevSong);
                prevSong.setNext(newSong);
                
                // set newSong's next to nextSong, set nextSong's prev to 
                // newSong
                newSong.setNext(nextSong);
                nextSong.setPrev(newSong);

            }
            // increment the playlist size
            nsongs++;
    }
    
    /** 
     * Add a new node at the end of this list
     *
     * @param element data to add to the list
     * @return        none
     */

    @Override
    public boolean add(E element) throws NullPointerException {
        // if element is null, throw a NullPointerException
        if(element == null) {
            throw new NullPointerException();
        }

        // creates newSong with the element
        Song newSong = new Song(element);

        // if size is 0       
        if(this.size() == 0) {
            // set newSong's prev to dummy, set dummy's next to newSong
            newSong.setPrev(dummy);
            dummy.setNext(newSong);
        }
        else {
            // get prevSong
            Song prevSong = this.getNth(this.size() - 1);

            // set newSong's prev to prevSong, set prevSong's next to newSong
            newSong.setPrev(prevSong);
            prevSong.setNext(newSong);
        }
        // set newSong's next to null
        newSong.setNext(null);

        // increment the playlist size
        nsongs++;
        return true;
    }


    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException,
        NullPointerException {
        
            // if index is greater than the size or if it is less than 0, 
            // throw an IndexOutOfBoundException
            if(index >= this.size() || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            
            // if element is null, throw a NullPointerException
            if(element == null) {
                throw new NullPointerException();
            }
            
            // gets the Song at the index
            Song oldSong = this.getNth(index);

            // gets the nonupdated element
            E oldElement = (E)(oldSong.getElement());

            // update the element
            oldSong.setElement(element);

            return oldElement;
    }
    
    /** 
     * Removes the node from position i in this list
     *
     * @param index index to remove Song from
     * @return      data of removed Song
     */

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        // if index is greater than the size or if it is less than 0, 
        // throw an IndexOutOfBoundException
        if(index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        // gets the song to remove
        Song removeSong = this.getNth(index);
        
        // if index is at the end
        if(index == this.size() - 1) {
            // get prevSong
            Song prevSong = removeSong.getPrev();
            // set prevSong's next to null
            prevSong.setNext(null);
        }

        // removes the Song and decrements the playlist size 
        
        else {
            removeSong.remove();
        }
        // decrement nsongs
        nsongs--;
        return (E)(removeSong.getElement());
    }
    
    /**
     * Remove all Songs from the playlist
     *
     * @param none
     * @return     none
     */

    @Override
    public void clear() {
        // while the playlist isn't empty
        while(this.size() != 0) {
            this.remove(0);
        }
    }
    
    /** 
     * Determines if the playlist is empty
     *
     * @param none
     * @return     whether or not the playlist is empty
     */

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Shuffle playlist
     *
     * @param none
     * @return    none
     */

    public void shuffle() {
        // creates random and sets seed
        Random rand = new Random();
        rand.setSeed(SEED_SIZE);
        
        // gets the 2 random indexes
        int first = rand.nextInt(this.size());
        int second = rand.nextInt(this.size());
        
        // get the songs at the indexes
        Song firstSong = this.getNth(first);
        Song secondSong = this.getNth(second);
        
        // remove the song at the first index and then add the second song
        this.remove(first);
        this.add(first,(E)(secondSong.getElement()));
        
        // remove the song at the second index and then add the first song
        this.remove(second);
        this.add(second,(E)(firstSong.getElement()));
  
    }

    /**
     * Reverse playlist
     *
     * @param none 
     * @return    none
     */

    public void reverse() {
        for(int i = 0; i < this.size(); i++) {
            Song lastSong = this.getNth(this.size() - 1);
            remove(this.size() - 1);
            this.add(i,(E)(lastSong.getElement()));
        }
    }

    public MyListIterator myListIterator() {
        return new MyPlayListIterator(this);
    }
}


