package com.wangshan.controllers;

import com.wangshan.models.Forms.NoteForm;
import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;
import com.wangshan.models.NoteBookGroup;
import com.wangshan.models.UserToken;
import com.wangshan.models.forms.UserHasNoteBookGroupForm;
import com.wangshan.service.NoteService;
import com.wangshan.service.UserService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by wangshan on 2015/11/18.
 */

// TODO 所有的笔记相关方法都的action都放在此处(后续将所有的逻辑移至akka的actor中)

@Controller
@RequestMapping("/backend/note")
@SessionAttributes("token")
public class NoteController extends javax.servlet.http.HttpServlet{
    private static Logger log = LoggerFactory.getLogger(NoteController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getUser(HttpServletRequest request, HttpSession session){
        return noteService.getNotes();
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public List<NoteBook> getNoteBook(){
        return noteService.getNoteBooks();
    }

    @RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserHasNoteBookGroupForm> getNoteBookGropByUser(@PathVariable(value = "user") Long user){
        return noteService.getNoteBookGroupByUser(user);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    @ResponseBody
    public List<NoteBookGroup> getNoteBookGropByUser2(HttpServletRequest request){
        //Long user = Long.parseLong(request.getParameter("user"));
        UserToken userToken = userService.getUserTokenByToken(request.getHeader("token"));
        return noteService.getNoteBookGroup(userToken.getUser());
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    @ResponseBody
    public Object AddNoteBookGroup(@RequestBody NoteBookGroup noteBookGroup){
        return noteService.addNoteBookGroup(noteBookGroup);
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
        return noteService.updateNoteContent(id, body.getContent(), body.getSize(), body.getDigest());
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addNoteBook(@RequestBody NoteBook noteBook){
		NoteBook nb = new NoteBook(noteBook.getName(), noteBook.getNoteBookGroup(), 0, 1, DateTime.now(), DateTime.now());
        nb.setId(noteService.addNoteBook(nb));
        return nb;
    }

    @RequestMapping(value = "/book/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteNoteBook(@PathVariable(value = "id") Long id){
        return noteService.deleteNoteBook(id);
    }

    @RequestMapping(value = "/book/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateNoteBook(@PathVariable(value = "id") Long id, @RequestBody NoteBook noteBook){
        noteBook.setId(id);
        noteBook.setUpdateon(new Timestamp(DateTime.now().getMillis()));
        return noteService.updateNoteBook(noteBook);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object createNote(@RequestBody Note note){
        Note n = new Note("no title note", note.getNoteBookGroup(), note.getNoteBook(), 1, DateTime.now(), DateTime.now());
        n.setId(noteService.addNote(n));
        return n;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateNote(@PathVariable(value = "id") Long id, @RequestBody Note note){
        note.setId(id);
        note.setUpdateon(new Timestamp(DateTime.now().getMillis()));
        return noteService.updateNote(note);
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteNote(@PathVariable(value = "id") Long id){
        return noteService.deleteNote(id);
    }
}