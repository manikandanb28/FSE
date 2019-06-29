<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring5 MVC Hibernate Demo</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Subject Search</h1>
        <form:form action="searchSubject" method="post" modelAttribute="searchSubject">
            <table>
                <tr>
                    <td>Subtitle</td>
                    <td>
                        <form:input path="subtitle" /> <br />
                        <form:errors path="subtitle" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>

        <h1>Book Search</h1>
        <form:form action="searchBook" method="post" modelAttribute="searchBook">
            <table>
                <tr>
                    <td>Title</td>
                    <td>
                        <form:input path="title" /> <br />
                        <form:errors path="title" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>

        <h2>Subject List</h2>
        <table>
            <tr>
                <td><strong>Subtitle</strong></td>
                <td><strong>Duration In Hours</strong></td>
            </tr>
            <c:forEach items="${subjects}" var="subject">
                <tr>
                    <td>${subject.subtitle}</td>
                    <td>${subject.durationInHours}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Book List</h2>
        <table>
            <tr>
                <td><strong>Title</strong></td>
                <td><strong>Price</strong></td>
                <td><strong>Volume</strong></td>
                <td><strong>Publish Date</strong></td>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>${book.volume}</td>
                    <td>${book.publishDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>