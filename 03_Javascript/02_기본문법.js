// 1. 변수
// 1) 변수 선언
// 전역 변수 선언
str1 = "전역변수";
var str2 = "var 전역변수";
let str3 = "let 전역변수"; // window.str3 조회되지 않는다.

console.log(str1);
console.log(str2);
console.log(str3);

// 전역으로 선언된 함수는 window 객체로 접근 가능 window.add(), add();
function add(a, b) {
  return a + b;
}

// document.getElementById("heading1").style.color = "green";

// 자바스크립트에서 페이지가 모두 로드되면 자동으로 실행되는 이벤트 속성이다.
window.onload = function () {
  //   document.getElementById("heading1").style.color = "green";

  var str4 = "지역변수";
  let str5 = "지역변수";
  str6 = "전역변수";

  console.log(str4);
  console.log(str5);
  console.log(str6);
};
