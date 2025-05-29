package vk.autotest.project.noteData;

import java.util.Date;

public class Note {
    private String id;
    private String title;
    private String content;

    private final Date createdAt;

    public Note(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {this.title = title;}

    public void setContent(String content) {this.content = content;}
    public Date getCreatedAt() {return createdAt;}
}
