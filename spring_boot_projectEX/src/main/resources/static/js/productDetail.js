/**
 * productDeatai.js 사용자가 설정한 수량에 대한 구매예정금액 표시
 */
let qty = 1;
window.onload=function(){	
	let plusBtn = document.getElementById('plusBtn');
	let minusBtn = document.getElementById('minusBtn');
	
	plusBtn.addEventListener('click',()=>{
		qtyChange(1);
	});
	minusBtn.addEventListener('click',()=>{
		qtyChange(-1);
	});	
}

//주문 수량 변경하는 함수
function qtyChange(num){
	qty = qty+num;
	if(qty < 1) qty=1;
	//주문액 계산하는 함수 호출
	calcAmount();
}

//주문 수량 변경될 때 주문액 계산 및 내용 태그에 출력
function calcAmount(){
	let cartQty = document.getElementById('cartQty');
	let amount = document.getElementById('amount');
	//<span id="price" data-price="149000">
	let price = document.getElementById('price').dataset.price;
	
	let total = qty * price;
	
	//결과값 반영
	cartQty.value=qty;
	amount.innerHTML=total.toLocaleString();//천단위 구분	
}













