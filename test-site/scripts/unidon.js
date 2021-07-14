// let myHeading = document.querySelector('h1');
// myHeading.textContent = 'Hello World!';

//event
document.getElementById('review').onclick = () => {
    alert("리뷰 페이지로 이동합니다!");
}
//사진 변경
let myImg = document.querySelector('img');
myImg.onmouseenter = () => {
    myImg.setAttribute('src', 'images/unidon2.png');
}
myImg.onmouseleave = () => {
    myImg.setAttribute('src', 'images/unidon.png');
}
// chUser버튼을 누르면 prompt()로 유저이름 입력받아서 local에 저장하기
let myBtn = document.getElementById('chUser');
let myh1 = document.querySelector('h1');

const setUserName = () => {
    let userName = prompt('이름을 입력하세요.');
    if(!userName || userName === null) {
        setUserName();
    }
    //localStorage : 브라우저에 데이터를 저장하고 나중에 불러올 수 있도록 해주는 API
    localStorage.setItem('name', userName);
    myh1.textContent = userName + ' 씨도 우니동 맨날 먹고 싶지?';
}
// localStorage에 저장된 사용자명이 없다면,
if(!localStorage.getItem('name')) {
    setUserName();
}else {
    let storedName = localStorage.getItem('name');
    myh1.textContent = storedName + ' 씨도 우니동 맨날 먹고 싶지?';
}
myBtn.onclick = () => {
    setUserName();
}