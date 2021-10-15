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

//data 디렉토리안의 파일명을 배열로 반환하는 readdir로 view에 topic명들 전달해주기.
app.get(['/topic', '/topic/:id'], (req, res) => {
    fs.readdir('data', (err, files) => {
        if(err){
            console.log(err);
            res.status(500).send('Internal Server Error');
        }
        var id = req.params.id;
        // '/topic/:id'으로 호출할 경우,
        if(id){
            fs.readFile('data/'+id, 'utf-8', (err, data) => {
                if(err){
                    console.log(err);
                    res.status(500).send('Internal Server Error');
                }
                res.render('view', {topics:files, title:id, description:data});
            });
        } else {
            res.render('view', {topics:files, title:'Welcome!', description:'This is jy870 WebApp.'});
        }
    });
});

app.post('/topic', (req, res) => {
    var title = req.body.title;
    var description = req.body.description;
    // data에 사용자가 입력한 title을 폴더명으로 만들어 저장하기
    fs.writeFile('data/'+title, description, (err) => {
        if(err){
            res.status(500).send('Internal Server Error');
            // console.log(err);
        }
        // res.render('success', title);
        // res.send(`
        //     <h1>Success!</h1>
        //     <a href="/topic">Move to Subject view</a>
        // `);
        res.redirect('/topic/'+title);
    });  
});

app.get('/redo', (req, res) => {
    res.send('OK');
});

app.listen(3000, () => {
    console.log('Connected 3000 port!');
});