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

        <div class="container">
            <div class="row">
                <div class="col-6">
                    <form action="choosemusclegroup" class="m-3">
                        <table class="table">
                            <c:forEach var="muscleGroup" items="${requestScope.muscleGroupList}">
                                <tr>
                                    <td>
                                        <button class="btn btn-success" name="mschoice"
                                                value="${muscleGroup.muscleGroupID}">
                                                ${muscleGroup.muscleGroupName}
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                </div>

                <div class="col-6">
                    <c:if test="${requestScope.muscleList != null}">
                        <form action="loadexercises">
                            <table class="table">
                                <c:forEach var="muscle" items="${requestScope.muscleList}">
                                    <tr>
                                        <td>
                                            <label for="${muscle.muscleID}">${muscle.muscleName}
                                                <input type="checkbox" id="${muscle.muscleID}"
                                                       value="${muscle.muscleID}"
                                                       name="checkboxChoice">
                                            </label>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td>
                                        <label for="all">All
                                            <input type="checkbox" id="all" name="checkboxChoice" value="all" checked>
                                        </label>
                                    </td>
                                </tr>
                            </table>
                            <button type="submit" class="btn btn-success" name="muscleGroupID" value="${requestScope.muscleGroupID}">
                                Update
                            </button>
                        </form>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <c:if test="${requestScope.exerciseList != null}">
                    <table>
                        <c:forEach var="exercise" items="${requestScope.exerciseList}">
                            <tr>
                                <td>
                                    ${exercise.exerciseName}
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>