package com.wangshan.service;

import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface NoteService {
    public int insertNote(Note note);
    public List<Note> getNotes();
    public List<NoteBook> getNoteBooks();
    public List<NoteBookGroup> getNoteBookGroupByUser();
}
