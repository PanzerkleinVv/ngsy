package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Ndkh {
    private String id;

    private String personId;

    @DateTimeFormat(pattern = "yyyy")
    private Date year;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}