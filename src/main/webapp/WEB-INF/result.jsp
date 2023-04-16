<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Search results
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <style>
            h1
            {
                text-align: center;
            }
        </style>

        <table class="table table-striped">
            <th>Name</th>
            <th>Description</th>
            <th>Intensity</th>
            <th>Type</th>
            <th>Calisthenic</th>

            <c:forEach var="exercise" items="${requestScope.exerciseList}">
                <tr>
                    <td>
                        ${exercise.exerciseName}
                    </td>
                    <td>
                        ${exercise.exerciseDescription}
                    </td>
                    <td>
                        ${exercise.exerciseIntensity}
                    </td>
                    <td>
                            ${exercise.exerciseType}
                    </td>
                    <td>
                            ${exercise.exerciseCalisthenic}
                    </td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>