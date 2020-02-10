<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<h1>All Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td>
			    <form action="/languages/${language.id}" method="post">
			    	<input type="hidden" name="_method" value="delete">
			    	<input type="submit" value="Delete">
			    </form>
			</td>
            <td>
			    <form action="/languages/${language.id}" method="post">
			    	<input type="hidden" name="_method" value="put">
			    	<input type="submit" value="Edit">
			    </form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
 