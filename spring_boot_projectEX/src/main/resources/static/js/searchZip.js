/**
 * 카카오맵 제공 우편번호 검색 js api 활용 주소 검색 기능
 */

$(document).ready(function(){
	$('#searchZipBtn').on('click',function(){
		new daum.Postcode(//완료버튼 클릭시 진행할 내용(콜백함수)을 파라미터로 전달해야 함
			{
				oncomplete:function(data){ //data에 선택된 우편번호 정보가 전달됨
					let address1="";
					//도로명 주소인 경우
					if(data.userSelectedType=='R'){
						address1=data.roadAddress+"("+data.bname+data.buildingName+")" ;
					}else{//지번 주소인 경우
						address1=data.jibunAddress
					}
					
					document.getElementById('memZipcode').value=data.zonecode;
					document.getElementById('memAddress1').value=address1;
					
					let address2 = document.getElementById('memAddress2');
					address2.value="";
					address2.focus();					
				}				
			}			
		).open();//다음 제공 우편번호 객체를 구성하고 검색창 열기		
	});	
});