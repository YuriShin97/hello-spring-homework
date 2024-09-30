<%--
  Created by IntelliJ IDEA.
  User: sinpyungho
  Date: 24. 9. 28.
  Time: 오전 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정하기</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
    <h1>게시글 수정</h1>
    <form method="post" action="/board/modify/${boardVO.id}">
        <div class="grid">
            <label for="subject">제목</label>
            <input id="subject" type="text" name="subject" value="${boardVO.subject}" />

            <label for="email">이메일</label>
            <input id="email" type="email" name="email" value="${boardVO.email}" />

            <label for="content">내용</label>
            <textarea id="content" name="content">${boardVO.content}</textarea>

            <div class="btn-group">
                <div class="right-align">
                    <input type="submit" value="저장" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>
