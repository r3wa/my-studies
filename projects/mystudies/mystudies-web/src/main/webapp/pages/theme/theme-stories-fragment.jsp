<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:forEach items="${themes}" var="theme">			
	<div class="item">				
		<div>
		    <h3 class="item-title"><a href="#">${theme.title}</a> </h3>
		</div>
			
		<div >
			<ul class="item-information">
				<li>${theme.priority}</li>
				<li> <fmt:formatDate value="${theme.creationDate}" pattern="dd/MM/yyyy"/> </li>
				<li><a href="history.html">${fn:length(theme.stories)} stories</a></li>
				<li><a href="#">${fn:length(theme.comments)} comments</a></li>
			</ul>
			<div style="clear: both;"></div>					
		</div>					    
	</div>				
</c:forEach>
