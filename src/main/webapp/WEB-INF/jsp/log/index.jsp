<%@include file="/resources/jsp-include/header.jsp" %>

    <h2>Data Log for Application</h2>
    <table>
        <tr><th colspan="2">Native Query without DTO</th></tr>
        <tr>
            <th>Log Code</th>
            <th>Message</th>
        </tr>
        <c:forEach items="${logs}" var="log">
            <tr>
                <td>${log[1]}</td>
                <td>${log[2]}</td>
            </tr>
        </c:forEach>

        <tr><th colspan="2">Native Query with DTO</th></tr>
        <c:forEach items="${logsDTO}" var="log">
            <tr>
                <td>${log.code}</td>
                <td>${log.message}</td>
            </tr>
        </c:forEach>
    </table>

<%@include file="/resources/jsp-include/footer.jsp" %>

