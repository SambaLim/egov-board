<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
	<!-- Compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Compiled and minified JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<title>
	<c:out value="${title}"/>
</title>
</head>
<body>
	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">
				<c:out value="${hello}"/>
			</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
			  <li><a href="http://wavus.co.kr">WAVUS</a></li>
			  <li><a href="http://bit.ly/wavus-class">Class</a></li>
			  <li><a href="http://dev.wavus.co.kr:12000">Dev</a></li>
			</ul>
		</div>
	</nav>
	<div class="collection">
	<c:forEach var="board" items="${boardList}" varStatus="status">
		<a href="#!" class="collection-item">${board.title}
			<span class="new badge"></span>
		</a>
	</c:forEach>
    </div>
	<ul class="pagination center-align">
		<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
		<li class="active"><a href="#!">1</a></li>
		<li class="waves-effect"><a href="#!">2</a></li>
		<li class="waves-effect"><a href="#!">3</a></li>
		<li class="waves-effect"><a href="#!">4</a></li>
		<li class="waves-effect"><a href="#!">5</a></li>
		<li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
	</ul>
</body>
</html>