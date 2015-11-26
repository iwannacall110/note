package com.wangshan.controllers;

import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;
import com.wangshan.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangshan on 2015/11/18.
 */
@Controller
@RequestMapping("/backend/note")
public class NoteController {
    private static Logger log = LoggerFactory.getLogger(NoteController.class);
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getUser(){
        System.out.println("=====================: " + noteService.getNotes().getClass());
        for (Note note : noteService.getNotes()){
            System.out.println("================: " + note.getCreateon());
        }
        return noteService.getNotes();
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public List<NoteBook> getNoteBook(){
        System.out.println("=====================: " + noteService.getNotes().getClass());
        for (Note note : noteService.getNotes()){
            System.out.println("================: " + note.getCreateon());
        }
        return noteService.getNoteBooks();
    }

    @RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    @ResponseBody /* 此注解是将返回的数据直接写入response的body中*/
    public List<UserHasNoteBookGroupForm> getNoteBookGropByUser(
            @PathVariable(value = "user") Long user){
        log.info("=======================================user: " + user);
        //log.info("=======================================token: " + token);
        for (UserHasNoteBookGroupForm note : noteService.getNoteBookGroupByUser()){
            System.out.println("================: " + note.getClass());
        }
        return noteService.getNoteBookGroupByUser();
    }
}
