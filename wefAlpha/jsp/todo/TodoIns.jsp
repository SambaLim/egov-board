<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<html lang="ko">
<head>
	<!-- Materialize CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <validator:javascript formName="todoVO" staticJavascript="false" xhtml="true" cdata="false"/>
    <script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
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
				<h3>TODO Insert</h3>
				<div class="divider"></div>
			</header>
			<article class="row">
				<form:form commandName="TodoVO" method="post" class="col s12">
					<input name="todoRegister" type="hidden" value="${userId}"/>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="todoTitle" id="todoTitle" type="text" size="200"/>
							<label for="todoTitle">제목</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<div style="color:#9e9e9e; margin-bottom:8px;">상태</div>
							<form:select path="todoDone" id="todoDone" style="display: block!important;">
								<form:option value="N" label="TODO 🏃"/>
							</form:select>
						</div>
						<div class="input-field col s6">
							<div style="color:#9e9e9e; margin-bottom:8px;">분류</div>
							<form:select path="todoCategory" id="todoCategory" style="display: block!important;">
								<form:options items="${category_list}" itemValue="code" itemLabel="codeNm"/>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="todoDesc" id="todoDesc" type="text" size="600"/>
							<label for="todoDesc">내용</label>
						</div>
					</div>
				</form:form>
			</article>
			<div class="row">
				<div class="col s2">
					<a class="waves-effect waves-light btn-small blue-grey left" href="/biz/todo/selectTodoList.do">
						<i class="material-icons left">dehaze</i>목록
					</a>
				</div>
				<div class="col s6"></div>
				<div class="col s2"></div>
				<div class="col s2">
					<a class="waves-effect waves-light btn-small right" href="javascript:fnInsertTodo()">
						<i class="material-icons left">save</i>등록
					</a>
				</div>
			</div>
		</main>
		<div class="col s1"></div>
	</div>
</body>
<script>
var fn_modalAlert = function(content) {
	window.alert(content)
}

var fnInsertTodo = function() {
	
	var form = document.getElementById('TodoVO')
	form.action = "<c:url value='/biz/todo/insertTodo.do'/>"
	
	if(!validateTodoVO(form)) return
	
	if(window.confirm("등록하시겠습니까?")) {
		form.submit()
	}
	
}
</script>
</html>