/*
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
 */
package com.citizenwarwick.music

import kotlin.math.max

typealias Chord = Set<Note>

data class Note(val pitch: PitchClass, val octave: Int) : Comparable<Note> {
    override fun compareTo(other: Note): Int = Comparator<Note> { t, t2 ->
        when {
            t.pitch == t2.pitch && t.octave == t2.octave -> 0
            t.pitch > t2.pitch && t.octave >= t2.octave -> 1
            t.pitch < t2.pitch && t.octave > t2.octave -> 1
            else -> -1
        }
    }.compare(this, other)

    override fun toString(): String {
        return if (ACC_NOTES.contains(pitch)) {
            val shiftedNote = pitch.dec()
            "$shiftedNote#$octave"
        } else {
            "$pitch$octave"
        }
    }
}

enum class PitchClass {
    C,
    Cs,
    D,
    Ds,
    E,
    F,
    Fs,
    G,
    Gs,
    A,
    As,
    B;

    operator fun dec(): PitchClass {
        val index = max(values().indexOf(this) - 1, 0)
        return values()[index]
    }
}

/**
 * Turns any string sequence of notes such as "C0 D# G0" into a set of [Note]
 */
inline val String.chord: Chord
    get() = split(" ").map {
        when (it.length) {
            3 -> {
                val sharpFlat = it.substring(1, 2)
                val pitch = it.substring(0, 1)
                val octave = it.substring(2, 3).toInt()
                val pitchSum =
                    PitchClass.values()[PitchClass.valueOf(pitch).ordinal + (if (sharpFlat == "#") 1 else -1)]
                Note(pitchSum, octave)
            }
            2 -> {
                val note = it.substring(0, 1)
                val octave = it.substring(1, 2).toInt()
                Note(
                    PitchClass.valueOf(
                        note
                    ), octave
                )
            }
            else -> throw RuntimeException("Invalid format in $it")
        }
    }.toSet()


fun Set<Note>.lower(): Note = min()!!
fun Set<Note>.upper(): Note = max()!!
fun between(from: Note, to: Note): Int =
    ((to.octave - from.octave) * 12) + PitchClass.values().indexOf(to.pitch)

private val ACC_NOTES = listOf(PitchClass.Cs, PitchClass.Ds, PitchClass.Fs, PitchClass.Gs, PitchClass.As)
