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
                            <button class="btn btn-success" name="mschoice" value="${muscleGroup.muscleGroupID}">
                                    ${muscleGroup.muscleGroupName}
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

        <c:if test="${requestScope.muscleList != null}">
            <table class="table">
                <c:forEach var="muscle" items="${requestScope.muscleList}">
                    <tr>
                        <td>
                                ${muscle.muscleName}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </jsp:body>

</t:pagetemplate>