package com.wangshan.service.impl;

import com.wangshan.dao.NoteBookDao;
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
    private NoteDao noteDao;
    @Autowired
    private NoteBookDao noteBookDao;
    @Autowired
    private UserHasNoteBookGroupDao userHasNoteBookGroupDao;

    @Override
    public int insertNote(Note note){
        return noteDao.insertNote(note);
    }

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

    public Boolean updateNoteContent(Long id, String content) {
        return noteDao.updateNoteContent(id, content);
    }
}
