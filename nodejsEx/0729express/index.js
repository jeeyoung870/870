// get();메소드로 라우팅하기

const fs = require('fs');
const express = require('express');
var app = express();

//정적 파일의 위치 디렉토리 지정(public이 루트(/)디렉토리가 됨)
app.use(express.static('public'));
// app.use('/static', express.static('public'));
// 이런식으로 정적디렉토리에 경로명을 줄 수도 있음 / <img src="static/image1.png"> 로 사용

//http://localhost:3000/image1.png 요청하면 이미지가 출력됨
// 디렉토리 안의 파일을 꺼내 사용할 수도 있다.

app.get('/', (req, res) => {
    res.send(`<h1>Home Page</>`);
});
app.get('/login', (req, res) => {
    res.send(`<h1>Please Login</>`);
});
app.get('/mobile', (req, res) => {
    res.send('<h1>Hello, mobile!</h1><img src="/image1.png">');
});
app.get('/textarea', (req, res) => {
    res.send('<h1>Hello, Static!</h1>'
    + '<textarea placeholder="text here"></textarea>');
});

//동적으로 코드작성하기
app.get('/dynamic', (req, res)=> {
    var content = fs.readFileSync('public/text', {encoding:'utf-8'});
    var lis = '<ol><h3>textList</h3>';
    for(var i=0; i<5; i++){
        lis += '<li>NodeJs & Express</li>';
    }
    lis += '</ol>';
    var output = `
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>static html</title>
        </head>
        <body>
            <h1>Hello, Dynamic!</h1>
            <p>${content}</p>
            <br><br>
            ${lis}
        </body>
    </html>
    `;
    res.send(output);
});

app.listen(3000, () => {
    console.log('Connected port3000!');
});
