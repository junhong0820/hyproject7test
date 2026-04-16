/**
 * 장바구니 목록 : 삭제를 위한 품목 체크 버튼 기능
 */

$(document).ready(function(){
	//[전체선택]체크박스 클릭 했을대
	$('#allCheck').on('click',function(){
		let chk = $('#allCheck').prop("checked")
		
		if(chk){
			$('.chkDelete').prop("checked",true);
		}else{
			$('.chkDelete').prop("checked",false); 
		}		
	});
	
	//개별 체크박스 해제할 경우 [전체선택]체크박스 해제
	//개별 체크박스가 모두 체크했을 경우 [전체선택]체크박스 체크
	$('.chkDelete').click(function(){
		let total = $('.chkDelete').length; //개별 체크박스의 전체 개수
		let checked = $('.chkDelete:checked').length;//개별 체크박스 중 체크된 체크박스의 개수
		
		if(total != checked){
			$("#allCheck").prop("checked",false); //해제
		}else{
			$("#allCheck").prop("checked",true); //체크
		}		
	});
	//장바구니 상품 삭제 요청(ajax)
	$('#deleteCartBtn').on('click',function(){
		//개별삭제버튼 체크 여부 확인
		let chk =$(".chkDelete").is(':checked')
		
		if(chk){//하나라도 선택한 경우
			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
			if(answer){
				let checkArr = new Array();
				$(".chkDelete:checked").each(function(){
					console.log($(this).val());
					checkArr.push($(this).val());
				});
				
				//배열 data 파라미터로해서 요청
				$.ajax({
					url:"/product/deleteCart",
					type:"post",
					data:{"delPrd": checkArr},
					success:function(result){
						if(result){
							location.href="/product/cartList";
						}
					},
					error:function(){
						alert("오류발생!");
					}					
				});
			}
		}else{//아무것도 선택하지 않은 경우
			alert("선택된 상품이 없습니다")
		}
	});
});














