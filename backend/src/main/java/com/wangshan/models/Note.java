package com.wangshan.models;

import java.util.Date;

/**
 * Created by Administrator on 2015/11/15.
 */

public class Note {
    private Long id;
    private String name;
    private Long noteBookGroup;
    private Long noteBook;
    private Byte[] content;
    private String remark;
    private Integer state;
    private Date createon;
    private Date updateon;

    public Note(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(Long noteBook) {
        this.noteBook = noteBook;
    }

    public Long getNoteBookGroup() {
        return noteBookGroup;
    }

    public void setNoteBookGroup(Long noteBookGroup) {
        this.noteBookGroup = noteBookGroup;
    }

    public Byte[] getContent() {
        return content;
    }

    public void setContent(Byte[] content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }

    public Date getUpdateon() {
        return updateon;
    }

    public void setUpdateon(Date updateon) {
        this.updateon = updateon;
    }
}
