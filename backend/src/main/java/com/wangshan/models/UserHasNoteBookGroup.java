package com.wangshan.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/15.
 */

public class UserHasNoteBookGroup {
    private Long user;
    private Long noteBookGroup;
    private Integer order;
    private Integer state;
    private Timestamp createon;
    private Timestamp updateon;

    public UserHasNoteBookGroup(){}
    public UserHasNoteBookGroup(Long user, Long noteBookGroup, Integer state, DateTime createon, DateTime updateon){
        this.user = user;
        this.noteBookGroup = noteBookGroup;
        this.state = state;
        this.createon = new Timestamp(createon.getMillis());
        this.updateon = new Timestamp(updateon.getMillis());
    }


    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getNoteBookGroup() {
        return noteBookGroup;
    }

    public void setNoteBookGroup(Long noteBookGroup) {
        this.noteBookGroup = noteBookGroup;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
}
