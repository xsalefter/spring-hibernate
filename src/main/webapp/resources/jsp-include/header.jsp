<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf-tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf-form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Welcome to Spring-Hibernate Project</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/global.css' />" type="text/css"></link>
    <script type="text/javascript" src="<c:url value='/resources/js/global.js' />"></script>
</head>

<body>
    <h1>Spring-Hibernate Example Application</h1>
    <span>
        <a href="<c:url value='/index.html' />">Home</a> &nbsp;
        <a href="<c:url value='/supplier/index.html' />">Supplier</a> &nbsp;
        <a href="<c:url value='/good-reception/index.html' />">Good Reception</a> &nbsp;
        <a href="<c:url value='/item-reception/index.html' />">Item Reception</a> &nbsp;
        <a href="<c:url value='/item/index.html' />">Item</a> &nbsp;
    </span>