$(document).ready(function() {
    // 1. Content 설정
    // 1) html() 메소드
    $('#content2').html($('#content1').html());
    $('#content1>a').attr('href', 'https://www.naver.com');
    $('#content2').find('a').prop('href', 'https://www.naver.com');

    $('.content').html(function(index, content) {
        console.log(index, content);

        return `<h1>인덱스 : ${index}, 내용 : ${content}</h1>`
    });

    // $('.content').html('ㅋㅋㅋㅋㅋㅋㅋㅋ');

    // 2) text() 메소드
    $('#content4').text($('#content3').text());
    // $('#content4').text('<h3>안녕</h3>');

    $('.content2').text(function(index, content) {
        console.log(index, content);

        return `<h1>인덱스 : ${index}, 내용 : ${content}</h1>`
    });

    // $('.content2').text('ㅋㅋㅋㅋㅋㅋㅋ');

    // 2. 요소 추가
    // 1) 요소 생성
    //  * 문자열로 요소를 생성하는 방법
    let h4 = '<h4>문자열로 요소를 생성</h4>';

    // $('#div1').html(h4);
    document.getElementById('div1').innerHTML = h4;
    
    //  * 자바스크립트에서 요소를 생성하는 방법
    let p = document.createElement('p');
    let textNode = document.createTextNode('자바스크립트에서 요소를 생성');

    p.appendChild(textNode);

    document.getElementById('div1').appendChild(p);

    //  * 제이쿼리에서 요소를 생성하는 방법
    let p2 = $('<p>').text('제이쿼리로 요소를 생성 1');

    console.log(p2);

    // document.getElementById('div1').appendChild(p2);
    $('#div1').append(p2);

    // 2) 요소 추가 1
    // $(A).append(B)
    $('#add1').append('<span>B</span>');
    
    // $(A).prepend(B)
    $('#add2').prepend('<span>B</span>');
    
    // $(A).after(B)
    $('#add3').after('<span>B</span>');
    
    // $(A).before(B)
    $('#add4').before('<span>B</span>');
    
    // 3) 요소 추가 2
    // $(A).appendTo(B)
    $('<span>B</span>').appendTo('#add5');
    
    // $(A).prependTo(B)
    // $('<span>B</span>').prependTo('#add6');
    $('<span>B</span>').prependTo($('#add6'));
    
    // $(A).insertAfter(B)
    $('<span>B</span>').insertAfter($('#add7'));
    
    // $(A).insertBefore(B)
    $('<span>B</span>').insertBefore($('#add8'));

    // 3. 요소 복제
    $('#item1').hover(
        // function(event) {
        //     console.log(event.type);
        //     console.log(event.target);
        //     console.log($(event.target));
        //     $(event.target).addClass('bg-hotpink');
        // },
        // function(event) {
        //     console.log(event.type);
        //     console.log(event.target);
        //     console.log($(event.target));
        //     $(event.target).removeClass('bg-hotpink');
        // }
        (event) => {
            console.log(event.type);
            $(event.target).toggleClass('bg-hotpink');
            // $('#item1').toggleClass('bg-hotpink');
        }
    );

    // 버튼 클릭 시 요소를 복제
    $('#btn1').click(function() {
        let item = $('#item1').clone(true);

        console.log(item);

        $('#clone-result').append(item);
    });

    // 4. 요소 제거
    $('#item2').hover(
        (event) => $(event.target).toggleClass('bg-hotpink')
    );

    // 1) remove() 테스트
    $('#btn_remove').click(() => {
        let item = $('#item2').remove();

        console.log(item);

        $('#remove-result').append(item);
    });

    // 2) detach() 테스트
    $('#btn_detach').click(() => {
        let item = $('#item2').detach();

        console.log(item);

        $('#remove-result').append(item);
    });

    // 3) empty() 테스트
    $('#btn_empty').click(() => {
        $('#remove-test').empty();
    });


    // 5. 배열 관리
    let array = [
        {name: '네이버', link: 'https://www.naver.com'},
        {name: '구글', link: 'https://www.google.com'},
        {name: '다음', link: 'https://www.daum.net'}
    ];

    console.log(array);

    // $.each(array, function(index, element){
    //     console.log(index, element);

    //     $('#each-test').append(`<h4>index: ${index}, name: ${element.name}, link: ${element.link}</h4>`);
    // });

    array.forEach((element, index, origin) => {
        console.log(index, element, origin);

        $('#each-test').append(`<h4>index: ${index}, name: ${element.name}, link: ${element.link}</h4>`);
    });

    $('#each-test>h4').each((index, element) => {
        console.log(index, element);

        $(element).addClass('bg-hotpink');
    });
});