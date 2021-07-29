// 템플릿 엔진 설치로 동적, 정적 프로그래밍의 장점만을 살릴 수 있음
// pug 템플릿엔진 설치 :  npm install pug --save

const fs = require('fs');
const express = require('express');
var app = express();
// express 모듈에 템플릿엔진(pug) 세팅하기
app.set('view engine', 'pug');
// 템플릿이 있는 디렉토리를 세팅하기
app.set('views', './views'); //생략해도 기본적으로 views폴더를 찾음

app.use(express.static('public'));

app.get('/templete', (req, res) => {
    // 템플릿엔진을 사용한 코드를 사용하기 render('파일명');
    args = {subject: 'Pug', msg:'Hi, Pug Templete!',
        imgsrc:'/image1.png', time: Date() };
    // temp 템플릿에 여러가지 파라미터값을 넘겨줄 수 있음!
    res.render('temp', args);
});

app.get('/dynamic', (req, res)=> {
    var content = fs.readFileSync('public/text', {encoding:'utf-8'});
    var output = `
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <title>static html</title>
        </head>
        <body>
            <h1>Hello, Static!</h1>
            <p>${content}</p>
        </body>
    </html>
    `;
    res.send(output);
});

app.listen(3000, () => {
    console.log('Connected port3000!');
});