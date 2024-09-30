package com.ktdsuniversity.edu.hellospringhomework.bbs.vo;

public class ModifyBoardVO {
	
	private int id;
	private String subject; // 게시글 제목
    private String email; // 이메일
    private String content; // 게시글 내용

    // 게터, 세터 메서드 정의
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
