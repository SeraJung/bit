"use strict"; 

// 목표: 리팩토링 => 반복되는 코드를 함수로 추출하여 정리한다.
// extract method => changeState() 생성 
// 엘리먼트 찾는 코드 => 간단한 함수로 정의 => $()



function bit(value) {
	if (value.charAt(0) == '#') { // 아이디일 경우,
	  return document.getElementById(value.substring(1));
	} else if (value.charAt(0) == '<') { // 태그일 경우,
	  return document.createElement(value.replace(/<|>/g, ''));	
	}
}

var $ = bit;
//함수도 객체이다. 그래서 다른 저장소로 사용 가능하다.

bit.toYYYYMMDD=function(date) {
	return date.getFullYear() + '-' +
	  (date.getMonth() + 1) + '-' +
	  date.getDate();
}