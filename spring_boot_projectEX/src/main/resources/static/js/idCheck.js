/**
 * 회원 가입 시 id 중복 체크 : idCheck.js
 * 연습문제
 * 사용 불가능한 id일 경우 id 입력란을 지우고 
 * 포커스 이동
 */

$(document).ready(function(){
	
	$("#idCheck").click(function(){
		event.preventDefault();		
		let memId = $('#memId').val();
		
		if(memId==""){
			alert("ID를 입력하세요");
		}else{
			$.ajax({
				type:"post",
				url:"/member/idCheck",
				data:{"id":memId},
				dataType:"text",
				success:function(result){
					if(result > 0){
						alert("사용할 수 없는 ID 입니다");
					}else {
						alert("사용 가능한 ID 입니다");
					}
				},
				error:function(){
					alert("실패");
				}
			});
		}
	});	
});


