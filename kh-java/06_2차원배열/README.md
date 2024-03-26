## 2차원 배열
### 1. 2차원 배열
* 배열의 요소로 다른 배열을 가지는 배열을 2차원 배열이라고 한다.
* 2차원 배열은 논리적으로 행과 열로 이루어진 표 형태로 존재한다고 생각하면 된다.
* 2차원 배열은 할당된 공간마다 인덱스 번호 두 개를 갖는다. (앞 번호는 행, 뒤 번호는 열)
### 2. 2차원 배열 변수 선언
* 2차원 배열 변수를 선언하는 구문은 `자료형[][] 변수명 또는 자료형 변수명[][]`이다.
    ``` java
    int[][] iArray;
    double dArray[][];
    byte[] bArray[]; // 배열 변수 선언 가능
    ```
### 3. 2차원 배열의 생성 및 초기화
#### 3.1. new 연산자로 2차원 배열 생성 및 초기화
* new 연산자로 2차원 배열을 생성하는 구문은 `new 자료형[행 크기][열 크기]`이다.
    ``` java
    int[][] iArray;
    double dArray[][] = new double[4][4];

    iArray = new int[4][4];
    ```
* 2차원 배열이 생성되고 나서 배열을 사용하기 위해서는 변수명과 두 개의 인덱스(행과 열)를 사용한다.
    ``` java
    iArray[0][0] = 10; 
    iArray[0][1] = 20; 
    iArray[0][2] = 30; 
    iArray[0][3] = 40; 
    ...

    System.out.println(iArray[0][0]); // 10 출력
    System.out.println(iArray[0][1]); // 20 출력
    System.out.println(iArray[0][2]); // 30 출력
    System.out.println(iArray[0][3]); // 40 출력
    ...
    ```
* 2차원 배열 사용 시 중첩 반복문을 활용하여 편리하게 사용이 가능하다.
    ``` java
    for(int i = 0; i < iArray.length; i++) {
        for(int j = 0; j < iArray[i].length; j++) {
            iArray[i][j] = (j + 1) * 10;

            System.out.println(iArray[i][j]);
        }
    }
    ```
#### 3.2. 값 목록으로 2차원 배열 생성 및 초기화
* 값 목록으로 2차원 배열을 생성하는 구문은 `new 자료형[][] {{값, 값, ... }, {값, 값, ... }} 또는 {{값, 값, ... }, {값, 값, ... }}`이다.
    ``` java
    int[][] iArray = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}};
    double dArray[][] = {{1.1, 2.2, 3.3, 4.4}, {5.5, 6.6, 7.7, 8.8}};
    ```
### 4. 2차원 배열의 구조
* 위 예시의 `iArray`의 구조는 아래와 같다.
<br><img src="https://user-images.githubusercontent.com/26870393/161427913-24f7b27a-7bc0-447b-b680-2ff358d28903.png" width="600px"/><br>
### 5. 가변 배열
* 가변 배열은 행은 정해졌으나 각 행에 대한 열의 개수가 정해지지 않은 배열이다.
* 2차원 배열은 배열 여러 개가 묶인 것으로 묶여있는 배열의 길이가 모두 같을 필요는 없다.
    ``` java
    // 가변 배열 생성 및 초기화
    int[][] iArray = new int[2][]; // 가변 배열 생성 (행의 크기는 3행) 
    double[][] dArray = {{1.1, 2.2}, {3.3}, {4.4, 5.5, 6.6}}; // 생성과 동시에 초기화

    // 각 행에 다른 배열을 참조할 수 있도록 할당
    iArray[0] = new int[3]; // 0행은 3열
    iArray[1] = new int[2]; // 1행은 2열

    // 중첩 for 문을 통한 가변 배열 초기화
    for(int i = 0; i < iArray.length; i++) {
        // iArray[i].length 필드로 각 열의 길이를 얻을 수 있다.
        for(int j = 0; j < iArray[i].length; j++) {
            iArray[i][j] = j + 1;
        }
    }
    ```
### 6. 가변 배열의 구조
* 위 예시의 `iArray`의 구조는 아래와 같다.
<br><img src="https://user-images.githubusercontent.com/26870393/161428132-b1b1cb0c-db9a-49db-adaf-b09934da9dd2.png" width="600px"/><br>
