<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="ko">
<head>
	<!-- Materialize CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Sample Page</title>
</head>
<body class="grey lighten-5">
	<!-- 상단 Navigator -->
	<nav>
		<div class="nav-wrapper blue-grey darken-2">
			<a href="/biz/todo/selectTodoList.do" class="brand-logo" style="padding-left:10px;">Samba's TODO</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li>
					<a href="https://materializecss.com/">Materialize</a>
				</li>
				<li>
					<a href="https://bit.ly/wavus-class">Class</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<!-- 메뉴가 추가될 영역 -->
		<aside class="col s2"></aside>
		<!-- 주 내용이 들어갈 영역 -->
		<main class="col s9">
			<!-- 메뉴이름 -->
			<header class="row">
				<h3>${title}</h3>
				<div class="divider"></div>
			</header>
			<div class="row">
				<div class="col s10"></div>
				<div class="col s2">
					<a class="waves-effect waves-light btn-small right" href="/biz/todo/insertTodoVw.do">
						<i class="material-icons left">add</i>등록
					</a>
				</div>
			</div>
			<article class="row">
				<div class="collection">
				<c:forEach var="todo" items="${todoList}" varStatus="status">
					<a href="javascript:fnMove2DetailPage('${todo.todoId}')" class="collection-item">${todo.todoTitle}
					<c:choose>
						<c:when test="${todo.todoDone=='Y'}">
							<span class="new badge red" data-badge-caption="DONE 🥇 "></span>
						</c:when>
						<c:when test="${todo.todoDone=='N'}">
							<span class="new badge blue" data-badge-caption="TODO 🏃"></span>
						</c:when>
					</c:choose>
					</a>
				</c:forEach>
				</div>
			</article>
		</main>
		<div class="col s1"></div>
	</div>
</body>
<script>
var fnMove2DetailPage = function(todoId) {
	location.href = '/biz/todo/selectTodoVw.do?todoId=' + todoId
}
</script>
</html>