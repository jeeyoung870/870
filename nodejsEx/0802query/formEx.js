const fs = require('fs');
const express = require('express');
var app = express();
// pug 셋팅
app.set('view engine', 'pug');
app.set('views', './views');

//get폼
app.get('/form1', (req, res) => {
    res.render('getForm');
});

// post 폼
app.get('/form2', (req, res) => {
    res.render('postForm');
});

// get처리메소드
app.get('/form_receiver', (req, res) => {
    var text = req.query.text;
    var usrname = req.query.usrname;
    res.send('<h1>'+ usrname + ' says "' + text + '"</h1>');
});

//post정보인 req.body 사용하기 위해서는 express.json()과 express.urlencoded()라는 미들웨어가 필요하다.
// 설치 없이 use 선언으로 바로 사용가능!
app.use(express.json()) // for parsing application/json
app.use(express.urlencoded({ extended: true })) // for parsing application/x-www-form-urlencoded
// post처리 메소드
app.post('/form_receiver', (req, res) => {
    var text = req.body.text;
    var usrname = req.body.usrname;
    res.send('<h1>'+ usrname + ' says "' + text + '"</h1>');
});

app.listen(3000, () => {
    console.log('Connected port3000!');
});