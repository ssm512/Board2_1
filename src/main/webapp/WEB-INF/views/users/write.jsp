<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User 추가</title>
</head>
<body>
	<main>
	<form action="/Users/Write" method="post">
		<table>
			<tr>
				<td><span class="red">*</span>사용자 아이디</td>
				<td>
				<input type="text" name="userid"/>
				<input type="button" id="dupCheck1" value="중복확인(새창)" />
				<input type="button" id="dupCheck2" value="중복확인(Ajax)" />
				</td>
			</tr>
			<tr>
				<td><span class="red">*</span>사용자 password</td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<td><span class="red">*</span>사용자 password 확인</td>
				<td><input type="password" id="password2"/></td>
			</tr>
			<tr>
				<td><span class="red">*</span>사용자 이름</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>사용자 이메일</td>
				<td><input type="email" name="email"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="추가" />
					<input type="button" value="목록"
					onclick="window.location.href='/Users/List'" />
				</td>
			</tr>
		</table>
	</form>
	</main>
	<!-- Javascript 코딩 : client validation -->
	<script>
	/* 아이디 중복 체크 여부 전역변수 */
	 var	idDupChecked		=	false;
	
	/* 필요한것들 미리 찾고 */
	const	formEl		=	document.querySelector('form');
	const	useridEl	=	document.querySelector('[name="userid"]');
	const	passwordEl	=	document.querySelector('#password');
	const	password2El	=	document.querySelector('#password2');
	const	usernameEl	=	document.querySelector('[name="username"]');
	
	// 입력항목 체크
	formEl.addEventListener('submit', function (e) {
		// 아이디값 체크
		if (useridEl.value.trim() == '') {
			alert('아이디를 입력하세요')
			useridEl.focus();
			e.preventDefault() // 이벤트취소
			e.stopPropagation() // 이벤트 버블링 취소
			return;
		}	
		// 아이디 중복 체크 여부 확인
		if (!idDupChecked) {
			alert('아이디 중복확인 필요')
			e.preventDefault()
			e.stopPropagation()
			return;
		}
		// 비밀번호값 체크
		if (passwordEl.value.trim() == '') {
			alert('암호를 입력하세요')
			passwordEl.focus()
			e.preventDefault()
			e.stopPropagation()
			return;
		}
		// 비밀번호2값 체크
		if (password2El.value.trim() == '') {
			alert('비밀번호 확인을 입력하세요')
			password2El.focus()
			e.preventDefault() //이벤트취소
			e.stopPropagation() // 이벤트 버블링 취소
			return;
		}
		// 이름값 체크
		if (usernameEl.value.trim() == '') {
			alert('사용자 이름을 입력하세요')
			usernameEl.focus()
			e.preventDefault() //이벤트취소
			e.stopPropagation() // 이벤트 버블링 취소
			return;
		}
	})
	</script>
	
	<script>
	// 아이디 중복 확인1(새 창 열기)
	// ajax 나오기 전 기법
	const btnDup1El	=	document.querySelector('#dupCheck1')
	btnDup1El.addEventListener('click', function () {
		let url	=	'/Users/DupCheckWindow';
		let	target	=	'dupcheck';
		let feature	=	'left=600, top=200, width=400, height=300';
		window.open(url, target, feature)
	})
	</script>
	
	<script>
	// 아이디 중복 확인2(Ajax)
	const btnDup2El		=	document.querySelector('#dupCheck2')
	btnDup2El.addEventListener('click', function () {
		if(useridEl.value.trum() == '') {
			alert('아이디를 입력하세요')
			useridEl.focus()
			return;
		}
		let url	=	"/Users/lIdDupCheck2?user=" + useridEl.value;
		fetch(url)
			.then(response => response.json()) // 넘겨 받은 것 json으로 변환
			.then(data => {
				console.log(data.userid)
				if(data.userid !=null) {
					alert('사용불가능')
					idDupChecked = false
				}
				else {
					alert('사용가능')
					idDupChecked = true
				}
			})
	})
	
	// userid의 value가 바뀌면 idDupChecked = false
	// change가 아닌 key press로 해 놓았으면, 아이디에 다른곳에서 값을 
	// 붙여넣기 하면 못 알아차림 <- change로 해야하는 이유
	useridEl.addEventListener('change', function () {
		idDupChecked = false;
	})
	</script>
</body>
</html>





















































