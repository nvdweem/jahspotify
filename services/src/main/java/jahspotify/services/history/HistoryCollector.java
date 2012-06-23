package jahspotify.services.history;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *        or more contributor license agreements.  See the NOTICE file
 *        distributed with this work for additional information
 *        regarding copyright ownership.  The ASF licenses this file
 *        to you under the Apache License, Version 2.0 (the
 *        "License"); you may not use this file except in compliance
 *        with the License.  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *        Unless required by applicable law or agreed to in writing,
 *        software distributed under the License is distributed on an
 *        "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *        KIND, either express or implied.  See the License for the
 *        specific language governing permissions and limitations
 *        under the License.
 */

import jahspotify.services.AbstractMediaPlayerListener;
import jahspotify.services.MediaPlayer;
import jahspotify.services.QueueTrack;

/**
 * @author Johan Lindquist
 */
public class HistoryCollector
{
    private MediaPlayer _mediaPlayer = MediaPlayer.getInstance();

    private long _trackStartTime;
    private long _trackTimePointer;
    private long _trackPlayTime;

    public void initialize()
    {
        _mediaPlayer.addMediaPlayerListener(new AbstractMediaPlayerListener()
        {
            @Override
            public void paused(final QueueTrack currentTrack)
            {
                _trackPlayTime = _trackPlayTime + (System.currentTimeMillis() - _trackTimePointer) / 1000;
            }

            @Override
            public void stopped(final QueueTrack currentTrack)
            {
                _trackPlayTime = _trackPlayTime + (System.currentTimeMillis() - _trackTimePointer) / 1000;
            }

            @Override
            public void resume(final QueueTrack currentTrack)
            {
                _trackTimePointer = System.currentTimeMillis();
            }

            @Override
            public void trackStart(final QueueTrack queueTrack)
            {
                _trackStartTime = System.currentTimeMillis();
                _trackTimePointer = _trackStartTime;
                _trackPlayTime = 0;
            }

            @Override
            public void trackEnd(final QueueTrack queueTrack, final boolean forcedEnd)
            {
                _trackPlayTime = _trackPlayTime + (System.currentTimeMillis() - _trackTimePointer) / 1000;
                _trackPlayTime = 0;
                _trackTimePointer = 0;
            }
        });
    }

}
