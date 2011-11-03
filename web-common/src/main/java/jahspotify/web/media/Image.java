package jahspotify.web.media;

import java.util.Arrays;

/**
 * @author Johan Lindquist
 */
public class Image
{
    private String id;
    private ImageFormat imageFormat = ImageFormat.JPEG;
    private byte[] bytes;

    public Image()
    {
    }

    public Image(final String uri, final byte[] bytes)
    {
        this.id = uri;
        this.bytes = bytes;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public void setBytes(final byte[] bytes)
    {
        this.bytes = bytes;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Image{" +
                "bytes=" + Arrays.asList(bytes) +
                ", id=" + id +
                ", imageFormat=" + imageFormat +
                '}';
    }
}
