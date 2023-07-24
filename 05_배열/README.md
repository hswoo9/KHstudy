## 배열(Array)

### 1. 배열(Array)
* 자바는 같은 타입의 많은 데이터를 다루는 효율적인 방법인 배열을 제공한다.
* 배열은 같은 타입의 데이터를 연속된 공간에 나열시키고, 각 데이터에 인덱스(index)를 부여해 데이터를 읽거나, 데이터를 저장하는 방법을 제공한다.
<br><img src="https://user-images.githubusercontent.com/26870393/158171660-b06d812c-c046-474e-91e2-34c44a9ea7a1.png" width="600px"/><br>
### 2. 배열 변수의 선언
* 변수와 마찬가지로 배열을 사용하기 위해서는 배열 변수를 선언해야 한다.
* 배열 변수를 선언하는 구문은 `자료형[] 변수명 또는 자료형 변수명[]`이다.
    ``` java
    // 대괄호([])는 배열 변수를 선언할 때 사용하는 기호이다.
    int[] iArray;
    double dArray[];
    ```
### 3. 배열 생성 및 초기화
#### 3.1. new 연산자로 배열 생성 및 초기화
* 배열에 저장될 값을 배열 생성 후 저장하려면 new 연산자로 배열을 생성하면 된다.
* new 연산자로 배열을 생성하는 구문은 `new 자료형[배열 크기]`이다.
    ``` java
    int[] iArray;
    double dArray[] = new double[5]; // 배열 변수 선언과 동시에 배열 생성

    iArray = new int[5]; // 배열 변수 선언 후 배열 생성
    ```
* 배열이 생성되고 나서 배열에 저장되어 있는 값을 읽거나 저장, 변경하기 위해서는 배열 변수명과 인덱스를 사용한다.
    ``` java
    //  배열의 인덱스는 0번부터 시작한다. (Zero Base)
    iArray[0] = 10; 
    iArray[1] = 20; 
    iArray[2] = 30; 
    iArray[3] = 40; 
    iArray[4] = 50;
     // iArray[5] = 60; // ArrayIndexOutOfBoundsException

    System.out.println(iArray[0]); // 10 출력
    System.out.println(iArray[1]); // 20 출력
    System.out.println(iArray[2]); // 30 출력
    System.out.println(iArray[3]); // 40 출력
    System.out.println(iArray[4]); // 50 출력
    // System.out.println(iArray[5]); // ArrayIndexOutOfBoundsException
    ```
* 배열 사용 시 반복문을 활용하여 편리하게 사용이 가능하다.
    ``` java
    // 배열변수.length 필드로 배열의 길이를 얻을 수 있다.
    for(int i = 0; i < dArray.length; i++) {
        iArray[i] = (i + 1) * 10;

        System.out.println(iArray[i]);
    }
    ```
#### 3.2. 값 목록으로 배열 생성 및 초기화
* 배열에 저장될 값을 배열 생성과 동시에 초기화하려면 값 목록으로 배열을 생성하면 된다.
* 값 목록으로 배열을 생성하는 구문은 `new 자료형[] {값, 값, 값, ... } 또는 {값, 값, 값, ... }`이다.
    ``` java
    int[] iArray = new int[] {1, 2, 3, 4, 5}; // 배열 생성과 동시에 초기화
    double dArray[] = {1.1, 2.2, 3.3, 4.4, 5.5}; // 배열 생성과 동시에 초기화
    ```
* 배열 변수를 이미 선언한 후에 중괄호를 사용한 배열 생성은 불가능하다.
    ``` java
    int[] iArray;

    iArray = {1, 2, 3, 4, 5} // 에러 발생
    ```
* 배열 변수를 미리 선언한 후에 중괄호를 사용한 배열 생성은 new 연산자를 사용해서 값 목록을 지정해야 한다.
    ``` java
    int[] iArray;

    iArray = new int[] {1, 2, 3, 4, 5}
    ```
### 4. 배열의 저장 구조
* 배열 변수는 참조 변수이다. 배열 변수는 Stack 영역에 생성된다.
* `new 자료형[배열 크기]` 구문을 실행하면 Heap 영역에 배열을 생성하고, 배열의 시작 주소를 반환한다.
* `new 자료형[] {값, 값, 값, ... } 또는 {값, 값, 값, ... }` 구문을 실행하면 주어진 값들을 요소로 가지는 배열을 Heap 영역에 생성하고, 배열의 시작 주소를 반환한다.
<br><img src="https://user-images.githubusercontent.com/26870393/158171911-a5610e73-3f31-4eb7-9fa3-046bf7053e09.png" width="600px"/><br>
* `new 자료형[배열 크기]` 구문으로 배열을 생성할 경우 배열은 자동적으로 기본값으로 초기화된다.
    |자료형|초기값|자료형|초기값|
    |:--:|:--:|:--:|:--:|
    |byte|0|float|0.0F|
    |short|0|double|0.0|
    |int|0|char|\u0000|
    |long|0|참조형|null|
    |boolean|false|||
* null(널)은 참조형 변수가 Heap 영역의 객체를 참조하지 않는다고 뜻하는 값이다.
* null 값을 가지고 있는 참조 변수를 사용하면 `NullPointerException`이 발생한다.
### 5. 배열 복사
* 배열은 한 번 생성하면 중간에 크기를 변경할 수 없다.
* 배열에 더 많은 저장 공간이 필요하다면 큰 배열을 새로 만들고 이전 배열로부터 요소 값들을 복사해야 한다.
### 5.1. 얕은 복사
* 배열의 참조 값만 가져와서 새로운 배열 변수에 저장하는 것을 얕은 복사라 한다.
* 참조 값만 복사했기 때문에 둘 중 하나라도 수정하면 모두에게 적용된다.
<br><img src="https://user-images.githubusercontent.com/26870393/158172400-9dc9f967-bbcc-4427-a0ab-eba9579e3f0c.png" width="600px"/><br>
### 5.2. 깊은 복사
* 새로운 배열을 생성해서 기존 배열의 데이터를 복사하는 것을 깊은 복사라 한다.
* for 문을 이용해서 깊은 복사를 하거나, 자바에서 제공하는 api를 사용해서 깊은 복사를 할 수 있다.
<br><img src="https://user-images.githubusercontent.com/26870393/158172483-346805e4-618d-4083-88dd-70b6fdaf9189.png" width="600px"/><br>
### 6. 배열 정렬
* 데이터를 순차적으로 나열하는 과정을 정렬이라 한다.
  * ex : 성적순, 이름순, 나이순, 최신순, 인기순, 번호순, ...
* 오름차순(Ascending, ASC)은 작은 데이터부터 큰 데이터로 나열하는 방식이다.
* 내림차순(Descending, DESC)은 큰 데이터부터 작은 데이터로 나열하는 방식이다.
* 종류
  * [시각화사이트](https://www.toptal.com/developers/sorting-algorithms)
  * 선택 정렬
  * 버블 정렬
  * 삽입 정렬
  * 퀵 정렬
  * 병합 정렬
  * 쉘 정렬
  * 기타 등등
