
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <title>emailDB</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
        <h1>Registered Users</h1>
    <body>

    <sql:query var="products" dataSource="${result}">
    <c:forEach var="email" items="${emailList}">
        <p>${email.id} ${email.firstname} ${email.lastname} ${email.emailAddress}</p>
    </c:forEach>
        <form method="POST" action="emailDBServlet">
            <h1>Please Register your email</h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" /></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td>Email Address: </td><td><input type="text" name="emailAddress" /></td></tr>
                <tr><td><input type="submit" value="Submit" name="action"/></td></tr>
            </table>
        </form>
        <form method="POST" action="emailDBServlet">
            <h1>Search an email Record by Last Name</h1>
            <table>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td><input type="submit" value="Search" name="action"/></td></tr>
            </table>
        </form>
        <form method="POST" action="emailDBServlet">
            <h1>Show All email Records</h1>
            <table>
                <tr><td><input type="submit" value="Show All" name="action" /></td></tr>
            </table>
        </form>
        <form method="POST" action="emailDBServlet">
            <h1>Edit an email Record</h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" /></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" /></td></tr>
                <tr><td>Email Address: </td><td><input type="text" name="emailAddress" /></td></tr>
                <tr><td><input type="submit" value="Edit" name="action"/></td></tr>
                <tr><td>Response from Server: ${message1}</td></tr>
            </table>
        </form>
        <form method="POST" action="emailDBServlet">
            <h1>Delete an email Record by ID</h1>
            <table>
                <tr><td>ID: </td><td><input type="text" name="emailID" /></td></tr>
                <tr><td><input type="submit" value="Delete" name="action" /></td></tr>
                <tr><td>Response from Server: ${message2}</td></tr>
            </table>
        </form>
        <form method="POST" action="emailDBServlet">
            <h1>Show Number of email Records in the Database</h1>
            <table>
                <tr><td><input type="submit" value="Total Records" name="action" /></td></tr>
                <tr><td>Total number of records is: ${message3}</td></tr>
            </table>
        </form>
    </body>
