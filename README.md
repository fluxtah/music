[![](https://jitpack.io/v/fluxtah/music.svg)](https://jitpack.io/#fluxtah/music)

# What is this?
This is a small API to represent musical notes written in Kotlin. A musical note is represented as `Note`. You can construct a note like this

```kotlin
val note = Note(C, 0)
```

Where the first part `C` comes from an enum `PitchClass` where all of the notes in the chromatic scale are represented.

`C, Cs, D, Ds, E, F, Fs, G, Gs, A, As, B`

Notes ending in `s` represent `#` where `Cs` would mean `C#`.

## Creating chords
The API has an extension function that can turn any correctly formatted string into a Set (can be used as a chord), for instance:-

```kotlin
val chord:Set<Note> = "C0 D#0 E0".chord
```

## Highest and lowest notes of a chord
With `Set<Note>` you can find the highest note

```kotlin
val highest = chord.upper()
```

```kotlin
val lowest = chord.lower()
```

## Number of notes between two notes
Sometimes its convenient to know how many notes are between two given notes, like this:-
```kotlin
val numNotesBetween = between(Note(C, 0), Note(C, 1)) // 12 notes
```

# License
```
 Copyright 2020 Ian Warwick

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```
