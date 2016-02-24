package com.wangshan.service.impl;

import com.wangshan.dao.NoteBookDao;
import com.wangshan.dao.NoteBookGroupDao;
import com.wangshan.dao.NoteDao;
import com.wangshan.dao.UserHasNoteBookGroupDao;
import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.UserHasNoteBookGroup;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;
import com.wangshan.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/11/15.
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteBookGroupDao noteBookGroupDao;
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private NoteBookDao noteBookDao;
    @Autowired
    private UserHasNoteBookGroupDao userHasNoteBookGroupDao;

    @Override
    public List<Note> getNotes(){
        return noteDao.selectNotes();
    }

    @Override
    public List<NoteBook> getNoteBooks(){ return noteBookDao.selectNoteBooks();}

    @Override
    public List<UserHasNoteBookGroupForm> getNoteBookGroupByUser(){
        return userHasNoteBookGroupDao.selectNoteBookGroupByUser();
    }

    @Override
    public Note getNote(Long id){
        return noteDao.selectNote(id);
    }

    @Override
    public List<Note> getNoteLitesByGroup(Long group){
        return noteDao.selectNoteLitesByGroup(group);
    }

    @Override
    public List<Note> getNoteLitesByBook(Long noteBook){
        return noteDao.selectNoteLitesByBook(noteBook);
    }

    @Override
    public List<Note> getNoteLites(){
        return noteDao.selectNoteLites();
    }

    @Override
    public Boolean updateNoteContent(Long id, String content, Integer size, String digest) {
        return noteDao.updateNoteContent(id, content, size, digest);
    }

    @Override
    public List<NoteBookGroup> getNoteBookGroup(Long user){
        return noteBookGroupDao.selectGroupByUser(user);
    }

    @Override
    public Long addNoteBook(NoteBook noteBook){
        noteBookDao.addNoteBook(noteBook);
        return noteBook.getId();
    }

    @Override
    public Long addNote(Note note){
        noteDao.addNote(note);
        return note.getId();
    }

    @Override
    public Integer updateNoteBook(NoteBook noteBook){
        return noteBookDao.updateNoteBook(noteBook);
    }

    @Override
    public Integer updateNote(Note note){
        return noteDao.updateNote(note);
    }
}
