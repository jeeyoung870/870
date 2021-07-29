// npm install underscore --save
// package.json, package-lock.json의 dependencies에 설치되는 모듈을 등록시킨다.
var _ = require('underscore');
var arr = [3,6,9,1,12];
console.log(arr[0]);
console.log(_.first(arr));
console.log(_.last(arr));