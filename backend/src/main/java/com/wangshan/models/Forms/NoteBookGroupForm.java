package com.wangshan.models.forms;

import com.wangshan.models.NoteBookGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public class NoteBookGroupForm {

    private NoteBookGroup noteBookGroup;
    private List<NoteBookForm> noteBookFormList;
    public NoteBookGroupForm(){}

    public NoteBookGroup getNoteBookGroup() {
        return noteBookGroup;
    }

    public void setNoteBookGroup(NoteBookGroup noteBookGroup) {
        this.noteBookGroup = noteBookGroup;
    }

    public List<NoteBookForm> getNoteBookFormList() {
        return noteBookFormList;
    }

    public void setNoteBookFormList(List<NoteBookForm> noteBookFormList) {
        this.noteBookFormList = noteBookFormList;
    }
}
