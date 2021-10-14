var express = require('express');
var app = express();

const fs = require('fs');

app.set('view engine', 'pug');
app.set('views', './1014views');
app.use(express.static('resources'));
//req.body 사용 위한 urlencoded
app.use(express.json())
app.use(express.urlencoded({extended : true}))

app.get('/template', function(req, res){
    var cont = fs.readFileSync('resources/text', {encoding:'UTF-8'});
    res.render('temp', {time:Date(), txt:cont});
})

app.get('/login', function(req, res) {
    res.send('login please');
});

//query string
app.get('/topic', (req, res) => {
    res.send(req.query.id + ' : ' + req.query.name);
});

app.get('/topics', (req, res) => {
    var topic = [
        'Javascript is ...',
        'NodeJs is ...',
        'Express is ...'
    ];
    var output = `
        <a href="/topics?id=0">Javascript</a><br>
        <a href="/topics?id=1">NodeJs</a><br>
        <a href="/topics?id=2">Express</a><br><br>
        ${topic[req.query.id]}
    `;
    res.send(output);
});


// semantic url
app.get('/topics/:id', (req, res) => {
    var topic = [
        'Javascript is ...',
        'NodeJs is ...',
        'Express is ...'
    ];
    var output = `
        <a href="/topics?id=0">Javascript</a><br>
        <a href="/topics?id=1">NodeJs</a><br>
        <a href="/topics?id=2">Express</a><br><br>
        ${topic[req.params.id]}
    `;
    res.send(output);
});

// post 방식 라우팅
app.get('/form', (req, res) => {
    res.render('form');
});
app.get('/form_receiver', (req, res) => {
    var title = req.query.title;
    var des = req.query.description;
    res.send(title + ' : ' + des);
});
app.post('/form_receiver', (req, res) => {
    var title = req.body.title;
    var des = req.body.description;
    res.send(title + ' : ' + des);
});

app.listen(3000, function(){
	console.log('Connected 3000 port!');
});
