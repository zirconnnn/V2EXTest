package me.zircon.v2test.data.model;

/**
 * <Description> <br>
 *
 * @author yewanwan<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 16/1/28 <br>
 */
public class Topic {

    private String title;
    private String content;
    private String content_rendered;
    private String replies;
    private long created;
    private long last_modified;
    private long last_touched;
    private Member member;
    private Node node;

    private String eof;

    public String getEof() {
        return eof;
    }

    public void setEof(String eof) {
        this.eof = eof;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(long last_modified) {
        this.last_modified = last_modified;
    }

    public long getLast_touched() {
        return last_touched;
    }

    public void setLast_touched(long last_touched) {
        this.last_touched = last_touched;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
