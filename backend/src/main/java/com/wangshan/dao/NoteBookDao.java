package com.wangshan.dao;

import com.wangshan.models.NoteBook;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface NoteBookDao {
    List<NoteBook> selectNoteBooks();
    Integer addNoteBook(NoteBook noteBook);
}
