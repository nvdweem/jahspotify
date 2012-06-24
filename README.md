===============================================================================
Jah'Spotify Library
===============================================================================

## Note
This project aims more to be a library for other Spotify tools then to be a tool on itself. Use the johanlindquist/jahspotify repository for the Spotify tool.

The aim of this project will be to deliver a native project with as few dependencies as possible but which still delivers all libspotify functions, 
while being available on all (x86) platforms.

## Introduction

Jah'Spotify is a Java wrapper built on top of the Spotify native APIs (libspotify)

Currently supports:

* retrieving library (all user playlists/folders)
* retrieve a playlist
* retrieve a folder (including/excluding sub-folders and playlists)
* retrieve an album
* retrieve a track
* retrieve an image
* add tracks to a queue (single queue currently supported)
* play tracks
* pause/skip functions

## To build

Jah'Spotify supports the Linux and Windows versions of libspotify (see below for more details on building on Windows).

To build the sources first check them out from git

    git clone git://github.com/nvdweem/jahspotify.git
    cd jahspotify

Next, you need to download and install libspotify & request an API key from Spotify.  This can be done
on the http://developer.spotify.com website.

Generate the key and download the C code version of it.  Place this in a file called AppKey.h in the

    native/src/main/native/inc

directory.  You may want to place some #ifndef APPKEY statements in this to prevent linking problems.

Finally, execute the Maven build

    mvn clean install

### Building on Windows

#### Before compiling

1. Download MinGW and put the bin folder in your PATH.
2. Create an environment variable 'LIB_SPOTIFY' and point it to where you unpacked libspotify.

### Running on Windows

For windows, you will need to download a few more dependencies:

- pthread (http://sources.redhat.com/pthreads-win32/). pthreadGC2.dll needs to be in your path.

## Modules

* api

  provides the basic operations for interacting with Jah'Spotify (and in turn libspotify)

* native

  contains all native & JNI code interacting with libspotify

* services

  provides components which make the Api more easy to use

## Licensing

All Jah'Spotify code is released under the Apache 2.0 license