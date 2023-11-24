<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../layouts/header1.jsp"%>


<section class="changepassword-banner">
	<div class="main-container">
		<div class="inner">
			<div class="title-container">
				<div class="title">비밀번호 변경</div>
				<div class="message">
					암호를 변경을 통해 아이디를 보호하세요.<br/>
				</div>
			</div>
		</div>
	</div>
</section>


	<div class="change_password">
	
	<div class="changepassword-container">
		<div class="changepassword-image">
			<img src="/resources/images/passwordlocker.png" />
		</div>
	</div>
	<div class="changepassword-text">여러분의 정보를 지켜주세요.</div>
	
	
		<form:form modelAttribute="changePassword"
			action="/security/change_password" >
			
			<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
			<input type="hidden" name="username" value="${changePassword.username }" />
			
			<div class="form-group">
				<form:label path="orgPassword">
					<i class="fa-solid fa-user"></i> 기존 비밀번호
				</form:label>
				<form:password path="orgPassword" class="form-control" />
				<form:errors path="orgPassword" cssClass="error"></form:errors>
			</div>
			<br/>
			<div class="form-group">
				<form:label path="newPassword">
					<i class="fa-solid fa-lock"></i> 변경할 비밀번호</form:label>
				<form:password path="newPassword" class="form-control" />
				<form:errors path="newPassword" cssClass="error" />
			</div>
			<br/>
			<div class="form-group">
				<form:label path="newPassword2">
					<i class="fa-solid fa-lock"></i> 변경할 비밀번호 확인</form:label>
				<form:password path="newPassword2" class="form-control" />
				<form:errors path="newPassword2" cssClass="error" />
			</div>
			<br/>
		

			<div class="button-container">
				<button type="submit" class="btn btn-primary">
					<i class="fas fa-check"> 변경</i>
				</button>
				<button type="reset" class="btn btn-warning">
					<i class="fas fa-undo"></i> 재작성
				</button>
				<a href="javascript:history.back()" class="btn btn-danger"> <i
					class="fa-solid fa-ban"></i> 변경 취소
				</a>
			</div>
		</form:form>
	</div>

<%@ include file="../layouts/footer1.jsp"%>