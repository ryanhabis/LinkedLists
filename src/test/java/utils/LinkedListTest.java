package utils;

import business.Song;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michelle
 */
public class LinkedListTest {

    public LinkedListTest() {
    }

    /**
     * Testing the size method, of class LinkedList, with an empty list.
     */
    @Test
    public void testSize_EmptyList() {
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Testing the size method, of class LinkedList, with a populated list.
     */
    @Test
    public void testSize_PopulatedList() {
        LinkedList instance = new LinkedList();
        instance.add(new Song());
        instance.add(new Song());
        instance.add(new Song());
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing valid input with get method, of class LinkedList.
     */
    @Test
    public void testGet_ValidInput() {
        LinkedList instance = new LinkedList();
        instance.add(new Song());
        instance.add(new Song());
        instance.add(new Song());
        
        Song expResult = new Song();
        Song result = instance.get(1);
        assertEquals(expResult, result);
    }
    
    /**
     * Testing valid input with get method, when getting from the end of the list, of class LinkedList.
     */
    @Test
    public void testGet_ValidInput_EndOfList() {
        LinkedList instance = new LinkedList();
        instance.add(new Song("Title 0", "Artist 0"));
        instance.add(new Song("Title 1", "Artist 1"));
        instance.add(new Song("Title 2", "Artist 2"));
        
        Song expResult = new Song("Title 2", "Artist 2");
        Song result = instance.get(2);
        assertEquals(expResult, result);
    }
       
    /**
     * Testing invalid input (below lower bound) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingLowerBound() {
        LinkedList instance = new LinkedList();
        instance.add(new Song());
        instance.add(new Song());
        instance.add(new Song());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });
    }
    
    /**
     * Testing invalid input (greater than size) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingUpperBound_GreaterThanSize() {
        LinkedList instance = new LinkedList();
        instance.add(new Song());
        instance.add(new Song());
        instance.add(new Song());
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(4);
        });
    }
    
    /**
     * Testing invalid input (equal to size) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingUpperBound_EqualToSize() {
        LinkedList instance = new LinkedList();
        instance.add(new Song());
        instance.add(new Song());
        instance.add(new Song());
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });
    }
    
    /**
     * Test of indexOf method with information in the list, of class LinkedList.
     */
    @Test
    public void testIndexOf_SongInList() {
        Song s = new Song("Temp Title", "Temp Artist");
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist"));
        
        int expResult = 2;
        int result = instance.indexOf(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method with information in the list, of class LinkedList.
     */
    @Test
    public void testIndexOf_SongNotInList(){
        Song s = new Song();
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist"));
        
        int expResult = -1;
        int result = instance.indexOf(s);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of add method with empty list, of class LinkedList.
     */
    @Test
    public void testAdd_Song() {
        Song s = new Song("First title", "First Artist");
        LinkedList instance = new LinkedList();
        
        boolean expResult = true;
        boolean result = instance.add(s);
        assertEquals(expResult, result);
        
        int expSize = 1;
        int resultSize = instance.size();
        assertEquals(expSize, resultSize);
        
        Song resultSong = instance.get(0);
        assertEquals(s, resultSong);
        
        resultSong = instance.tail();
        assertEquals(s, resultSong);
    }

    /**
     * Test of add method with empty list, of class LinkedList.
     */
    @Test
    public void testAdd_AddingTwoElements_Song() {
        LinkedList instance = new LinkedList();
        Song song0 = new Song("Temp title0", "Temp Artist0");
        instance.add(song0);
        
        boolean expResult = true;
        Song song1 = new Song("Temp title1", "Temp Artist1");
        boolean result = instance.add(song1);
        assertEquals(expResult, result);
        
        Song elem2 = instance.get(1);
        assertEquals(song1, elem2);
        
        int expSize = 2;
        int resultSize = instance.size();
        assertEquals(expSize, resultSize);
        
        Song resultSong = instance.tail();
        assertEquals(song1, resultSong);
    }    
     
  /**
     * Test of remove method to try and remove something that doesn't appear in the list, of class LinkedList.
     */
    @Test
    public void testRemove_RemovingSomethingNotPresent() {
        Song s = new Song("Temp title", "Temp Artist");
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title2", "Temp Artist2"));
        
        boolean expResult = false;
        boolean result = instance.remove(s);
        assertEquals(expResult, result);
        int expSize = 3;
        assertEquals(expSize, instance.size());
    }    
    
    /**
     * Test of remove method to remove one instance, of class LinkedList.
     */
    @Test
    public void testRemove_RemovingOneInstance() {
        Song s = new Song("Temp title1", "Temp Artist1");
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist"));
        
        boolean expResult = true;
        boolean result = instance.remove(s);
        assertEquals(expResult, result);
        int expSize = 2;
        assertEquals(expSize, instance.size());
        // Confirm it's not still there
        expResult = false;
        result = instance.remove(s);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of remove method to remove single instance where multiple exist in the list, of class LinkedList.
     */
    @Test
    public void testRemove_RemovingSingleInstanceWhereMultipleExist() {
        Song s = new Song("Temp title1", "Temp Artist1");
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        
        boolean expResult = true;
        boolean result = instance.remove(s);
        assertEquals(expResult, result);
        int expSize = 3;
        assertEquals(expSize, instance.size());
        int expPos = 2;
        assertEquals(expPos, instance.indexOf(s));
    }

    /**
     * Test of isEmpty method with an empty list, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        LinkedList instance = new LinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
 
    /**
     * Test of isEmpty method with an populated list, of class LinkedList.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist0"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist"));
        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}
