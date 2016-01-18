package com.wangshan.dao;

import com.wangshan.models.Note;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface NoteDao {
    public int insertNote(Note note);
    public List<Note> selectNotes();
    public Note selectNote(Long id);
}
