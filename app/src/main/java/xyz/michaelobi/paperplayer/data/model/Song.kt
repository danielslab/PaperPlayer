/*
 * MIT License
 *
 * Copyright (c) 2017 MIchael Obi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package xyz.michaelobi.paperplayer.data.model

import android.database.Cursor
import android.provider.MediaStore

/**
 * PaperPlayer
 * Michael Obi
 * 15 10 2016 3:23 PM
 */

data class Song(val id: Long, val title: String, val album: String, val artist: String,
                val year: String, val songUri: String, val albumId: Long) {

    companion object {
        fun from(cursor: Cursor): Song {
            val titleColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Media.TITLE)
            val idColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID)
            val artistColumn = cursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST)
            val pathColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
            val albumIdColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
            val albumColumn = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)
            val yearColumn = cursor.getColumnIndex(MediaStore.Audio.Media.YEAR)
            return Song(
                    cursor.getLong(idColumn),
                    cursor.getString(titleColumn)?: "",
                    cursor.getString(albumColumn)?: "",
                    cursor.getString(artistColumn)?: "",
                    cursor.getString(yearColumn) ?: "",
                    cursor.getString(pathColumn),
                    cursor.getLong(albumIdColumn)
            )
        }
    }
}
