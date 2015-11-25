package com.wangshan.dao;

import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.UserHasNoteBookGroup;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface UserHasNoteBookGroupDao {
    public List<UserHasNoteBookGroupForm> selectNoteBookGroupByUser();
}
