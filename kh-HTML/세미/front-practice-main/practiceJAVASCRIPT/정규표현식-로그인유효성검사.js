

    let submit = document.getElementById('submit');
    
    submit.addEventListener('click',(event)=>{
        let userId = document.getElementById('userId').value;
        let regExp1 = /^[a-z][a-z\d]{3,11}$/;
        
        if(!regExp1.test(userId)){
            
            alert('아이디를 정상적으로 입력해 주세요.');
            
            event.preventDefault();
        };
    });
    
    submit.addEventListener('click',(event)=>{
        let pass = document.getElementById('pass').value;
        let regExp2 = /^[\w!@#&%^&*-]{8,15}$/;
        
        if(!regExp2.test(pass)){
            
            alert('비밀번호를 정상적으로 입력해 주세요.');
            
            event.preventDefault();
        };
    });
    
    submit.addEventListener('click',(event)=>{
        let passCheck = document.getElementById('passCheck').value;
        // let regExp3 = /[a-zA-Z0-9]{8,15}$/;
        
        if(pass !== passCheck){
            
            alert('비밀번호를 틀렸습니다. 정상적으로 입력해 주세요.');
            
            event.preventDefault();
        };
    });
    
    submit.addEventListener('click',(event)=>{
        let userName = document.getElementById('userName').value;
        let regExp4 = /^[ㄱ-힣]{2,}$/;
        
        if(!regExp4.test(userName)){
            
            alert('이름을 정상적으로 입력해 주세요.');
            
            event.preventDefault();
        };
    });
    
    submit.addEventListener('click',(event)=>{
        let email = document.getElementById('email').value;
        let regExp5 = /^[\w]+@[\w]+\.[A-Za-z\.]{2,6}$/;
        
        if(!regExp5.test(email)){
            
            alert('이메일을 정상적으로 입력해 주세요.');
            
            event.preventDefault();
        };
    });