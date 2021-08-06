const express = require('express');
const fs = require('fs');

var app = express();
// pug 세팅
app.set('views', './views_file');
app.set('view engine', 'pug');
// body-parser
app.use(express.json());
app.use(express.urlencoded({extended : true}));

app.get('/topic/new', (req, res) => {
    res.render('new');
});
app.post('/topic', (req, res) => {
    var title = req.body.title;
    var description = req.body.description;
    // data에 사용자가 입력한 title을 폴더명으로 만들어 저장하기
    fs.writeFile('data/'+title, description, (err) => {
        if(err){
            res.status(500).send('Internal Server Error');
        }
        res.render('success', title);
    });
});

app.get('/redo', (req, res) => {
    res.send('OK');
});

app.listen(3000, () => {
    console.log('Connected 3000 port!');
});