<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!-- .modal: 배경이 아닌 모달 페이지임을 나타냄// 명시하지 않을 시 모달창까지 배경으로 인식  -->
<!-- .fade: 애니메이션으로 자연스러운 효과 -->
<!-- modalLogin -->
<div id="modalLogin" class="modal fade" role="dialog">

    <!-- .modal-dialog: 모달창의 사이즈를 결정한다 -->
    <!-- +++추가옵션 .modal-sm, .modal-lg -->
    <div class="modal-dialog">

        <!-- Modal content: 모달창에 들어갈 내용 삽입 -->
        <div class="modal-content text-center">

            <!-- .modal-header: modal창 상단바 -->
            <div class="modal-header">
                <h2 class="modal-title">로그인</h2>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            
			<form:form modelAttribute="user">
				<!-- .modal-body: modal창 본 컨텐츠를 담음. -->
				<div class="modal-body">
					<div class="input-group">
						<form:input path="user_id" class="form-control input-lg" placeholder="ID" />
						<form:errors path="user_id" class="text-danger"/>
                    </div>
                    <div class="input-group">
                    	<form:password path="user_password" class="form-control input-lg" placeholder="Password"/>
                    	<form:errors path="user_password" class="text-danger"/>
                    </div>
            	</div>
            	
            	<!-- .modal-footer: modal창 하단바 -->
            	<div class="modal-footer">
	               <div class="col-md-6">
	                	<input type="submit" value="로그인" class="btn btn-primary btn-block btn-lg" />
	                </div>
	                <div class="col-md-6">
	                	<input type="reset" value="취소" class="btn btn-danger btn-block btn-lg" />
	                </div>
            	</div>
			</form:form>
			
        </div>
    </div>
</div>