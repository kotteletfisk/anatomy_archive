<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to Anatomy Archive!
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <style>
            h1, h5
            {
                text-align: center;
            }
        </style>

        <h3 class="m-5">
            This website is for those who need inspiration in the gym, and/or who are curious
            about their muscular anatomy
        </h3>

        <%--TODO: Either remove, or make into a quick search--%>
        <h5 class="ml-5">Search exercises by musclename:</h5>
        <form action="searchmuscle" class="d-flex m-3">
            <input class="form-control me-2" type="search" name="text" placeholder="Search" aria-label="Search">
            <br>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

    </jsp:body>

</t:pagetemplate>