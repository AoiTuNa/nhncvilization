<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="/resources/style.css" />
</head>
<body>
<h1>주민 목록</h1>
<table>
    <caption></caption>
    <thead>
    <tr>
        <th>이름</th>
        <th>주민등록등본</th>
        <th>가족관계증명서</th>
        <th>출생신고서</th>
        <th>사망신고서</th>
        <th>발급목록</th>
        <th>삭재</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="resident" items="${residnetList}">
        <tr>
            <td>${resident.name}</td>
            <td>${resident.name}</td>
            <td>${resident.gender}</td>
            <td>${resident.age}</td>
            <td>
                <c:url var="view_link" value="/student/view.do" scope="request">
                    <c:param name="id" value="${item.id}" />
                </c:url>
                <a href="${view_link}">조회</a>
            </td>
            <td>${resident.age}</td>
            <td>${resident.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
