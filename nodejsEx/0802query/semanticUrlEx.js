
const express = require('express');
var app = express();

// : 뒤에 오는 값들을 가변적으로 잡아낼 수 있다.
// :id로 들어오는 값은 ${req.params.id}로 변수사용 할 수 있음.
app.get('/topic/:id', (req, res) => {
    var topics = [
        ' is studying Javascript',
        ' is studying Node.js',
        ' is studying Express'
    ];
    var output = `
    <a href="/topic/0?name=${req.query.name}">Javascript</a><br>
    <a href="/topic/1?name=${req.query.name}">Node.js</a><br>
    <a href="/topic/2?name=${req.query.name}">Express</a><br>
    <h1>${req.query.name}${topics[req.params.id]}</h1>
    `;
    res.send(output);
});


app.listen(3000, () => {
    console.log('Connected port3000!');
});