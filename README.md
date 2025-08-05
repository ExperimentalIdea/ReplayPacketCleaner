# Replay Packet Cleaner 
Replay Packet Cleaner (or RPC for short) is a standalone tool written in Java for editing [ReplayMod](https://github.com/ReplayMod/ReplayMod) replay archives with the primary goal of improving the timeline and rendering performance of replays in ReplayMod by removing unwanted packets.

RPC can also override the time/weather and remove most particles effects, which helps in producing timelapses that are much more pleasant for viewers to watch.

### This tool can
- Override the time of day
- Override the weather
- Remove Block Action packets
- Remove all entities (except players)
- Remove most particles
- Remove most sounds

### Version Support
This tool currently supports replays recorded in the following versions:
- 1.21
- 1.21.1
- 1.21.2
- 1.21.3
- 1.21.4
- 1.21.5
- 1.21.6
- 1.21.7
- 1.21.8

With support for older versions planned to be added in future releases.

For overriding the time of day and removing weather from replays recorded in older versions, please take a look at the tools [BobLite](https://github.com/RaderRMT/BobLite) and [ImBob](https://github.com/RaderRMT/ImBob) by [RaderRMT](https://github.com/RaderRMT).

### Requirements
- Java 21 or newer

## Usage
ReplayPacketCleaner features a graphical user interface to easily drag and drop in replay archives or import them with a file browser. Then you can then configure options for how the replay(s) will be manipulated and when you are ready to export, choose the directory the replay(s) will be saved to.

While you are waiting for your replay(s) to finish processing, you can choose to import more replays and export those with the same or even different configured options. RPC works well with large batches of replays on many core CPUs, as each replay will be processed on their own thread concurrently from one another. 

This tool does not overwrite your original replays, instead it creates copies of your selected replays and works off of them instead. The exported replays will have `(RPC)` appended to the file name for easily distinguishing them from your original replays and to prevent you from accidentally overwriting your original replay archives.

***NOTE:*** *This tool experimental and may produce garbage replay files that fail to work properly or at all with ReplayMod. DON’T EVER DELETE YOUR ORIGINAL REPLAY FILES!*


### Disclaimer
This project is not affiliated with ReplayMod in any way. Any issues arising from using this tool should be reported on this projects [Issue Tracker](https://github.com/ExperimentalIdea/ReplayPacketCleaner/issues).

## License
ReplayPacketCleaner is provided under the terms of the Apache 2.0 License. See the included `LICENSE.txt` file for details.
