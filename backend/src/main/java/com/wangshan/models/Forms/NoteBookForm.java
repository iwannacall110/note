package com.wangshan.models.forms;

import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public class NoteBookForm {

    private NoteBook noteBook;
    private List<Note> noteList;
    public NoteBookForm(){}

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
