<%@ taglib uri="/tags/struts-bean" prefix="bean" %> 
<%@ taglib tagdir="/WEB-INF/tags/toolbar" prefix="toolbar" %>
<%@ taglib tagdir="/WEB-INF/tags/toolbar/rapidFilters" prefix="rapidFilters" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %> 
<%@ taglib tagdir="/WEB-INF/tags/pragmatags" prefix="pragmatags" %>

<h3>
	<bean:message bundle="titles" key="app.title.ventanillaPermanente"/>
</h3>	
<html:form action="/VentanillaPermanenteInventarioFiltrar">	
	
	<table class="filtros">
		<tr>
			<td>
				<!-- Instrumento -->
				<rapidFilters:textFilter property="identificador" title="app.label.identificador" filterType="filter.type.string.contains" classNameType="java.lang.String"/>
			</td>
			
			<td>
				<rapidFilters:comboFilter property="codigoEstado" 
										  title="app.label.estado" 
										  filterType="filter.type.string.equal" 
										  classNameType="java.lang.String" 
										  options="estados" 
										  labelProperty="label" 
										  valueProperty="value"/>
			</td>
			
			<td>
				<rapidFilters:applyFilters />
			</td>
			
			<td>
				<rapidFilters:clearFilters />
			</td>
		</tr>
	</table>
	<%-- TIENEN QUE IR DENTRO DEL FORM! --%>
	<pragmatags:btnAgregar action="/VentanillaPermanenteAgregar" permissions="VENTANILLAPERMANENTE-AGREGAR"/>
	<toolbar:table model="list" requestURI="/VentanillaPermanenteInventarioFiltrar.do" />	
</html:form>