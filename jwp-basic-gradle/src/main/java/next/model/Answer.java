package next.model;

import java.sql.Timestamp;
import java.time.Instant;

public class Answer {
    private long answerId;
    private String writer;
    private String contents;
    private Timestamp createdDate;
    private long questionId;

    public Answer(long answerId, String writer, String contents, Timestamp timestamp, long questionId) {
        this.answerId = answerId;
        this.writer = writer;
        this.contents = contents;
        this.createdDate = timestamp;
        this.questionId = questionId;
    }

    public Answer(String writer, String contents, long questionId) {
        //TODO 무허ㅏ는 생성자인지 잘 모르겟으니 정적팩토리
        this.writer = writer;
        this.contents = contents;
        this.createdDate = Timestamp.from(Instant.now());
        this.questionId = questionId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }


    @Override
    public String toString() {
        return "\n[" + questionId + "/" + answerId + "] " + writer + ": " + contents + "\n"  + createdDate;
    }
}
