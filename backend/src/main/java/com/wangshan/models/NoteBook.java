package com.wangshan.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/15.
 */

public class NoteBook {
    private Long id;
    private String name;
    private Long noteBookGroup;
    private Integer noteCount;
    private String remark;
    private Integer state;
    private Timestamp createon;
    private Timestamp updateon;

    public NoteBook(){}
    public NoteBook(String name, Long noteBookGroup, Integer noteCount, Integer state, DateTime createon, DateTime updateon){
        this.name = name;
        this.noteBookGroup = noteBookGroup;
        this.noteCount = noteCount;
        this.state = state;
        this.createon = new Timestamp(createon.getMillis());
        this.updateon = new Timestamp(updateon.getMillis());
    }
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

    public Long getNoteBookGroup() {
        return noteBookGroup;
    }

    public void setNoteBookGroup(Long noteBookGroup) {
        this.noteBookGroup = noteBookGroup;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getCreateon() {
        return createon;
    }

    public void setCreateon(Timestamp createon) {
        this.createon = createon;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getUpdateon() {
        return updateon;
    }

    public void setUpdateon(Timestamp updateon) {
        this.updateon = updateon;
    }

    public Integer getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }
}
