<%@include file="/resources/jsp-include/header.jsp" %>

    <h2>Data Supplier</h2>
    <table>
        <tr>
            <th>Supplier Name</th>
            <th>Description</th>
            <th>Good Reception</th>
        </tr>
        <c:forEach items="${suppliers}" var="supplier">
            <tr>
                <td><a href="<c:url value="/supplier/form.html?supplierId=${supplier.id}" />">${supplier.name}</a></td>
                <td>${supplier.description}</td>
                <td>
                    <table>
                        <tr>
                            <th>Transaction Date</th>
                            <th>Official Amount</th>
                            <th>Administration Amount</th>
                            <th>Item Reception</th>
                        </tr>
                        <c:forEach items="${supplier.goodReceptions}" var="goodReception">
                            <tr>
                                <td>${goodReception.receptionDate}</td>
                                <td>${goodReception.officialAmount}</td>
                                <td>${goodReception.administrationAmount}</td>
                                <td>
                                    <table>
                                        <tr>
                                            <th>Item Name</th>
                                            <th>Amount</th>
                                        </tr>
                                        <c:forEach items="${goodReception.itemReceptions}" var="itemReception">
                                            <tr>
                                                <td>${itemReception.item.name}</td>
                                                <td>${itemReception.amount}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </c:forEach>
    </table>

<%@include file="/resources/jsp-include/footer.jsp" %>

