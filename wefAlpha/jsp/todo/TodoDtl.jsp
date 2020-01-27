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
				<h3>TODO Detail</h3>
				<div class="divider"></div>
			</header>
			<article class="row">
				<table class="hightlight">
					<colgroup>
						<col width="20%">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<!-- 제목 -->
							<th><spring:message code='bizTodo.todoList.todoTitle'/></th>
							<td>
								${todo.todoTitle}
							</td>
						</tr>
						<tr>
							<!-- 상태 -->
							<th><spring:message code='bizTodo.todoList.todoDone'/></th>
							<c:choose>
								<c:when test="${todo.todoDone=='Y'}">
									<td>
										DONE 🥇
									</td>
								</c:when>
								<c:when test="${todo.todoDone=='N'}">
									<td>
										TODO 🏃
									</td>
								</c:when>
							</c:choose>
						</tr>
						<tr>
							<!-- 분류 -->
							<th><spring:message code='bizTodo.todoList.todoCategory'/></th>
							<c:choose>
								<c:when test="${todo.todoCategory=='0001'}">
									<td>
										Javascript
									</td>
								</c:when>
								<c:when test="${todo.todoCategory=='0002'}">
									<td>
										Network
									</td>
								</c:when>
								<c:when test="${todo.todoCategory=='0003'}">
									<td>
										Spring
									</td>
								</c:when>
							</c:choose>
						</tr>
						<tr>
							<!-- 등록자 -->
							<th><spring:message code='bizTodo.todoList.todoRegister'/></th>
							<td>
								${todo.todoRegister}
							</td>
						</tr>
						<tr>
							<!-- 내용 -->
							<th><spring:message code='bizTodo.todoList.todoDesc'/></th>
							<td>
								${todo.todoDesc}
							</td>
						</tr>
					</tbody>
				</table>
			</article>
			<div class="row">
				<div class="col s2">
					<a class="waves-effect waves-light btn-small blue-grey left" href="/biz/todo/selectTodoList.do">
						<i class="material-icons left">dehaze</i>목록
					</a>
				</div>
				<div class="col s6"></div>
				<div class="col s2">
					<a class="waves-effect waves-light btn-small red right" href="javascript:fnDeleteTodo('${todo.todoId}')">
						<i class="material-icons left">delete</i>삭제
					</a>
				</div>
				<div class="col s2">
					<a class="waves-effect waves-light btn-small right" href="#!">
						<i class="material-icons left">sentiment_very_satisfied</i>Done
					</a>
				</div>
			</div>
		</main>
		<div class="col s1"></div>
	</div>
</body>
<script>
var fnDeleteTodo = function(todoId) {
	
	if(window.confirm("삭제하시겠습니까?")) {
		location.href = '/biz/todo/deleteTodo.do?todoId=' + todoId
	}
	
}
</script>
</html>