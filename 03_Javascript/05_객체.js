window.onload = () => {
  // 1. 객체 생성
  let btn1 = document.getElementById("btn1");

  btn1.addEventListener("click", () => {
    let div1 = document.getElementById("div1");
    let obj1 = {};
    let obj2 = new Object();
    let product = {
      //   'pName': "아이폰 12 미니",
      //   '0': "배열 흉내",
      pName: "아이폰 12 미니",
      0: "배열 흉내",
      price: 990000,
      brand: "삼성",
      brand: "애플", // 중복 선언하게 되면 마지막에 선언된 프로퍼티로 덮어쓴다.
      spec: ["OLED", "IOS16", "8Inch", "화이트"],
    };

    let user = {
      "user name": "문인수",
      // user_age : 22
      "user-age": 22,
    };

    console.log(obj1, obj2);
    console.log(product);
    // console.log(product[0]);

    // 객체의 속성에 접근하는 방법
    div1.innerHTML = `product['속성명']으로 접근하는 방법<br>`;
    // div1.innerHTML += `product['0'] : ${product["0"]}`;
    div1.innerHTML += `product[0] : ${product[0]}<br>`;
    div1.innerHTML += `product['pName'] : ${product["pName"]}<br>`;
    div1.innerHTML += `product['price'] : ${product["price"]}<br>`;
    div1.innerHTML += `product['brand'] : ${product["brand"]}<br>`;
    div1.innerHTML += `product['spec'] : ${product["spec"][1]}<br>`;
    div1.innerHTML += `product['spec'] : ${product["spec"][3]}<br><br>`;

    div1.innerHTML = `product. 속성명으로 접근하는 방법<br>`;
    // div1.innerHTML = `product.0 : ${product.0}<br>`; 오류 발생
    div1.innerHTML += `product.pName : ${product.pName}<br>`;
    div1.innerHTML += `product.price : ${product.price}<br>`;
    div1.innerHTML += `product.beand : ${product.beand}<br>`;
    div1.innerHTML += `product.spec: ${product.spec}<br>`;
    div1.innerHTML += `product.spec[1]: ${product.spec[1]}<br>`;

    div1.innerHTML = `속성명에 공백이나 특수문자가있는 경우 대괄호를 이용해서 값을 접근해야한다<br>`;
    // div1.innerHTML += `user['user name'] : ${user.'user name']}<br>` 문법 상 오류
    div1.innerHTML += `user['user name'] : ${user["user name"]}<br>`;
    div1.innerHTML += `user['user-age'] : ${user["user-age"]}<br>`;
  });

  // 2. 메소드
  let btn2 = document.getElementById("btn2");

  btn2.addEventListener("click", () => {
    let name = "홍길동";

    let dog = {
      name: "백구",
      kind: "진돗개",
      eat: function (food) {
        // 객체 내부의 속성에 접근하기 위해서는 'this.속성명'으로 작성해야 한다.
        console.log(`${this.kind} 종류인 ${this.name}가 ${food}를 먹고 있네요`);
        // console.log(food);
        // console.log(name);
        // console.log(this.name);
      },
    };

    dog.eat("닭가슴살");
  });

  // 3. 객체의 속성 추가 및 삭제
  let btn3 = document.getElementById("btn3");

  btn3.addEventListener("click", () => {
    // 빈 객체 생성
    let student = {};

    // 객체에 속성 추가
    student.name = "홍길동";
    student.age = 30;

    // 객체에 메소드 추가
    student.whoAreYou = function () {
      let str = "";

      str = this.name + ", " + this.age;

      return str;
    };

    console.log(student);
    console.log(student.whoAreYou());

    //속성을 지우는 구문
    delete student.age;
    delete student["name"];

    console.log(student);
    console.log(student.whoAreYou());
  });

  // 4. 객체 배열
  // let btn4 = document.getElementById('btn4');

  // btn4.addEventListener('click', () => {
  //     let div2 = document.getElementById('div2');

  //     div2.innerHTML = '안녕';

  //     let student1 = {name : '인수', java : 100, oracle : 80};
  //     let student2 = {name : '홍씨', java : 170, oracle : 60};
  //     let student3 = {name : '백구', java : 100, oracle : 100};
  let student4 = { name: "누렁", java: 80, oracle: 80 };

  //     console.log(student1);
  //     console.log(student2);
  //     console.log(student3);
  //     console.log(student4);

  // 배열 선언 및 초기화
  let students = [
    { name: "한상우", java: 100, oracle: 80 },
    { name: "홍길동", java: 70, oracle: 60 },
  ];

  students.push({ name: "백구", java: 100, oracle: 100 });
  students.push(student4);

  // 배열에 담겨있는 모든 객체에 메소드를 추가
  for (let i = 0; i < students.length; i++) {
    students[i].getSum = function () {
      return this.java + this.oracle;
    };

    students[i].getAvg = function () {
      return this.getSum() / 2;
    };
  }

  console.log(students);

  // 모든 학생의 정보가 담긴 배열을 출력(이름, 총점, 평균)
  for (const obj of students) {
    div2.innerHTML += `이름 : ${
      obj.name
    }, 총점 : ${obj.getSum()}, 평균 : ${obj.getAvg()}<br>`;
  }

  // 5. 생성자 함수
  function Student(name, java, oracle) {
    // 속성 정의
    this.name = name;
    this.java = java;
    this.oracle = oracle;

    // 메소드 정의
    // this.getSum = function () {
    //   return this.java + this.oracle;
    // };

    // this.getAvg = function () {
    //   return this.getSum() / 2;
    // };
  }

  Student.prototype.getSum = function () {
    return this.java + this.oracle;
  };

  Student.prototype.getAvg = function () {
    return this.getSum() / 2;
  };

  let btn5 = document.getElementById("btn5");

  btn5.addEventListener("click", () => {
    let div3 = document.getElementById("div3");
    let student = new Student("문인수", 100, 80);
    let students = [];

    students.push(student);
    students.push(new Student("홍길동", 80, 80));
    students.push(new Student("이몽룡", 100, 100));
    students.push(new Student("임꺽정", 60, 60));

    console.log(student);
    // 객체가 어떤 생성자 함수로 생성되었는지 instanceof 연산자로 확인할 수 있다.
    console.log(student instanceof Student); // true
    // console.log(student instanceof Array); // false
    console.log(students);

    // 모든 학생의 정보를 출력(이름, 총점, 평균)
    for (const index in students) {
      console.log(index);
      div3.innerHTML += `이름 : ${students[index].name}, 총점 : ${students[
        index
      ].getSum()}, 평균 ${students[index].getAvg()}<br>`;
    }

    // div3.innerHTML = '안녕하세요.';
  });

  // 6. 캡슐화
  function IdolGroup(n, m) {
    let name = n;
    let members = m;

    this.getGroupName = function () {
      return name;
    };

    this.getMembers = function () {
      return members;
    };

    this.getMemberCount = function () {
      return members.length;
    };

    this.setGroupName = function (n) {
      name = n;
    };

    this.setMembers = function (m) {
      members = m;
    };
  }

  let btn6 = document.getElementById("btn6");

  btn6.addEventListener("click", () => {
    let div4 = document.getElementById("div4");
    let idol = new IdolGroup("NCT", ["도영", "마크", "태용"]);

    console.log(idol);

    idol.setGroupName("엑소");
    idol.setMembers(["백현", "카이", "시우민", "이상"]);

    console.log(idol);

    div4.innerHTML = `그룹명: ${idol.getGroupName()}, 멤버: ${idol.getMembers()}, 멤버 수: ${idol.getMemberCount()}`;
  });

  // 7. Date 객체
  let btn7 = document.getElementById("btn7");

  btn7.addEventListener("click", () => {
    let div5 = document.getElementById("div5");

    let now = new Date();
    let date1 = new Date(1000);
    let date2 = new Date("2023-01-17T11:47:30");
    let date3 = new Date(2023, 4, 25, 11, 48, 30); // 월은 0부터 시작

    div5.innerHTML = "Date 객체<br>";
    div5.innerHTML += `new : ${now}<br>`;
    div5.innerHTML += `date1 : ${date1}<br>`;
    div5.innerHTML += `date2 : ${date2}<br>`;
    div5.innerHTML += `date3 : ${date3}<br>`;

    //Date 객체의 메소드 호출
    div5.innerHTML += `now.getFullYea : ${now.getFullYear()}<br>`;
    div5.innerHTML += `now.getMonth : ${now.getMonth() + 1}<br>`; // 월은 0부터 시작
    div5.innerHTML += `now.getDate : ${now.getDate()}<br>`;
    div5.innerHTML += `now.getDay : ${now.getDay()}<br>`; // 일요일: 0 ... 토요일 : 6
    div5.innerHTML += `now.getHours : ${now.getHours()}<br>`;
    div5.innerHTML += `now.getMinutes : ${now.getMinutes()}<br>`;
    div5.innerHTML += `now.getMilliseconds: ${now.getMilliseconds()}<br>`;

    // 1970년 1월 1일 00시를 기준으로 현재 시간에 대한 밀리 세컨드 값을 반환한다.
    div5.innerHTML += `now.getTime: ${now.getTime()}<br>`;

    // 표준시와 Date 객체에 저장된 시간과의 차이를 분 단위로 반환한다.
    div5.innerHTML += `now.getTimezoneOffset: ${
      now.getTimezoneOffset() / 60
    }<br>`;
    div5.innerHTML += `now.toDateString(): ${now.toDateString()}<br>`;
    div5.innerHTML += `now.toTimeString(): ${now.toTimeString()}<br>`;
    div5.innerHTML += `now.toUTCString(): ${now.toUTCString()}<br>`;
    div5.innerHTML += `now.toISOString(): ${now.toISOString()}<br>`;
    div5.innerHTML += `now.toLocaleString(): ${now.toLocaleString()}<br>`;
    div5.innerHTML += `now.toLocaleDateString(): ${now.toLocaleDateString()}<br>`;
    div5.innerHTML += `now.toLocaleTimeString(): ${now.toLocaleTimeString()}<br>`;
    div5.innerHTML += `now.toLocaleString(): ${now.toLocaleString()}<br>`;
    div5.innerHTML += `now.toLocaleString(en-US): ${now.toLocaleString(
      "en-US"
    )}<br>`;
    div5.innerHTML += `now.toLocaleString(zh-hk): ${now.toLocaleString(
      "zh-hk"
    )}<br>`;
  });
};
