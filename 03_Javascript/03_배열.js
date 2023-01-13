window.onload = function () {
  // 1. 배열 선언 및 초기화
  let btn1 = document.getElementById("btn1");

  btn1.onclick = function () {
    let div1 = document.getElementById("div1");
    let array1 = [];
    let array2 = new Array();
    let array3 = new Array(3);
    let array4 = new Array("빨강", "파랑", "노랑", "초록");
    let array5 = Array.of("빨강", "파랑", "노랑", "초록");
    let array6 = ["빨강", "파랑", "노랑", "초록"];
    let array7 = ["문인수", 20, true, [1, 2, 3, 4], {}, function () {}];

    console.log(array1, array2, array3);
    console.log(array4, array5, array6);
    console.log(array7);

    array1[0] = "귤";
    array1[1] = "사과";
    array1[2] = "자몽";

    array2[0] = "벤츠";
    array2[1] = "아우디";
    array2[2] = "BWM";
    array2[3] = "벤틀리";

    div1.innerHTML = "<h4>안녕하세요.</h4>";
    div1.innerHTML += `array1 : [${array1}], length : ${array1.length}<br>`;
    div1.innerHTML += `array2 : [${array2}], length : ${array2.length}<br>`;
    div1.innerHTML += `array3 : [${array3}], length : ${array3.length}<br>`;
    div1.innerHTML += `array4 : [${array4}], length : ${array4.length}<br>`;
    div1.innerHTML += `array5 : [${array5}], length : ${array5.length}<br>`;
    div1.innerHTML += `array6 : [${array6}], length : ${array6.length}<br>`;
    div1.innerHTML += `array7 : [${array7}], length : ${array7.length}<br>`;
  };

  // 2. 배열의 메소드
  let btn2 = document.getElementById("btn2");

  btn2.addEventListener("click", function () {
    let div2 = document.getElementById("div2");

    // // 1) indexOf()
    // let array = ["귤", "사과", "자몽", "망고", "복숭아"];

    // div2.innerHTML = `array : [${array}]<br>`;
    // div2.innerHTML += `indexOf('귤') : ${array.indexOf("귤")}<br>`;
    // div2.innerHTML += `indexOf('복숭아') : ${array.indexOf("복숭아")}`;
    // div2.innerHTML += `indexOf('수박') : ${array.indexOf("수박")}`;

    // 2) concat()
    // let array1 =["귤", "사과", "자몽", "망고", "복숭아"];
    // let array2 =["샤인머스캣", "딸기", "레드향", "레몬", "수박"];

    // div2.innerHTML = `array1 : [${array1}]<br>`;
    // div2.innerHTML += `array2 : [${array2}]<br>`;
    // div2.innerHTML += `array1을 기준으로 배열을 결합 : [${array1.concat(array2)}]<br>`;
    // div2.innerHTML += `array1 : [${array1}]<br><br>`; // 원본 배열에 영향을 미치지 않는다.
    // div2.innerHTML += `array2을 기준으로 배열을 결합 : [${array2.concat(array1)}]<br>`;
    // div2.innerHTML += `array2 : [${array2}]<br><br>`; // 원본 배열에 영향을 미치지 않는다.

    //3) sort()
    let array1 = ["Apple", "Cherry", "apple", "Banana"];
    let array2 = [10, 543, 30, 450, 123, 4885];

    div2.innerHTML = `array1 : [${array1}]<br>`;
    div2.innerHTML += `array2 : [${array2}]<br>`;
    div2.innerHTML += `array1.sort() : [${array1.sort()}]<br>`;
    div2.innerHTML += `array2.sort() : [${array2.sort()}]<br>`;
    //원본 배열에 영향을 미치는 메소드 이다
    div2.innerHTML += `array1 : [${array1}]<br>`;
    div2.innerHTML += `array2 : [${array2}]<br>`;

    //array2 오름차순 정렬
    array2.sort(function (left, right) {
      return left - right;
    });
    div2.innerHTML += `array2 : [${array2}]<br>`;

    //array2 내림차순 정렬
    array2.sort(function (left, right) {
      return right - left;
    });
    div2.innerHTML += `array2 : [${array2}]<br>`;
  });
};
