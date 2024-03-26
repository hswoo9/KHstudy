$(document).ready(() => {
    // 4. 자손, 후손 선택자
    // 1) 자손 선택자(부모>자손)
    $('div>h3').css('color', 'violet');
    $('div>ul>li').css('color', 'green');
    $('div>ul>li>h3').css('color', 'orange');

    // 2) 후손 선택자(부모 후손)
    $('div h3').css('background-color', 'skyblue');
    $('div .ch').css('background-color', 'tomato');

    // 5. 속성 선택자
    // $('#div1 input[class]').css('background-color', 'tomato');
    // $('#div1 input[type=text]').val('Change Value');
    // $('#div1 input[class~=test1]').val('123456789');
    // $('#div1 input[type^=ra]').prop('checked', true);
    // $('#div1 input[type$=box]').prop('checked', true);
    // $('#div1 input[class*=st]').css('width', '100px').css('height', '100px').val('10000');

    // 6. 입력 양식 선택자
    // $(':text').css('background-color', 'pink');
    // $(':button').val('왕버튼').css({width: '150px', height: '150px'});
    // $(':checkbox').prop('checked', true).css({width: '50px', height: '50px'});
    // $(':file').css('background-color', 'yellow');
    // $(':image').hover(
    //     function () {
    //         // 마우스가 요소 내부로 들어왔을 때 이벤트 처리
    //         console.log(this);
    //         console.log(this.src);
    //         console.log($(this));
    //         console.log($(this).attr('src'));
    //         $(this).attr('src', '../resources/image/flower2.PNG')
    //     },
    //     function () {
    //         // 마우스가 요소 외부로 나갔을 때 이벤트 처리
    //         console.log(this);
    //         console.log(this.src);
    //         console.log($(this));
    //         console.log($(this).attr('src'));
    //         $(this).attr('src', '../resources/image/flower1.PNG')
    //     }
    // );

    // 7. 입력 양식 상태 선택자
    // input 태그 중에 활성화된 요소를 선택
    $('#div3 input:enabled').css('background-color', 'yellow');
    // input 태그 중에 비활성화된 요소를 선택
    $('#div3 input:disabled').css('background-color', 'tomato')
    // input 태그 중에 체크된 요소를 선택
    $('#div3 input:checked').css({width: '20px', height: '20px'})
    // checkbox에 change 이벤트 핸들러 등록
    // $('#div3 input:checkbox')
    $('#div3 input[type=checkbox]').change(function () {
        console.log(this);
        console.log($(this));

        let checkbox = $(this);

        console.log(checkbox.attr('checked'));
        console.log(checkbox.prop('checked'));

        if(checkbox.prop('checked')) {
            checkbox.css({width: '30px', height: '30px'})
        } else {
            checkbox.css({width: '20px', height: '20px'})
        }
    });

    $('#result1').val($('#national>option:selected').val());

    // select에 change 이벤트 핸들러 등록
    $('#national').change(function() {
        // select에 option 태그 중 선택된 요소를 선택
        let value = $('#national>option:selected').val();

        console.log(value);

        // id가 result1인 요소의 값을 value로 변경
        $('#result1').val(value);
    });

    $('#result2').val($('#hobby>option:selected').val());

    $('#hobby').change(() => {
        let value = $('#hobby>option:selected').val();

        console.log(value);

        $('#result2').val(value);
    });

    // 8. attr()와 prop()
    let ch1 = $('#ch1');
    let ch2 = $('#ch2');

    // attr()로 checked 값 읽어오기
    console.log(`ch1.attr('checked') : ${ch1.attr('checked')}`);
    console.log(`ch2.attr('checked') : ${ch2.attr('checked')}`);
    // $('#ch2').attr('checked', 'checked');

    // prop() checked 값 읽어오기
    console.log(`ch1.prop('checked') : ${ch1.prop('checked')}`);
    console.log(`ch1.prop('checked') : ${ch2.prop('checked')}`);
});