package com.Springboot.StudentManagement.Rest;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeline;

    public StudentErrorResponse(){

    }
    public StudentErrorResponse(int status,String message,long timeline){
        this.status=status;
        this.message=message;
        this.timeline=timeline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeline() {
        return timeline;
    }

    public void setTimeline(long timeline) {
        this.timeline = timeline;
    }
}
