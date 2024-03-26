window.onload = function () {
    // 1. 노드 생성
    // 1) 텍스트 노드가 있는 요소 노드 생성
    let btn1 = document.getElementById('btn1');

    btn1.addEventListener('click', () => {
        // 요소 노드 생성
        let h3 = document.createElement('h3');

        // 텍스트 노드 생성
        let textNode = document.createTextNode('안녕하세요.');

        h3.appendChild(textNode);
        document.getElementById('div1').appendChild(h3);

        // document.getElementById('div1').innerHTML = '<h3>안녕하세요.</h3>';
    });

    // 2) 텍스트 노드가 없는 요소 노드 생성
    let btn2 = document.getElementById('btn2');

    btn2.addEventListener('click', () => {
        // 요소 노드 생성
        let image = document.createElement('img');

        // 속성 지정
        image.setAttribute('src', '../resources/image/flower1.PNG');
        image.setAttribute('width', '150px');
        image.setAttribute('height', '100px');
        
        document.getElementById('div2').appendChild(image);
        
        // document.getElementById('div2').innerHTML += 
        //     '<img src="../resources/image/flower1.PNG" width="150px" height="100px">';
    });

    // 2 . 노드 삭제
    let btn3 = document.getElementById('btn3');

    btn3.addEventListener('click', (event) => {
        document.getElementById('div1').remove();
        document.body.removeChild(document.getElementById('div2'));

        console.log(event);
        console.log(event.type);
        console.log(event.target);
        console.log(event.target.parentNode);

        event.target.parentNode.removeChild(document.getElementById('div3'));
    });



};