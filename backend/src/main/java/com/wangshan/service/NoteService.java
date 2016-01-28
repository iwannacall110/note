package com.wangshan.service;

import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface NoteService {
    int insertNote(Note note);
    List<Note> getNotes();
    List<NoteBook> getNoteBooks();
    List<UserHasNoteBookGroupForm> getNoteBookGroupByUser();
    Note getNote(Long id);
    List<Note> getNoteLitesByGroup(Long group);
    List<Note> getNoteLitesByBook(Long noteBook);
    List<Note> getNoteLites();
    Boolean updateNoteContent(Long id, String content);
}
