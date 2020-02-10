package com.citizenwarwick.music

import junit.framework.Assert.assertEquals
import org.junit.Test

class NotesTest {
    @Test
    fun betweenTest() {
        val numNoteBetween = between(Note(PitchClass.C, 0), Note(PitchClass.C, 0))
        assertEquals(0, numNoteBetween)

        val numNoteBetween2 = between(Note(PitchClass.C, 0), Note(PitchClass.B, 0))
        assertEquals(11, numNoteBetween2)

        val numNoteBetween3 = between(Note(PitchClass.C, 0), Note(PitchClass.C, 1))
        assertEquals(12, numNoteBetween3)

        val numNoteBetween4 = between(Note(PitchClass.C, 0), Note(PitchClass.Cs, 1))
        assertEquals(13, numNoteBetween4)

        val numNoteBetween5 = between(Note(PitchClass.C, 0), Note(PitchClass.C, 2))
        assertEquals(24, numNoteBetween5)

        val numNoteBetween6 = between(Note(PitchClass.C, 1), Note(PitchClass.C, 0))
        assertEquals(-12, numNoteBetween6)

        val numNoteBetween7 = between(Note(PitchClass.C, 1), Note(PitchClass.B, 0))
        assertEquals(-1, numNoteBetween7)
    }

    @Test
    fun testIncNote() {
        var note = Note(PitchClass.C, 0)
        assertEquals(++note, Note(PitchClass.Cs, 0))
        assertEquals(++note, Note(PitchClass.D, 0))
        assertEquals(++note, Note(PitchClass.Ds, 0))

        var boundaryNote = Note(PitchClass.B, 0)
        assertEquals(++boundaryNote, Note(PitchClass.C, 1))
    }

    @Test
    fun testDecNote() {
        var note = Note(PitchClass.F, 0)
        assertEquals(--note, Note(PitchClass.E, 0))
        assertEquals(--note, Note(PitchClass.Ds, 0))
        assertEquals(--note, Note(PitchClass.D, 0))

        var boundaryNote = Note(PitchClass.C, 1)
        assertEquals(--boundaryNote, Note(PitchClass.B, 0))
    }

    @Test
    fun testAdd() {
        assertEquals(Note(PitchClass.C, 0), Note(PitchClass.C, 0) + 1)
        assertEquals(Note(PitchClass.D, 0), Note(PitchClass.C, 0) + 2)
        assertEquals(Note(PitchClass.E, 0), Note(PitchClass.C, 0) + 3)
        assertEquals(Note(PitchClass.F, 0), Note(PitchClass.C, 0) + 4)
        assertEquals(Note(PitchClass.G, 0), Note(PitchClass.C, 0) + 5)
        assertEquals(Note(PitchClass.A, 0), Note(PitchClass.C, 0) + 6)
        assertEquals(Note(PitchClass.B, 0), Note(PitchClass.C, 0) + 7)
        assertEquals(Note(PitchClass.C, 1), Note(PitchClass.C, 0) + 8)
        assertEquals(Note(PitchClass.D, 1), Note(PitchClass.C, 0) + 9)
        assertEquals(Note(PitchClass.E, 1), Note(PitchClass.C, 0) + 10)
        assertEquals(Note(PitchClass.F, 1), Note(PitchClass.C, 0) + 11)
        assertEquals(Note(PitchClass.G, 1), Note(PitchClass.C, 0) + 12)
        assertEquals(Note(PitchClass.A, 1), Note(PitchClass.C, 0) + 13)
    }
}
