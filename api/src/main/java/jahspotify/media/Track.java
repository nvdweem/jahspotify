package jahspotify.media;

import java.util.ArrayList;
import java.util.List;


/**
 * Holds information about a track.
 *
 * @author Felix Bruns <felixbruns@web.de>
 * @author Johan Lindquist
 */
public class Track extends Media
{
    /**
     * Title of this track.
     */
    private String title;

    /**
     * {@link Artist}s of this track.
     */
    private List<Link> artists = new ArrayList<Link>();

    /**
     * A {@link Link} to the album which this track belongs to.
     */
    private Link album;

    /**
     * Track number on a certain disk.
     */
    private int trackNumber;

    /**
     * Length of this track in seconds.
     */
    private int length;

    /**
     * The identifier for this tracks cover image (32-character string).
     */
    private String cover;

    /**
     * If this track is explicit.
     */
    private boolean explicit;

    /**
     * The popularity of the track.
     */
    private int popularity;

    /**
     * Creates an empty {@link Track} object.
     */
    public Track()
    {
        this.title = null;
        this.artists = new ArrayList<Link>();
        this.album = null;
        this.trackNumber = -1;
        this.length = -1;
        this.cover = null;
    }

    /**
     * Get the tracks title.
     *
     * @return The title of this track.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Set the tracks title.
     *
     * @param title The desired name of this track.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Get the tracks artists.
     *
     * @return An {@link Artist}s object.
     */
    public List<Link> getArtists()
    {
        return this.artists;
    }

    /**
     * Set the tracks artists.
     *
     * @param artists The desired {@link Artist}s of this track.
     */
    public void setArtists(List<Link> artists)
    {
        this.artists = artists;
    }

    public void addArtist(Link artist)
    {
        if (artists == null)
        {
            artists = new ArrayList<Link>();
        }
        artists.add(artist);

    }

    /**
     * Get the tracks album.
     *
     * @return An {@link Album} object.
     */
    public Link getAlbum()
    {
        return this.album;
    }

    /**
     * Set the tracks album.
     *
     * @param album The desired {@link Album} of this track.
     */
    public void setAlbum(Link album)
    {
        this.album = album;
    }

    /**
     * Get the tracks number on a certain disk.
     *
     * @return An integer denoting the track number or -1 if not available.
     */
    public int getTrackNumber()
    {
        return this.trackNumber;
    }

    /**
     * Set the tracks number on a certain disk.
     *
     * @param trackNumber A positive integer greater than zero.
     */
    public void setTrackNumber(int trackNumber)
    {
        /* Check if track number is valid. */
        if (trackNumber <= 0)
        {
            throw new IllegalArgumentException("Expecting a track number greater than zero.");
        }

        this.trackNumber = trackNumber;
    }

    /**
     * Get the tracks length in milliseconds.
     *
     * @return An integer representing the length in milliseconds or -1 if not available.
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * Set the tracks length in milliseconds.
     */
    public void setLength(int length)
    {
        /* Check if length is valid. */
        if (length <= 0)
        {
            throw new IllegalArgumentException("Expecting a length greater than zero.");
        }

        this.length = length;
    }

    /**
     * Get the tracks cover image identifier.
     *
     * @return A 32-character image identifier.
     */
    public String getCover()
    {
        return this.cover;
    }

    /**
     * Set the tracks cover image identifier.
     *
     * @param cover A 32-character image identifier.
     */
    public void setCover(String cover)
    {
        this.cover = cover;
    }

    /**
     * Return if this track is explicit.
     *
     * @return A boolean value.
     */
    public boolean isExplicit()
    {
        return this.explicit;
    }

    /**
     * Set if this track is explicit.
     *
     * @param explicit A boolean value.
     */
    public void setExplicit(boolean explicit)
    {
        this.explicit = explicit;
    }

    /**
     * Returns the popularity of this track.
     */
    public int getPopularity() {
		return popularity;
	}

    /**
     * Sets the popularity of this track.
     * @param popularity The popularity as a number between 0 and 100.
     */
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

    /**
     * Tracks don't need loading and are always complete.
     * @return true if the media is complete.
     */
	@Override
	public boolean isLoaded() {
		return true;
	}

	@Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Track))
        {
            return false;
        }

        final Track track = (Track) o;

        if (explicit != track.explicit)
        {
            return false;
        }
        if (length != track.length)
        {
            return false;
        }
        if (trackNumber != track.trackNumber)
        {
            return false;
        }
        if (album != null ? !album.equals(track.album) : track.album != null)
        {
            return false;
        }
        if (artists != null ? !artists.equals(track.artists) : track.artists != null)
        {
            return false;
        }
        if (cover != null ? !cover.equals(track.cover) : track.cover != null)
        {
            return false;
        }
        if (title != null ? !title.equals(track.title) : track.title != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artists != null ? artists.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        result = 31 * result + trackNumber;
        result = 31 * result + length;
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (explicit ? 1 : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Track{" +
                "album=" + album +
                ", title='" + title + '\'' +
                ", artists=" + artists +
                ", trackNumber=" + trackNumber +
                ", length=" + length +
                ", cover='" + cover + '\'' +
                ", explicit=" + explicit +
                "} " + super.toString();
    }
}
