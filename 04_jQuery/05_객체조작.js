$(document).ready(() => {
  // 1. Content 설정
  // 1) html() 메소드
  $("#content2").html($("#content1").html());
  $("#content1>a").attr("href", "https:www.naver.com");
  $("#content2").find("a").prop("href", "https://www.naver.com");

  $(".content").html(function (index, content) {
    console.log(index, content);

    return `<h1>인덱스 : ${index}, 내용 : ${content}</h1>`;
  });

  //   $('.content').html('ㅋㅋㅋㅋㅋㅋㅋ')
  // 2) text() 메소드
  $("#content4").text($("#content3").text());
  //   $('#content4').text('<h3>안녕</h3>');

  $(".content2").text(function (index, content) {
    console.log(index, content);

    return `<h1>인덱스 : ${index}, 내용 : ${content}</h1>`;
  });

  //   $('.content2').text('ㅋㅋㅋㅋㅋㅋㅋㅋㅋ');
});
