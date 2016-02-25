package com.wangshan.dao;

import com.wangshan.models.NoteBook;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */

public interface NoteBookDao {
    List<NoteBook> selectNoteBooks();
    NoteBook selectNoteBook(Long id);
    Integer addNoteBook(NoteBook noteBook);
    Integer updateNoteBook(NoteBook noteBook);
    Integer deleteNoteBook(NoteBook noteBook);
    Integer reduceNoteCount(Long id);
    Integer addNoteCount(Long id);
}
