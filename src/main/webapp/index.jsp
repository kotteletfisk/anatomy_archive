<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Search exercises by muscle names:
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <form class="d-flex m-5">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <br>
            <button class="btn btn-primary" type="submit">Search</button>
        </form>

    </jsp:body>

</t:pagetemplate>