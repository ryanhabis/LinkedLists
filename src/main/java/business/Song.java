package business;

import java.util.Objects;

/**
 *
 * @author michelle
 */
public class Song
{
    /**
     ** Implement a class named Song. A Song is made up of two String fields: an artist and a title. Your Song class should
     ** provide the following functionality:
     * 1. A default constructor that sets the artist to “Joe Bloggs” and title to “Mmmbop”.
     * 2. A constructor that takes in two parameters – the artist and the title.
     * 3. Getter and setter methods for the artist and title.
     * 4. An equals() method and a hashCode() method – these should base their calculation on the artist and title fields.
     * 5. A toString() method that returns the artist and title information in a well-formatted manner.
     */

    // * 1. A default constructor that sets the artist to “Joe Bloggs” and title to “Mmmbop”.

    private String title;
    private String artist;


    public Song()
    {
        title = "Mmmbop";
        artist = "Joe Bloggs";
    }

    // * 2. A constructor that takes in two parameters – the artist and the title.

    public Song(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
    }
    // * 3. Getter and setter methods for the artist and title.

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    // * 4. An equals() method and a hashCode() method – these should base their calculation on the artist and title fields.

    @Override
    public boolean equals(Object o)
    {
        // Check if this object is being compared to itself
        if (this == o) return true;

        // Check if the object being compared is null or is not of the same class
        if (o == null || getClass() != o.getClass()) return false;

        // Cast the object being compared to a Song object
        Song song = (Song) o;

        // Compare the title and artist fields of the two Song objects
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist);
    }

//     * 4. An equals() method and a hashCode() method – these should base their calculation on the artist and title fields.
    @Override
    public int hashCode()
    {
        return Objects.hash(getTitle(), getArtist());
    }

    // * 5. A toString() method that returns the artist and title information in a well-formatted manner.
    @Override
    public String toString()
    {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
