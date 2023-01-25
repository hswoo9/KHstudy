$(document).ready(() => {
  // 1. 이벤트 연결
  // 1) on(), off()
  // $('#div1').on('mouseenter', (event) => {
  //     console.log(event.type);

  //     $(event.target).css('background-color', 'beige');
  // });

  // $('#div1').on('mouseleave', (event) => {
  //     console.log(event.type);

  //     $(event.target).css('background-color', 'hotpink');
  // });

  // // 마우스 올리면 베이지, 떼면 핫핑크, 클릭하면 이벤트 끄기
  // $('#div1').on('mouseenter mouseleave', (event) => {
  //     console.log(event.type);

  //     if(event.type === 'mouseenter') {
  //         $(event.target).css('background-color', 'beige');
  //     } else if(event.type === 'mouseleave') {
  //         $(event.target).css('background-color', 'hotpink');
  //     };
  // });

  // $('#div1').on('click', (event) => {
  //     console.log(event.type);

  //     $(event.target)
  //         .css('background-color', 'white')
  //         .off('mouseenter mouseleave click');
  // });

  // // 마우스 올리면 베이지, 떼면 핫핑크, 클릭하면 이벤트 3개 다 합치기
  // $('#div1').on({
  //     mouseenter: (event) => {
  //         $(event.target).css('background-color', 'beige');
  //     },
  //     mouseleave: (event) => {
  //         $(event.target).css('background-color', 'hotpink');
  //     },
  //     click: (event) => {
  //         $(event.target)
  //             .css('background-color', 'white')
  //             .off('mouseenter mouseleave click');
  //     }
  // });

  // 위에꺼 한줄로해서 중괄호 없애보기
  $("#div1").on({
    mouseenter: (event) => $(event.target).css("background-color", "beige"),
    mouseleave: (event) => $(event.target).css("background-color", "hotpink"),
    click: (event) =>
      $(event.target)
        .css("background-color", "white")
        .off("mouseenter mouseleave click"),
  });

  // 2) one()
  $("#div2").one("click", () => {
    alert("버튼 클릭!!");
  });

  $("#div2").on("mouseenter mouseleave", (event) => {
    console.log(event.type);

    if (event.type === "mouseenter") {
      $(event.target).css("background-color", "beige");
    } else if (event.type === "mouseleave") {
      $(event.target).css("background-color", "hotpink");
    }
  });

  // 2. 키보드 이벤트
  // 1) keydown, keypress, keyup
  // 키보드가 눌려질 때
  $("#textarea1").keydown((event) => {
    console.log(
      `keydown > event.key: ${event.key}, event.keyCode : ${event.keyCode}`
    );
  });

  // 글자가 입력될 때(한글, 펑션키, 기능키 사용 X)
  $("#textarea1").keypress((event) => {
    console.log(
      `keypress > event.key: ${event.key}, event.keyCode : ${event.keyCode}`
    );
  });

  // 키보드가 떼어질 때
  $("#textarea1").keyup((event) => {
    console.log(
      `keyup > event.key: ${event.key}, event.keyCode : ${event.keyCode}`
    );
  });

  // 2) 동적으로 글자 수 세기
  $("#textarea2").on("keyup", (event) => {
    let target = $(event.target);
    let currentLength = target.val().length;
    let maxlength = parseInt($("#maxLength").text());

    console.log(currentLength);
    console.log(maxlength);

    if (currentLength > maxlength) {
      target.val(target.val().substr(0, maxlength));
    } else {
      $("#counter").text(currentLength);
    }

    $("#counter").text(currentLength);
  });

  // 3) 동적으로 아이디 조건 확인
  $("#userId").keyup((event) => {
    let id = $(event.target).val();
    let regExp = /^[a-z][a-z0-9]{3,11}$/;

    console.log(id);
    console.log(regExp.test(id));

    if (id === null || id === "") {
      $("#idCheck").text("");
    } else if (regExp.test(id)) {
      $("#idCheck")
        .text("사용가능한 아이디입니다.")
        .css({ color: "green", fontWeight: "bold" });
    } else {
      $("#idCheck")
        .text("사용 불가능한 아이디")
        .css({ color: "red", fontWeight: "bold" });
    }
  });

  // 3. trigger() 메소드
  $("#div3").on("click", () => {
    let counter = $("#counter2");
    let currentCount = parseInt(counter.text());

    console.log(currentCount);

    counter.text(++currentCount);
  });

  $("#btn1").click(() => {
    $("#div3").trigger("click");
  });
});
