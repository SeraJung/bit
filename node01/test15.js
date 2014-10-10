/*
GET 요청과 POST 요청 구분하기
- request.method 프로퍼티의 값을 확인하라!
- 
 */
var http = require('http');
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {;
 //오직 pathname이/calc일때만 실행하게 한다.
	var obj = url.parse(req.url,true);
	
	if(obj.pathname!='/calc'){
		res.end();
		return;
	}
	
	if (req.method == 'GET') { 
		console.log('get요청-----------------------');
		//url정보를 분석하자.=>특히 query string은 분해해서 객체로 만들어라
		//query string이란 
		//       => URL에서 ?다음으로 오는 데이터를 쿼리스트링이라고 한다.		
		console.log("쿼리 스트링을 객체로 변환:",obj.query);
		//쿼리객체에서 요청값을 꺼낸다.
		//자료는무조건 문자열이다.. 그렇지만 v1와 v2는 숫자로 바꿔야 되기 때문에
		//parseInt(값,진수)를 사용한다.
		var v1=parseInt(obj.query.v1,10);
		var v2=parseInt(obj.query.v2,10);
		var op=obj.query.op;		
		var result= compute(v1,op,v2);

		displayResult(res , v1+' '+op+' '+v2+' = '+result);
	} else {
		//클라이언트가 보낼 데이터를 저장할 임시 변수를 준비한다.
		var massageBody='';
		
		//클라이언트가 보낸 데이터를 읽을 때 마다 호출될 함수를 등록한다.
		req.on('data',function(chunk){
			
			massageBody += chunk;//읽은 데이터를 messageBody에 누적함
		});
		// 클라이언트로 부터 보낸 데이터를 모두 읽었을 대 호출될 함수 등록
		req.on('end',function(){
			//1.읽은 데이터를 분해하여 객체로 만든다.
			//잠깐!!
			var params=qs.parse(messageBody);
			var v1=parseInt(params.v1);
			var v2=parseInt(params.v2);
			var op=params.op;
			var result= compute(v1,op,v2);
			displayResult(res , v1+' '+op+' '+v2+' = '+result);
			
			
		});
		
		console.log('post요청');
	}
	
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

function displayResult(res,content){
	res.writeHead('200','OK',{
		'content-Type': 'text/html; charset=UTF-8'
	});
	res.write('<html><head><title>계산</title></head>');
	res.write('body');
	res.write(content);
	res.write(v1+''+op+''+v2+' = '+result);
	res.write('</body></html>');
	res.end();
}
