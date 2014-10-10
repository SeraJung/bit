
/*
GET 요청과 POST 요청 구분하기
- request.method 프로퍼티의 값을 확인하라!
- 
 */
var http = require('http');
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {;
	
	if (req.method == 'GET') { 
		console.log('get요청-----------------------');
		//url정보를 분석하자.=>특히 query string은 분해해서 객체로 만들어라
		//query string이란 
		//       => URL에서 ?다음으로 오는 데이터를 쿼리스트링이라고 한다.		
		var obj = url.parse(req.url,true);
		console.log("쿼리 스트링을 객체로 변환:",obj.query);
		//쿼리객체에서 요청값을 꺼낸다.
		//자료는무조건 문자열이다.. 그렇지만 v1와 v2는 숫자로 바꿔야 되기 때문에
		//parseInt(값,진수)를 사용한다.
		var v1=parseInt(obj.query.v1,10);
		var v2=parseInt(obj.query.v2,10);
		var op=obj.query.op;
		
		var result= compute(v1,op,v2);

		
		console.log(v1,op,v2,'=',result);
		 
	} else {
		console.log('post요청');
	}
	res.end();
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

function compute(v1,op,v2){
	switch(op){
	case 'plus': return v1+v2; 
	case 'minus': return v1-v2; 
	case 'multiple': return v1*v2; 
	case 'divide': return v1/v2; 
	default : console.log('해당 연산자를 지원 하지 않아요.');
	}
	return 0;
}