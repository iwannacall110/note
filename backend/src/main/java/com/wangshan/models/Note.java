package com.wangshan.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/11/15.
 */

public class Note {
    private Long id;                    //主键
    private String sn;                  //笔记的sn,全局唯一
    private String name;
    private Long noteBookGroup;
    private Long noteBook;
    private String title;               //标题
    private String digest;              //摘要
    private String media;               //附件(url)
    private Object content;             //文档主体,此处不能是type[],必须是Obect类型,否则无法转换
    private Long size;                  //文档大小(B)
    private String remark;
    private Integer state;
    private Timestamp createon;
    private Timestamp updateon;

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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}
