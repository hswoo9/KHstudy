$(document).ready(() => {
  //1. 태그 선택자
  $("h5").css("color", "red");
  $("h5,p").css("background-color", "yellow");

  // 2. 아이디 선택자
  // 1) 자바스크립트
  document.getElementById("id1").style.color = "red";

  // 2) 제이쿼리
  $("#id2").css("color", "hotpink");

  // 3. 클래스 선택자
  // 1) 자바스크립트
  // let items = document.getElementsByClassName('item');

  // for(let i = 0; i < items.length; i++) {
  //   items[i].style.color = "orange"
  //   items[i].style.backgroundColor = 'yellow'
  // }

  // 2) 제이쿼리
  $(".item").css({ color: "red", backgroundColor: "green" });
});
