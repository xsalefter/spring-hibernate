<%@include file="/resources/jsp-include/header.jsp" %>

    <h2>Supplier Detail</h2>

    <span style="color: #009999">${actionMessage}</span>
    
    <table>
        <tr>
            <td>Supplier Name</td><td>:</td>
            <td>${supplier.name}</td>
        </tr>

        <tr>
            <td>Description</td><td>:</td>
            <td>${supplier.description}</td>
        </tr>

        <tr>
            <td colspan="3">
                <input type="button" value="DONE" onclick="javascript:write_url('<c:url value="/supplier/index.html" />');"/> &nbsp;
                <input type="button" value="EDIT" onclick="javascript:write_url('<c:url value="/supplier/form.html?supplierId=${supplier.id}" />');"/> &nbsp;
                <input type="button" value="DELETE" onclick="javascript:write_url('<c:url value="/supplier/delete.html?supplierId=${supplier.id}" />');" />
            </td>
        </tr>
    </table>

<%@include file="/resources/jsp-include/footer.jsp" %>
