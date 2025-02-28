/**
 * boardService.js
 * 목록, 등록, 삭제 기능을 정의.
 */
const svc = {
	// 목록.
	replyList(param = { bno, page }, loadCallback) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyList.do?bno=' + param.bno + '&page=' + param.page);
		xhtp.send();
		xhtp.onload = loadCallback;

	},// end of replyList
	// 등록.
	addReply(param = { bno, replyer, content }, loadCallback) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'addReply.do?bno=' + param.bno + '&content=' + param.content + '&replyer=' + param.replyer);
		xhtp.send();
		xhtp.onload = loadCallback;
	},

	// 삭제.
	removeReply(rno = 1, loadCallback) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno=' + rno);// + '&content=' + param.content + '&replyer=' + param.replyer); RemoveReplyControll에서 파라미터로 값을 하나밖에 안해놨었기때문에 하나만 주는거임.
		xhtp.send();
		xhtp.onload = loadCallback;

	},

	// 댓글 갯수
	pagingCount(bno = 1, loadCallback) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'pagingCount.do?bno=' + bno);// + '&content=' + param.content + '&replyer=' + param.replyer); RemoveReplyControll에서 파라미터로 값을 하나밖에 안해놨었기때문에 하나만 주는거임.
		xhtp.send();
		xhtp.onload = loadCallback;
	}
}// end of svc.