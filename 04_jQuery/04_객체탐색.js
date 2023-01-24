$(document).ready(() => {
  // 1. Filtering 메소드
  // 선택된 요소들 중 첫 번째 요소를 가져와서 스타일 변경
  // $('h4').first().css('font-size', '2em');
  //   $("h4:first").css("font-size", "2em");
  $("h4").filter(":first").css("font-size", "2em");

  // 선택된 요소들 중 마지막 요소를 가져와서 스타일 변경
  // $('h4').last().css('font-size', '2em');
  //   $("h4:last").css("font-size", "2em");
  $("h4").filter(":last").css("font-size", "2em");

  // 선택된 요소들 중 다섯번째 요소를 가져와서 텍스트 변경
  //   $('h4').eq(4).text('eq()에 의해서 선택되었습니다.')
  //   $("h4:eq(4)").text("eq()에 의해서 선택되었습니다.");
  $("h4").filter(":eq(4)").text("eq()에 의해서 선택되었습니다.");

  // 선택된 요소들 중 홀수 인덱스에 요소들을 가져와서 스타일 변경
  //   $('.test').odd().css({'color': 'white', 'background-color': 'tomato'})
  // $('.test:odd').css({'color': 'white', 'background-color': 'tomato'})
  $(".test")
    .filter(":odd")
    .css({ color: "white", "background-color": "tomato" });

  // 선택된 요소들 중 짝수 인덱스에 요소들을 가져와서 스타일 변경
  // $('.test').even().css({'color': 'white', 'background-color': 'yellowgreen'})
  // $('.test:even').css({'color': 'white', 'background-color': 'yellowgreen'})
  $(".test")
    .filter(":even")
    .css({ color: "white", "background-color": "yellowgreen" });

  // 선택된 요소들 중 특정 요소가 아닌 요소들을 선택해서 스타일 변경
  // $('h4').not('.test').css({'color': 'white', 'background-color': 'hotpink'});
  // $('h4:not(.test)').css({'color': 'green', 'background-color': 'hotpink'});
  $("h4")
    .filter(":not(.test)")
    .css({ color: "white", "background-color": "hotpink" });

  // 선택된 요소들 중 특정 요소가 존재하는지 확인
  console.log($("h4").is(".test"));
  console.log($("h4").is(".test1"));

  // 2. Ancestors 메소드
  // span 요소의 부모 요소에 스타일 변경
  //   $("span").parent().css({ border: "2px solid", color: "red" });

  //   // li 요소의 모든 상위 요소에 스타일 변경
  //   // $('li').parents().css({color: 'blue'});

  //   //li 요소의 모든 요소들 중 div만 스타일 변경
  //   $("li").parents("div").css({ color: "blue" });

  //   // span 요소부터 div 요소 이전까지 상위 요소의 스타일 변경
  //   $("span").parentsUntil("div").css("background-color", "skyblue");

  // 3. Descendants 메소드
  let style1 = { border: "2px solid", color: "red" };
  let style2 = { border: "2px solid", color: "blue" };
  let style3 = { border: "2px solid", color: "green" };
  let style4 = { border: "2px solid", color: "yellow" };
  let style5 = { border: "2px solid", color: "purple" };

  //   // 클래스 속성값이 wrap인 요소의 자식 요소들에 스타일 적용
  //   $(".wrap").children().css(style1);
  //   // 클래스 속성값이 wrap인 요소의 자식의 자식 요소들에 스타일 적용
  //   $(".wrap").children().children().css(style2);
  //   // 클래스 속성값이 wrap인 요소의 자식의 자식 요소 중에 ul 태그(요소)의 스타일 적용
  //   $(".wrap").children().children("ul").css(style3);
  //   // 클래스 속성값이 wrap인 요소의 자식의 자식 자식 요소 중에 li 태그(요소)의 스타일 적용
  //   $(".wrap").children().children().children("li").css(style4);
  //   //   클래스 속성값이 wrap인 요소의 모든 하위 요소 중 span 태그(요소)의 스타일 적용
  //   $(".wrap").find("span").css(style5);

  // 4. Sideways 메소드
  // h2 요소의 모든 형제 요소들에 스타일 적용
  $(".wrap>h2").siblings().css(style1);
  // h2 요소의 형제 요소 중 p 요소에 스타일 적용
  $(".wrap>h2").siblings("p").css(style2);
  // h2 요소의 다음 형제 요소에 스타일 적용
  $(".wrap>h2").next().css(style3);
  // h2 요소의 다음에 오는 모든 형제 요소에 스타일 적용
  $(".wrap>h2").nextAll().css("background-color", "pink");
  $(".wrap>h2").nextUntil().css("font-size", "3rem");
  // h2 요소 이후부터 p 요소 이전에 모든 형제 요소에 스타일 적용
  $(".wrap>h2").nextUntil("p").css("border", "dashed");
  // h2 요소의 이전 형제 요소에 스타일 적용
  $(".wrap>h2").prev().css(style5);
  // h2 요소의 이전에 잇는 모든 형제 요소에 스타일 적용
  $(".wrap>h2").prevAll().css("background-color", "tomato");
  $(".wrap>h2").prevUntil().css("font-size", "3rem");
  // h2 요소 이전부터 p 요소 이후까지의 모든 형제 요소에 스타일 적용
  $(".wrap>h2").prevUntil("p").css("border", "dashed");
});
