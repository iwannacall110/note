package com.wangshan.dao;

import com.wangshan.models.Forms.NoteForm;
import com.wangshan.models.Note;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface NoteDao {
    Integer addNote(Note note);
    List<Note> selectNotes();
    Note selectNote(Long id);
    List<Note> selectNoteLitesByGroup(Long group);
    List<Note> selectNoteLitesByBook(Long noteBook);
    List<Note> selectNoteLites();
    Boolean updateNoteContent(Note note);
    Integer updateNote(Note note);
    Integer deleteNote(Note note);
}
