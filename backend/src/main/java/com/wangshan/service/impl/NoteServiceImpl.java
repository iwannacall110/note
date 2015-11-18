package com.wangshan.service.impl;

import com.wangshan.dao.NoteDao;
import com.wangshan.models.Note;
import com.wangshan.models.User;
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

    @Override
    public int insertNote(Note note){
        return noteDao.insertNote(note);
    }
    @Override
    public List<Note> getNotes(){
        return noteDao.selectNotes();
    }
}
