package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList
{

    private Node firstPos;
    private Node lastPost;
    private int size;
    public LinkedList()
    {
        this.firstPos = null;
        this.lastPost = null;
        this.size = size;
    }

    /**
     * This is a private static class called Node. It is used as a building block for creating a linked list of songs.
     * Each Node object contains two fields: data, which holds a Song object, and next, which points to the next Node in the list.
     */
    private static class Node
    {

        private Song data;
        private Node next;

        /**
         * Constructor for creating a Node object.
         * @param value the Song object to be stored in this Node.
         */
        public Node(Song value)
        {
            this.data = value;
            this.next = null;
        }

    }

    /**
     * 1. A method called size() that takes no parameters & returns the number of Songs currently stored in your list.
     */
    public int size()
    {
        return size;
    }


    /**
     *2. A method called get() that takes one parameter, an int representing the position from which data should be
     *   retrieved. The position should be validated and invalid positions handled accordingly.
     * @param index
     * @return
     */
    public Song get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Invalid position provided");
        }
        Node currentPos = firstPos;
        for (int i = 0; i < index; i++)
        {
            currentPos = currentPos.next;
        }
        return currentPos.data;
    }

    /*
     * 3. A method called indexOf() that takes one parameter, a Song to be found in the list. The method should
     * return an int indicating the position at which the Song could be found. If the Song could not be found, an
     * appropriate value should be returned to indicate this.
     */

    public int indexOf(Song value)
    {
        if (firstPos == null)
        {
            return -1;
        }

        Node currentPos = firstPos;
        for (int i = 0; i < size(); i++)
        {
            if (value.equals(currentPos.data))
            {
                return i;
            }
            currentPos = currentPos.next;
        }
        return -1;
    }

    //4. A method called add() that takes a single parameter, a Song to be added to the end of the list.
    //The method should return a boolean indicating that the Song was added.

    /**
     * Adds a new node with the specified song value to the end of the list.
     * @param value the song value to be added
     * @return true if the song was successfully added to the list, false otherwise
     */
    public boolean add(Song value)
    {
        Node newNode = new Node(value);
        if (firstPos == null)
        {
            // the list is empty, set the new node as the first node
            firstPos = newNode;
        }
        else
        {
            // find the last node in the list
            Node currentPos = firstPos;
            while (currentPos.next != null)
            {
                currentPos = currentPos.next;
            }
            // set the new node as the next node of the last node
            currentPos.next = newNode;
        }
        size++;
        return true;
    }


    //  5. A method called add() that takes in two parameters, a Song to be added to the list and a position at which to
    //  add it. The position should be validated, and invalid positions handled accordingly. If the position is valid, the
    //  Song should be added to the list at that position.

    /**
     * Adds a new Song to the list at the specified position.
     * @param value the Song to be added to the list
     * @param position the position in the list where the Song will be added
     * @return true if the Song was added successfully, false otherwise
     */
    public boolean add(Song value, int position)
    {
        if (position < 0 || position > size)
        {
            // Invalid position, do not add the song
            return false;
        }
        else
        {
            // Valid position, add the song to the list
            Node newNode = new Node(value);
            if (position == 0)
            {
                // Add to the beginning of the list
                newNode.next = firstPos;
                firstPos = newNode;
            }
            else if (position == size)
            {
                // Add to the end of the list
                lastPost.next = newNode;
                lastPost = newNode;
            }
            else
            {
                // Add to the middle of the list
                Node currentPos = firstPos;
                for (int i = 0; i < position - 1; i++)
                {
                    currentPos = currentPos.next;
                }
                newNode.next = currentPos.next;
                currentPos.next = newNode;
            }
            size++;
            return true;
        }
    }

    // 6. A method called toArray() that takes no parameters.
    // The method should return an array containing all Songs in the list.
    /**
     * Returns an array containing all the songs in this list in proper sequence.
     * @return an array containing all the songs in this list in proper sequence.
     */
    public Song[] toArray()
    {
        Song[] songArray = new Song[size];
        Node currentPos = firstPos;
        int i = 0;
        while (currentPos != null)
        {
            songArray[i++] = currentPos.data;
            currentPos = currentPos.next;
        }
        return songArray;
    }

    // 7. A method called remove() that takes one parameter – the Song to be removed. Only the first instance of this
    // Song should be removed from the list
    /**
     * Removes the first occurrence of the specified song from this list, if it is present.
     * Returns true if this list contained the specified song, false otherwise.
     * @param value the song to be removed from this list, if present.
     * @return true if this list contained the specified song, false otherwise.
     */
    public boolean remove(Song value)
    {
        if (firstPos == null)
        {
            return false; // list is empty
        }

        if (value.equals(firstPos.data))
        {
            // remove from the beginning of the list
            firstPos = firstPos.next;
            size--;
            return true;
        }

        Node currentPos = firstPos;
        while (currentPos.next != null && !value.equals(currentPos.next.data))
        {
            currentPos = currentPos.next;
        }

        if (currentPos.next == null)
        {
            // value not found in the list
            return false;
        }

        // remove the node
        currentPos.next = currentPos.next.next;
        if (currentPos.next == null)
        {
            // last element was removed, update the last reference
            lastPost = currentPos;
        }
        size--;
        return true;
    }

    // 8. A method called isEmpty() that takes no parameters.
    // This should return a boolean indicating if there is data
    // currently stored in the list.

    /**
     * Returns whether the list is empty.
     * @return true if the list is empty, false otherwise
     */

    public boolean isEmpty()
    {
        return firstPos == null;
    }

    // 9. A method called tail() that takes no parameters. This should return the last element in the list

    /**
     * Returns the last element in the linked list.
     * @return the last element in the list, or null if the list is empty
     * @return
     */
    public Song tail()
    {
        if (firstPos == null)
        {
            return null; // if the list is empty, return null
        }

        Node currentPos = firstPos;
        while (currentPos.next != null)
        {
            currentPos = currentPos.next; // traverse to the last node in the list
        }

        return currentPos.data; // return the last element in the list
    }
}
