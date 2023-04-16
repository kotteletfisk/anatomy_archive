<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Bodymap
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <style>
            * {
                text-align: center;
            }
        </style>

        <h3>Choose a musclegroup</h3>

        <form action="choosemusclegroup" class="m-3">
            <table class="table">

                <c:forEach var="muscleGroup" items="${requestScope.muscleGroupList}">
                    <tr>
                        <td>
                            <label for="${muscleGroup.muscleGroupID}">${muscleGroup.muscleGroupName}
                                <input type="radio" id="${muscleGroup.muscleGroupID}"
                                       value="${muscleGroup.muscleGroupID}" name="mschoice">
                            </label>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <button class="btn btn-lg btn-success" type="submit">Show</button>

        </form>

    </jsp:body>

</t:pagetemplate>