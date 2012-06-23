package jahspotify.services;

import jahspotify.JahSpotify;
import jahspotify.impl.JahSpotifyImpl;

import javax.annotation.PreDestroy;

/**
 * @author Johan Lindquist
 */
public class JahSpotifyService
{
    private JahSpotify _jahSpotify;

    private static JahSpotifyService instance;
    public static JahSpotifyService getInstance() {
    	if (instance == null) {
    		instance = new JahSpotifyService();
    		instance.initialize();
    	}
    	return instance;
    }

    public JahSpotify createJahSpotify()
    {
        return _jahSpotify;
    }

    private void initialize()
    {
        if (_jahSpotify == null)
        {
            _jahSpotify = JahSpotifyImpl.getInstance();
            if (!_jahSpotify.isStarted())
            {
                _jahSpotify.login(System.getProperty("jahspotify.spotify.username"), System.getProperty("jahspotify.spotify.password"));
            }
        }
    }

    @PreDestroy
    public void shutdown()
    {
        if (_jahSpotify != null)
        {
            // Stop playback and then shutdown the instance
            _jahSpotify.stop();
            _jahSpotify.shutdown();
        }
    }

    public JahSpotify getJahSpotify()
    {
        return _jahSpotify;
    }

}
