package com.wangshan.models.forms;

import com.wangshan.models.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public class UserHasNoteBookGroupForm {

    private User user;
    private List<NoteBookGroupForm> noteBookGroupFormList;
    public UserHasNoteBookGroupForm(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<NoteBookGroupForm> getNoteBookGroupFormList() {
        return noteBookGroupFormList;
    }

    public void setNoteBookGroupFormList(List<NoteBookGroupForm> noteBookGroupFormList) {
        this.noteBookGroupFormList = noteBookGroupFormList;
    }
}
