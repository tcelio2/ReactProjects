<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:choose>

	<c:when test="${user.role == 'ADMIN'}">
		<ul>
			<li><a href="dashboard">Dashboard</a></li>
			<li><a href="teamLeader">Team Leader</a></li>
			<li><a href="schedule">Schedule</a></li>
			<li><a href="deliverable">Deliverable</a></li>
			<li><a href="admin">Admin</a></li>
		</ul>
	
	</c:when>
	
	<c:otherwise>
		<ul>
 			<li><a href="dashboard">Dashboard</a></li>
			<li><a href="teamLeader">Team Leader</a></li>
			<li><a href="schedule">Schedule</a></li>
			<li><a href="deliverable">Deliverable</a></li>
		</ul>
	
	</c:otherwise>	

</c:choose>

