===============================================================================
Jah'Spotify Library
===============================================================================

# Note
This project aims more to be a library for other Spotify tools then to be a tool on itself. Use the johanlindquist/jahspotify repository for the Spotify tool.
Although this repository still has the web maven part, it isn't maintained and will probably not work.

The aim of this project will be to deliver a native project with as few dependencies as possible. For now the following dependencies which could be stripped are required:
- GSON
- HTTP components
- Spring
- jen-api
- MongoDB
- OpenAL (for native part)

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
* dynamic playlist using echonest apis
* basic historical track list view
* very basic android app for remote control

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
2. Download the OpenAL SDK from and copy the include folder to the MinGW include folder and rename it to AL
3. The native pom.xml has a reference to a local LibSpotify folder. Change this to your own Spotify folder. You'll get an error that the api.h file can't be found if you don't.
4. Add a reference to your OpenAL installation folder

You can find the OpenAL SDK at:

    http://connect.creativelabs.com/developer/Wiki/OpenAL%20SDK%20for%20Windows.aspx

## Running

Download and install MongoDB

### Running on Windows

For windows, you will need to download a few more dependencies:

- pthread (http://sources.redhat.com/pthreads-win32/). pthreadGC2.dll needs to be in your path.
- I didn't have to add any paths to OpenAL but I installed the SDK. Let me know if you get a message complaining that not all dependencies are available.

## Modules

* api

  provides the basic operations for interacting with Jah'Spotify (and in turn libspotify)

* native

  contains all native & JNI code interacting with libspotify

* services

  provides all Jah'Spotify Spring services

* web

  provides the RESTful API (json based)

* executable-war

  provides a single, executable Jah'Spotify war file

* web-client

  provides java client for interacting with the RESTful API

* web-common

  provides the java beans which are serialized over the RESTful API

* storage

  provides basic storage implementations for caching media objects (tracks/images/etc)

## Licensing

All Jah'Spotify code is released under the Apache 2.0 license

## Contributors

Niels vd Weem

Thanks!
