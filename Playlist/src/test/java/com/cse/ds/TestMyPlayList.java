package com.cse.ds;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.*;



@FixMethodOrder(MethodSorters.JVM)
public class TestMyPlayList {
    static MyPlayList obj = null;

    @BeforeClass
    public static void setUpBeforeClass() {
        obj = new MyPlayList();
    }
    @Before
    public void populatePlayList(){
        obj.clear();
    }
    
    // tests get: when index is greater than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testGetTooBigIndex() throws Exception {
        obj.get(11);
    }
    
    // tests get: when index is less than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testGetTooSmallIndex() throws Exception {
        obj.get(-1);
    }
    
    // tests get: when index is the same as size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testGetAtSizeIndex() throws Exception {
        obj.get(10);
    }
    
    // tests add: null element
    @Test (expected = NullPointerException.class)
    public void testAddNull() throws Exception {
        obj.add(null);
    }

    // tests add: the size of the playlist
    @Test
    public void testAddNumberOfSongs() {
        obj.add(0);
        obj.add(1);

        Assert.assertEquals(obj.size(), 2);
        
        Assert.assertEquals(obj.get(0), 0);
        Assert.assertEquals(obj.get(1), 1);

    }  

    // tests addAtIndex: when index is greater than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void addTooBigIndex() throws Exception {
        obj.add(2, "hi");
    }
    
    // tests addAtIndex: when index is less than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void addTooSmallIndex() throws Exception {
        obj.add(-1, "hi");
    }
    
    // tests addAtIndex: add at beginning
    @Test
    public void addAtBeginning() { 
        obj.add(0,0);
        obj.add(1);

        Assert.assertEquals(obj.size(), 2);
        
        Assert.assertEquals(obj.get(0), 0);
        Assert.assertEquals(obj.get(1), 1);
    }
    
    // tests addAtIndex: add at beginning of big list
    @Test
    public void addAtBeginningBigList() {
        obj.add(1);
        obj.add(0,0);

        Assert.assertEquals(obj.size(), 2);
        
        Assert.assertEquals(obj.get(0), 0);
        Assert.assertEquals(obj.get(1), 1);
    }

    // tests addAtIndex: add at middle
    @Test
    public void addInMiddle() { 
        obj.add(0);
        obj.add(2);
        obj.add(3);
        obj.add(1,1);

        Assert.assertEquals(obj.size(), 4);

        Assert.assertEquals(obj.get(0), 0);
        Assert.assertEquals(obj.get(1), 1);
        Assert.assertEquals(obj.get(2), 2);
        Assert.assertEquals(obj.get(3), 3);
    }
    
    // tests addAtIndex: add at end
    @Test 
    public void addAtEnd() {
        obj.add(1);
        obj.add(2);
        obj.add(2,3);

        Assert.assertEquals(obj.size(), 3);
        
        Assert.assertEquals(obj.get(0), 1);
        Assert.assertEquals(obj.get(1), 2);
        Assert.assertEquals(obj.get(2), 3);
    }

    // tests remove: when index is greater than size
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveTooBigIndex() throws Exception {
        obj.remove(1);
    }
    
    // tests remove: when index is less that size
    @Test (expected = IndexOutOfBoundsException.class) 
    public void testRemoveTooSmallIndex() throws Exception {
        obj.remove(-1);
    }
    
    // tests remove: removing the first
    @Test
    public void testRemoveFirst() {
        obj.add(1);
        obj.add(2);
        obj.remove(0);

        Assert.assertEquals(obj.size(),1);
    }

    // tests remove: removing the middle
    @Test
    public void testRemoveMiddle() {
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.remove(1);

        Assert.assertEquals(obj.size(),2);
    }

    // tests remove: removing the end
    @Test
    public void testRemoveEnd() {
        obj.add(1);
        obj.add(2);
        obj.remove(1);

        Assert.assertEquals(obj.size(),1);
    }

    // tests remove: removing the first with AddAtIndex
    @Test
    public void testAddRemoveFirst() {
        obj.add(0,0);
        obj.add(1,1);
        obj.remove(0);

        Assert.assertEquals(obj.size(),1);
    }

    // tests remove: removing the middle with AddAtIndex
    @Test
    public void testAddRemoveMiddle() {
        obj.add(0,0);
        obj.add(1,1);
        obj.add(2,2);
        obj.remove(1);

        Assert.assertEquals(obj.size(),2);
    }

    // tests remove: removing the end with AddAtIndex
    @Test
    public void testAddRemoveEnd() {
        obj.add(0,0);
        obj.add(1,1);
        obj.remove(1);

        Assert.assertEquals(obj.size(),1);
    }
    
    // tests set: when index is greater than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testSetTooBigIndex() throws Exception {
        obj.set(11, "hi");
    }
    
    // tests set: when index is less than size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testSetTooSmallIndex() throws Exception {
        obj.set(-1, "hi");
    }
    
    // tests set: when index is the same as size
    @Test (expected = IndexOutOfBoundsException.class)        
    public void testSetAtSizeIndex() throws Exception {
        obj.set(10, "hi");
    }
    
    // tests set: null element
    @Test (expected = NullPointerException.class)
    public void testSetNull() throws Exception {
        obj.add(1);
        obj.set(0,null);
    }

    // tests set: at the beginning
    @Test
    public void setAtBeginning() { 
        obj.add(0,0);

        Assert.assertEquals(obj.size(), 1);
        Assert.assertEquals(obj.set(0,1), 0);
        Assert.assertEquals(obj.get(0), 1);
    }
    
    // tests set: add at middle
    @Test
    public void setInMiddle() { 
        obj.add(0);
        obj.add(2);
        obj.add(3);

        Assert.assertEquals(obj.size(), 3);
        Assert.assertEquals(obj.set(0,1), 0);
        Assert.assertEquals(obj.get(0), 1);
        Assert.assertEquals(obj.get(1), 2);
        Assert.assertEquals(obj.get(2), 3);
    }

    // tests set: add at end
    @Test 
    public void setAtEnd() {
        obj.add(1);
        obj.add(2);

        Assert.assertEquals(obj.size(), 2);
        Assert.assertEquals(obj.set(1,3), 2);
        Assert.assertEquals(obj.get(0), 1);
        Assert.assertEquals(obj.get(1), 3);
    }
   
    // tests shuffle: shuffling the first and last
    @Test 
    public void testShuffleOpposite() {
        obj.add(1);
        obj.add(2);
        obj.add(3);

        obj.shuffle();

        Assert.assertEquals(obj.get(0),3);
        Assert.assertEquals(obj.get(1),2);
        Assert.assertEquals(obj.get(2),1);
    }

    // tests shuffle: shuffling the 2 next to each other
    @Test 
    public void testShuffleNext() {
        obj.add(1);
        obj.add(2);
        obj.add(3);

        obj.shuffle();

        Assert.assertEquals(obj.get(0),2);
        Assert.assertEquals(obj.get(1),1);
        Assert.assertEquals(obj.get(2),3);
    }

    // tests shuffle: shuffling the 2 in middle
    @Test 
    public void testShuffleMiddle() {
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);

        obj.shuffle();

        Assert.assertEquals(obj.get(0),1);
        Assert.assertEquals(obj.get(1),4);
        Assert.assertEquals(obj.get(2),3);
        Assert.assertEquals(obj.get(3),2);
        Assert.assertEquals(obj.get(4),5);        
    }

    // tests reverse: list of size 5
    @Test
    public void testReverseBig() {
        obj.add(0,1);
        obj.add(1,2);
        obj.add(2,3);
        obj.add(3,4);
        obj.add(4,5);
        obj.reverse();

        Assert.assertEquals(obj.get(0),5);
        Assert.assertEquals(obj.get(1),4);
        Assert.assertEquals(obj.get(2),3);
        Assert.assertEquals(obj.get(3),2);
        Assert.assertEquals(obj.get(4),1);
    }
    
    // tests reverse: list of size 1
    @Test
    public void testReverse() {
        obj.add(0,1);
        obj.reverse();

        Assert.assertEquals(obj.get(0),1);
    }

    // tests isEmpty: empty list
    @Test
    public void isEmptyTrue() {
        Assert.assertTrue(obj.isEmpty());
    }

    // tests isEmpty: nonemtpy list
    @Test
    public void isEmptyFalse() {
        obj.add(1);

        Assert.assertFalse(obj.isEmpty());
    }

    @Test
    public void testIterator() {
        for(int i=0;i<10;i++){
            obj.add(i);
        }
        MyListIterator<Song> iter = obj.myListIterator();
        for(int i=0;i<obj.size()/2;i++){
            iter.next();
        }
        Assert.assertEquals(iter.next(), 5);
    }        

 
    // tests hasNext: true
    @Test
    public void testHasNextTrue() {
        obj.add(1);

        MyPlayListIterator<Song> iter =  new MyPlayListIterator(obj);
        Assert.assertTrue(iter.hasNext());
    }

    // tests hasNext: false
    @Test
    public void testHasNextFalse() {
        MyPlayListIterator<Song> iter = new MyPlayListIterator(obj);
        Assert.assertFalse(iter.hasNext());
    }
    
    // tests next: error
    @Test (expected = NoSuchElementException.class)
    public void testNextError() {
        MyPlayListIterator<Song> iter = new MyPlayListIterator(obj);
        iter.next();
    }

 /*   // tests hasPrev: true
    @Test
    public void testHasPrevTrue() {
        obj.add(1);

        MyPlayListIterator<Song> iter = new MyPlayListIterator(obj);
        iter.next();

        Assert.assertTrue(iter.hasPrev());
    }

    // tests hasPrev: false
    @Test
    public void testHasPrevFalse() {
        MyPlayListIterator<Song> iter = new MyPlayListIterator(obj);
        Assert.assertFalse(iter.hasPrev());
    }

    // tests previous: error
    @Test (expected = NoSuchElementException.class)
    public void testPreviousError() {
        MyPlayListIterator<Song> iter = new MyPlayListIterator(obj);
        iter.previous();
    }*/
 //   @Test
    
}


