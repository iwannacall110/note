package com.wangshan.models.Forms;

import com.wangshan.models.Note;
import com.wangshan.models.NoteBook;

import java.util.List;

/**
 * Created by Administrator on 2016/1/27.
 */

public class NoteForm {

    private Long id;
    private String name;
    private String content;
    public NoteForm(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
