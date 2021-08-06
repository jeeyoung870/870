
const express = require('express');
var app = express();

app.get('/topic', (req, res) => {
    // url 로 ?id=0&name=jyjy 전달했을 때
    var topics = [
        ' is studying Javascript',
        ' is studying Node.js',
        ' is studying Express'
    ];
    var output = `
    <a href="/topic?id=0&name=${req.query.name}">Javascript</a><br>
    <a href="/topic?id=1&name=${req.query.name}">Node.js</a><br>
    <a href="/topic?id=2&name=${req.query.name}">Express</a><br>
    <h1>${req.query.name}${topics[req.query.id]}</h1>
    `;
    res.send(output);
});


app.listen(3000, () => {
    console.log('Connected port3000!');
});