<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="lib.Session" %>

<jsp:useBean id="html" class="lib.Html" />
<jsp:useBean id="cook" class="lib.Cook" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tags-taglib.tld" prefix="tag" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>RU</title>
        
        <style>
            * {
                font-family: 'Courier New';
            }
        </style>
    </head>

    <body>

        <%@include file="/views/@elements/info.jsp" %>