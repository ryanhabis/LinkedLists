package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }
    
    // Duplicate the following structure for each test of your add method:
    
    /**
     * Testing the add method (two parameter version), of class LinkedList, with XXXXXXXXX (Condition being tested).
     */
    /**
     * Test the add method (two parameter version) of the LinkedList class, adding to an empty list.
     */
    @Test
    public void testAddTwoParameters_AddingToEmptyList() {
        // Create an empty linked list
        LinkedList instance = new LinkedList();

        // Create a song to add to the list
        Song song = new Song("Temp title", "Temp Artist");

        // Add the song to the list at position 0
        boolean result = instance.add(song, 0);

        // Verify that the add method returns true
        assertTrue(result);

        // Verify that the song was added to the list at position 0
        assertEquals(song, instance.get(0));

        // Verify that the size of the list is 1
        assertEquals(1, instance.size());
    }

    // Duplicate the following structure for each test of your toArray method:
    
    /**
     * Testing the toArray method,  of class LinkedList, with XXXXXXXXX (Condition being tested).
     */
    // Test the toArray method with a list containing two elements
    @Test
    public void testToArray_WithTwoElements() {
        // Create an instance of LinkedList and add two songs to it
        LinkedList instance = new LinkedList();
        Song song0 = new Song("Temp title0", "Temp Artist0");
        Song song1 = new Song("Temp title1", "Temp Artist1");
        instance.add(song0);
        instance.add(song1);

        // Define the expected result as an array containing the two songs
        Song[] expResult = {song0, song1};

        // Call the toArray method and compare the result with the expected result
        Song[] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }


    // Duplicate the following structure for each test of your tail method:
    
    /**
     * Testing the tail method,  of class LinkedList, with XXXXXXXXX (Condition being tested).
     */

    // Tests the tail method of the LinkedList class with a list containing three elements.
    @Test
    public void testTail_ListWithThreeElements()
    {
        // Create a new LinkedList instance.
        LinkedList instance = new LinkedList();

        // Create three Song objects.
        Song song1 = new Song("Title1", "Artist1");
        Song song2 = new Song("Title2", "Artist2");
        Song song3 = new Song("Title3", "Artist3");

        // Add the three Song objects to the LinkedList instance.
        instance.add(song1);
        instance.add(song2);
        instance.add(song3);

        // Call the tail method on the LinkedList instance and assert that it returns the last element in the list.
        Song result = instance.tail();
        assertEquals(song3, result);
    }

}
