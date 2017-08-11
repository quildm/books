<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<div>
<c:forEach items="${books}" var="book">
    <div>    
    <c:out value="${book.title}"/>
    <c:out value="${book.description}"/>
    <c:out value="${book.language}"/>
    <c:out value="${book.numberOfPages}"/>
    </div>
</c:forEach>
</div>
<!-- ... -->