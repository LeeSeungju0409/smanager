/**
 * array1.js
 */

// 수정 버튼에 클릭이벤트.
document.getElementById('modBtn').addEventListener('click', function(e){

	// 화면상에 있는 tr을 대상으로 변경을 해야하니까....
	document.querySelectorAll('#list tr').forEach(function(tr){
	//tr의 첫번째 자식요소의 innerHTML : 이름. 비교 fname의 value 같을때
	//faddress, height의 value를 tr의 두번째, 세번째 자식요소의 innerHTML에 대입.
	if(tr.children[0].innerHTML == document.querySelector('#fname').value){
		tr.children[1].innerHTML == document.querySelector('#faddress').value;
		tr.children[2].innerHTML == document.querySelector('#height').value;
	  }	
	});
	
});


// 등록 	버튼에 클릭 이벤트 추가.
document.getElementById('addBtn').addEventListener('click', function(e){
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let height = document.getElementById('height').value;
	
	if(!name || !address || !height){
		alert('값을 입력하세요.');
		return;
	}
	
	
	let friend = {name, address, height}
	
	console.log(name);
	// tr만드는 부분.
	let tr = makeTr(friend);
	list.appendChild(tr);
	
	alert('OK');
	
	fname.value = '';
	faddress.value = '';
	height.value = '';
})

const friends = [
	{ name: "홍길동", address: "대구 100번지", height: 170 },
	{ name: "김민규", address: "대전 200번지", height: 175 },
	{ name: "이성윤", address: "인천 300번지", height: 180 }
]

makeList();
function makeList() {
	// <tr><td>값1</td><td>값2</td><td>값3</td><td><button>삭제</button></td></tr>
	friends.forEach(function(friend) {
		let tr = makeTr(friend);
	document.getElementById('list').appendChild(tr);
	});	
}

// friend => tr생성.
function makeTr(friend = {name:'Hong', address: 'Seoul', height: 170}){
		
		function detailCallback(e){
			//let tr = e.target.parentElement;
			document.getElementById('fname').value=tr.children[0].innerHTML;
			document.getElementById('faddress').value=tr.children[1].innerHTML;
			document.getElementById('height').value=tr.children[2].innerHTML;
			
		} // end of detailCallback.
		
		// tr 만드는 부분
		let tr = document.createElement('tr');
		tr.addEventListener('click', detailCallback);
		// tr.addEventListener('mouseover', detailCallback);
		
		for (let prop in friend) {
			let td = document.createElement('td');
			td.innerHTML = friend[prop];
			tr.appendChild(td);
		}

	// 삭제버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger'); // <button class="btn btn-danger"
	btn.addEventListener('click', function(e){
	  console.log(e);
	  e.target.parentElement.parentElement.remove();
	})
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	// 체크박스 완성된 html은 --> <td><input type="checkbox"></td>의 상위요소 tr에 붙이기.
	td = document.createElement('td');
	let inp = document.createElement('input');
	inp.setAttribute('type', 'checkbox');
	td.appendChild(inp);
	tr.appendChild(td);

	return tr;
	// end of makeTr.
}