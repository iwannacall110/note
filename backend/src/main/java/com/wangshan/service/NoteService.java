package com.wangshan.service;

import com.wangshan.models.Forms.NoteForm;
import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface NoteService {
    NoteBookGroup addNoteBookGroup(Long user, String name);
    List<Note> getNotes();
    List<NoteBook> getNoteBooks();
    List<UserHasNoteBookGroupForm> getNoteBookGroupByUser(Long id);
    Note getNote(Long id);
    List<Note> getNoteLitesByGroup(Long group);
    List<Note> getNoteLitesByBook(Long noteBook);
    List<Note> getNoteLites();
    Boolean updateNoteContent(Note note);
    List<NoteBookGroup> getNoteBookGroup(Long user);
    Long addNoteBook(NoteBook noteBook);
    Boolean deleteNoteBook(Long noteBook);
    Long addNote(Note note);
    Integer updateNoteBook(NoteBook noteBook);
    Integer updateNote(Note note);
    Boolean deleteNote(Long note);
}
