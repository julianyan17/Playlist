Author: Julian Yan  
Date: 4/17/2019  
Title: Playlist  
Summary: This program utilizes a doubly-linked list to implement a playlist and its functions.

Contents: 
* src
  * main
    * MyListIterator.java 
      * This file includes an list iterator class. 
       * boolean hasNext()
       * E next()
       * boolean hasPrevious()
       * E previous()
       * int nextIndex()
       * int previousIndex()
       * void set(E e);
    * MyPlaylist.java
      * This file includes a class that acts as the doubly linked list class.
        * MyPlayList()
        * int size()
        * E get(int index)
        * Song getNth(int index)
        * void add(int index, E element)
        * boolean add(E element)
        * E set(int index, E element)
        * E remove(int index)
        * void clear()
        * boolean isEmpty()
        * void shuffle()
        * void reverse()
        * MyListIterator myListIterator()
    * MyPlayListIterator.java
      * This file includes the MyPlayListIterator class which acts as the list iterator class.
        * MyPlayListIterator(MyPlayList list)
        * boolean hasNext()
        * E next()
        * boolean hasPrevious()
        * E previous()
        * int nextIndex()
        * int previousIndex()
        * void set(E o)
    * Song.java
      * This file includes the Song class which acts as a Node class.
        * Song(E element)
        * Song(E element, Song prevSong, Song nextSong)
        * void remove()
        * void setPrev(Song p)
        * void setNext(Song n)
        * void setElement(E e)
        * Song getNext()
        * Song getPrev()
        * E getElement()
  * test
      * TestMyPlayList.java
