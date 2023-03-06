# This is a listed walk through on how I have made this program

Song Specification:
Implement a class named Song. A Song is made up of two String fields: an artist and a title. Your Song class should
provide the following functionality:
1. A default constructor that sets the artist to “Joe Bloggs” and title to “Mmmbop”.
2. A constructor that takes in two parameters – the artist and the title.
3. Getter and setter methods for the artist and title.
4. An equals() method and a hashCode() method – these should base their calculation on the artist and title fields.
5. A toString() method that returns the artist and title information in a well-formatted manner.
LinkedList Specification:
Implement a list to store Songs. This list should be implemented as a link-based list class named LinkedList. This list
should maintain a tail reference, as well as a reference to the first element. The following functionality should be
provided:
1. A method called size() that takes no parameters & returns the number of Songs currently stored in your list.
2. A method called get() that takes one parameter, an int representing the position from which data should be
retrieved. The position should be validated and invalid positions handled accordingly.
If the position is valid, the method should return the data (a Song) in the position specified.
3. A method called indexOf() that takes one parameter, a Song to be found in the list. The method should
return an int indicating the position at which the Song could be found. If the Song could not be found, an
appropriate value should be returned to indicate this.
4. A method called add() that takes a single parameter, a Song to be added to the end of the list.
The method should return a boolean indicating that the Song was added.
5. A method called add() that takes in two parameters, a Song to be added to the list and a position at which to
add it. The position should be validated, and invalid positions handled accordingly. If the position is valid, the
Song should be added to the list at that position.
6. A method called toArray() that takes no parameters. The method should return an array containing all Songs
in the list.
7. A method called remove() that takes one parameter – the Song to be removed. Only the first instance of this
Song should be removed from the list.
The method should return a boolean indicating that the Song was removed.
8. A method called isEmpty() that takes no parameters. This should return a boolean indicating if there is data
currently stored in the list.
9. A method called tail() that takes no parameters. This should return the last element in the list.


# Unit Testing Specification:
You have been provided with a set of junit tests for the majority of the methods listed above. However, there are no
tests provided for:
1. The add method specified in point 5 (add a Song to a specific position)
2. The toArray method specified in point 6 (get an array of the list contents)
3. The tail method specified in pont 9 (retrieve the last element in the list).
You are required to write all appropriate tests for these methods in the LinkedListExtraTests class, and the tests
should be given an informative name indicating the method name and what aspect of the method is being tested.
A Note on Commenting:
You are required to include a Javadoc comment for every method, test and constructor you write. These comments
should employ the standard Javadoc tags and contain all appropriate information explaining the functionality
parameters, return data and any exceptions thrown (along with why they might be thrown).
Deliverables:
One Netbeans project containing your amended Song class(Song.java), amended LinkedList class (LinkedList.java), and
the amended ListedListExtraTests class (LinkedListExtraTests.java), all stored in the original project packages.
