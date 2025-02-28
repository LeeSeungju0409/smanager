/**
 * json2.js
 */
document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();


 let json = `[{"id":1,"first_name":"Naoma","last_name":"Pregal","email":"npregal0@woothemes.com","gender":"Female","salary":7230},
{"id":2,"first_name":"Craggy","last_name":"Cheke","email":"ccheke1@last.fm","gender":"Male","salary":8676},
{"id":3,"first_name":"Raimondo","last_name":"Heller","email":"rheller2@altervista.org","gender":"Male","salary":1887},
{"id":4,"first_name":"Roze","last_name":"Royden","email":"rroyden3@jiathis.com","gender":"Female","salary":7303},
{"id":5,"first_name":"Ashly","last_name":"Emblin","email":"aemblin4@yellowbook.com","gender":"Genderqueer","salary":7881},
{"id":6,"first_name":"Ad","last_name":"Conyers","email":"aconyers5@bbc.co.uk","gender":"Male","salary":8742},
{"id":7,"first_name":"Godart","last_name":"Brosetti","email":"gbrosetti6@ning.com","gender":"Male","salary":8408},
{"id":8,"first_name":"Virgie","last_name":"Assard","email":"vassard7@foxnews.com","gender":"Male","salary":6711},
{"id":9,"first_name":"Mair","last_name":"De Lasci","email":"mdelasci8@nps.gov","gender":"Female","salary":3674},
{"id":10,"first_name":"Carroll","last_name":"Irnys","email":"cirnys9@columbia.edu","gender":"Male","salary":3567},
{"id":11,"first_name":"Benoit","last_name":"Ivantyev","email":"bivantyeva@amazonaws.com","gender":"Male","salary":5782},
{"id":12,"first_name":"Lebbie","last_name":"Oliva","email":"lolivab@xinhuanet.com","gender":"Female","salary":6000},
{"id":13,"first_name":"Daryle","last_name":"Dayly","email":"ddaylyc@washington.edu","gender":"Male","salary":2722},
{"id":14,"first_name":"Deborah","last_name":"Wrotchford","email":"dwrotchfordd@reverbnation.com","gender":"Female","salary":6704},
{"id":15,"first_name":"Corney","last_name":"Jankin","email":"cjankine@multiply.com","gender":"Male","salary":2522},
{"id":16,"first_name":"Ara","last_name":"Ramble","email":"aramblef@state.tx.us","gender":"Male","salary":7230},
{"id":17,"first_name":"Linet","last_name":"Skillington","email":"lskillingtong@ifeng.com","gender":"Female","salary":9978},
{"id":18,"first_name":"Arleen","last_name":"Leggatt","email":"aleggatth@livejournal.com","gender":"Female","salary":6399},
{"id":19,"first_name":"Fairlie","last_name":"Tresise","email":"ftresisei@cargocollective.com","gender":"Male","salary":9117},
{"id":20,"first_name":"Cass","last_name":"Corinton","email":"ccorintonj@1688.com","gender":"Male","salary":2174}]`

let employees = JSON.parse(json);
console.log(employees);

document.querySelector('#searchGender').addEventListener('change', function(e){
	initList();
})

function initList(){
let target = document.getElementById('empList');
target.innerHTML = '';
let selValue = document.querySelector('#searchGender').value;
employees.forEach(emp => {
	if(selValue || emp.gender == selValue){
		document.querySelector('#searchGender')		
	target.appendChild(makeRow(emp));
	}
	});
}
initList();

// 사원정보 => row 생성.
function makeRow(emp = {}){
	let fields = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
	})
	return(tr);
}
