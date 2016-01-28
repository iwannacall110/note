package com.wangshan.controllers;

import com.wangshan.models.Forms.NoteForm;
import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;
import com.wangshan.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wangshan on 2015/11/18.
 */
@Controller
@RequestMapping("/backend/note")
@SessionAttributes("token")
public class NoteController extends javax.servlet.http.HttpServlet{
    private static Logger log = LoggerFactory.getLogger(NoteController.class);
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getUser(HttpServletRequest request, HttpSession session){
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
    @ResponseBody
    public List<UserHasNoteBookGroupForm> getNoteBookGropByUser(@PathVariable(value = "user") Long user){
        return noteService.getNoteBookGroupByUser();
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    @ResponseBody
    public Boolean AddNoteBookGroup(@RequestBody NoteBookGroup noteBookGroup){
        return true;
    }

    @RequestMapping(value = "/lite/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getNoteLites(HttpServletRequest request, HttpSession session){
        String group = request.getParameter("group");
        String noteBook = request.getParameter("noteBook");
        List<Note> result = null;
        if(noteBook != null){
            result = noteService.getNoteLitesByBook(Long.valueOf(noteBook));
        } else if(group != null){
            result =  noteService.getNoteLitesByGroup(Long.valueOf(group));
        } else {
            result = noteService.getNoteLites();
        }
        return result;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Note getNoteById(@PathVariable(value = "id") Long id){
        return noteService.getNote(id);
    }

    @RequestMapping(value = "/{id}/save", method = RequestMethod.POST)
    @ResponseBody
    public Boolean saveNote(@PathVariable(value = "id") Long id, @RequestBody NoteForm body){
        System.out.println("===============: " + body.getContent());
        return true;
    }
}