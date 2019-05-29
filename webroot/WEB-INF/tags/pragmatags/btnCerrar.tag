<%@ taglib uri="/tags/displaytag-el-12" prefix="display-el" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %> 
<%@ taglib uri="/tags/struts-logic" prefix="logic" %> 
<%@ taglib uri="/tags/struts-html" prefix="html" %> 
<%@ taglib uri="/tags/struts-html-el" prefix="html-el" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ tag body-content="empty" %>

<%@ attribute name="action" required="false"%>
<%@ attribute name="javascript" required="false"%>

<c:if test="${!empty action}">
	<!--  aceptar action   -->
	<html-el:link styleClass="textButton" action="${action}">
		<bean:message bundle="labels" key="app.label.cerrar"/>
	</html-el:link>				
</c:if>

<c:if test="${empty action && !empty javascript}">
	<!--  aceptar javascript   -->
	<html-el:link styleClass="textButton" href="#" onclick="${javascript}">
		<bean:message bundle="labels" key="app.label.cerrar"/>		
	</html-el:link>				
</c:if>

<!--  Busco en el Navigation Manager   -->
<c:if test="${empty action && empty javascript}">
	<html-el:link styleClass="textButton" href="<%=com.pragma.web.NavigationManager.getPreviousURIHref(request)%>">
		<bean:message bundle="labels" key="app.label.cerrar"/>		
	</html-el:link>				
</c:if>
