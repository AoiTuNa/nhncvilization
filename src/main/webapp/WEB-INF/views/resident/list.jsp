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
    <c:forEach var="resident" items="${residents}">
        <tr>
            <td>${resident.name}</td>
            <c:if test="${certificateStatusMap[resident.residentSerialNumber].idCard}">
                <td><a href="/certificate/birth/${resident.residentSerialNumber}">주민등록등본</a></td>
            </c:if>
            <c:if test="${certificateStatusMap[resident.residentSerialNumber].familyRelationship}">
                <td><a href="/certificate/death/${resident.residentSerialNumber}">가족관계증명서</a></td>
            </c:if>
            <c:if test="${certificateStatusMap[resident.residentSerialNumber].birthCertificate}">
                <td><a href="/certificate/marriage/${resident.residentSerialNumber}">출생신고서</a></td>
            </c:if>
            <c:if test="${certificateStatusMap[resident.residentSerialNumber].deathCertificate}">
                <td><a href="/certificate/divorce/${resident.residentSerialNumber}">사망신고서</a></td>
            </c:if>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
