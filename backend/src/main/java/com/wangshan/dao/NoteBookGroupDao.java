package com.wangshan.dao;

import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface NoteBookGroupDao {
    List<NoteBook> selectNoteBooks();
    Long addNoteBookGroup(NoteBookGroup noteBookGroup);
    List<NoteBookGroup> selectGroupByUser(Long user);
    Integer reduceNoteCount(Long id);
    Integer addNoteCount(Long id);
}
