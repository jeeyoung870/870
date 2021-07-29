const fs = require('fs');  //filesystem
var data = fs.readFileSync('text', {encoding:'utf-8'});
console.log(data);
console.log(1234);

var data2 = fs.readFile('text', 'utf-8', (err, d) => {
    console.log(22);
    console.log(d.split(' '));
    console.log(33);
});
console.log(1234);

//nodejs는 single-thread