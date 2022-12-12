package com.cse.ds;

/**
 * Author: Julian Wai San Yan
 * Date: 4/17/19
 * File: Song.java
 */

/**
 * This file includes the Song class which acts as a Node class. Included below
 * are methods to create a Song object with a next Song and previous Song
 * connected to it. There are also methods that allow changes to be made to the
 * Song object.
 */

/**
 * This class includes methods that will create a Song object. The Song object
 * may also be changed, specifically the previous, next Song and the Song 
 * itself. The Song object can also be removed. 
 */

public class Song<E> {

    E data;
    Song next;
    Song prev;

    /** Constructor to create singleton Song
     *
     * @param element 
     * @return        Song object
     */

    public Song(E element) {
        this.data = element;
    }

    /** Constructor to create singleton link it between previous and next
     * @param element Element to add, can be null
     * @param prevSong predecessor Song, can be null
     * @param nextSong successor Song, can be null
     * @return         Song object
     */

    public Song(E element, Song prevSong, Song nextSong) {
        this.data = element;
        this.prev = prevSong;
        this.next = nextSong;
    }

    /** Remove this Song from the list. Update previous and next Songs 
     *
     * @param  none
     * @return none
     */

    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }

    /** Set the previous Song in the list
     *
     * @param p new previous Song
     * @return  none
     */

    public void setPrev(Song p) {
        this.prev = p;
    }

    /** Set the next Song in the list
     *
     * @param n new next Song
     * @return  none
     */
    public void setNext(Song n) {
        this.next = n;
    }

    /** Set the element
     *
     * @param e new element
     * @return  none
     */

    public void setElement(E e) {
        this.data = e;
    }

    /** Accessor to get the next Song in the list 
     *
     * @param  none
     * @return none
     */

    public Song getNext() {
        return this.next;
    }

    /** Accessor to get the prev Song in the list
     * @param  none
     * @return none
     */

    public Song getPrev() {
        return this.prev;
    }
    /** Accessor to get the Songs Element 
     *
     * @param  none
     * @return none
     */

    public E getElement() {
        return this.data;
    }
}


