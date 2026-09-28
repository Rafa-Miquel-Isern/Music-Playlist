# Music Playlist – Java Circular Queue

A console music player in Java built on a custom circular queue data structure.

## Features
- **Build a playlist** – add up to 5 songs with title and artist
- **Playback controls** – `SKIP` to the next song and `BACK` to the previous one, wrapping around the playlist
- **Remove** – drop the current song from the queue
- **Shuffle** – randomize the song order
- **Clear** – empty the whole playlist
- `QUIT` to exit

## How it works
Songs are stored in a fixed-size array with `front` and `rear` pointers that wrap
around using modular arithmetic, so skipping past the last song loops back to the first.

## Run it
javac Main.java CircularQueueSong.java
java Main

## Tech
Java · circular queue · arrays & modular arithmetic · Scanner input
