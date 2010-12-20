<%@include file="/resources/jsp-include/header.jsp" %>

    <h2>Form ${supplierId == null? 'Input' : 'Edit'} Supplier</h2>
    <sf-form:form action="${pageContext.request.contextPath}/supplier/save-action.html${supplierId == null ? '' : '?supplierId=${supplierId}'}" modelAttribute="supplier">
    <sf-form:hidden path="id" />
    <table>
        <tr>
            <td>Supplier Name</td><td>:</td>
            <td><sf-form:input path="name" /></td>
        </tr>

        <tr>
            <td>Description</td><td>:</td>
            <td><sf-form:input size="50" path="description" /></td>
        </tr>

        <tr>
            <td colspan="3">
                <input type="submit" value="${supplierId == null? 'SAVE' : 'UPDATE'}" /> &nbsp;
                <input type="button" value="DELETE" onclick="javascript:write_url('<c:url value="/supplier/delete.html?supplierId=${supplierId}" />');" ${supplierId == null ? 'disabled="disabled"' : ''} /> &nbsp;
                <input type="button" value="CANCEL" onclick="javascript:write_url('<c:url value="/supplier/index.html" />');" />
            </td>
        </tr>
    </table>
    </sf-form:form>

<%@include file="/resources/jsp-include/footer.jsp" %>
