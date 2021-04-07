<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
    *{padding:0;margin:0}
    html, body, .wrap{width: 100%;}
    .clear{clear:both;}
    .wrap>.fileBox{padding: 20px;}
    .fileBox input, textarea{width: 100%;}
    .fileBox textarea{resize:none;}
    .fileBox .fileDrop{display: inline-block;width: 700px;height: 75px;border: 1px solid #000;overflow: auto;}
    .fileDrop .fileList .fileName{padding-left: 20px;}
    .fileDrop .fileList .fileSize{padding-right: 20px; float:right;}
</style>
<body>
    <div class="wrap">
        <div class="fileBox">
            <form id="fileForm" name="fileForm" enctype="multipart/form-data" method="post">
                <table>
                    <tr>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <td><textarea name="contents"></textarea></td>
                    </tr>
                    <tr>
                        <td><div id="fileDrop" class="fileDrop"></div></td>
                    </tr>
                </table>
                <div class="buttonBox">
                    <button type="button" id="save">저장</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
var fileList = []; //파일 정보를 담아 둘 배열
$(function(){

    //드래그앤드랍
    //e : 발생한 이벤트 객체
    $("#fileDrop").on("dragenter", function(e){
        e.preventDefault();	//페이지 최상단으로 가는 것 방지
        e.stopPropagation();	//부모 태그로의 이벤트 전파 방지
    }).on("dragover", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFD8D8");
    }).on("dragleave", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFF");
    }).on("drop", function(e){
        e.preventDefault();

        //drag&drop 한 모든 파일들의 정보를 가진 FileList구하기
        var files = e.originalEvent.dataTransfer.files;
        if(files != null && files != undefined){
            var tag = "";
            //files.length : 파일들 갯수
            for(i=0; i<files.length; i++){
                var f = files[i];
                //파일 업로드 목록에 추가
                fileList.push(f);
                var fileName = f.name;
                var fileSize = f.size / 1024 / 1024;
                fileSize = fileSize < 1 ? fileSize.toFixed(3) : fileSize.toFixed(1);
                tag += 
                        "<div class='fileList'>" +
                            "<span class='fileName'>"+fileName+"</span>" +
                            "<span class='fileSize'>"+fileSize+" MB</span>" +
                            "<span class='clear'></span>" +
                        "</div>";
            }
            //this : fileDrop엘리먼트
            $(this).append(tag);
        }

        $(this).css("background-color", "#FFF");
    });


    //저장 (저장버튼을 클릭시)
    $(document).on("click", "#save", function(){
    	//FormData : fileForm폼에 들어온 모든 내용들을 ajax에 data로 실어보낼 객체로 만든다.
        var formData = new FormData($("#fileForm")[0]);
        if(fileList.length > 0){
            fileList.forEach(function(f){
            	//올린 파일들을 formData의 fileList에 추가
                formData.append("fileList", f);
            });
        }         

        $.ajax({
            url : "uploadPath.do",
            data : formData,
            type:'POST',
            enctype:'multipart/form-data',
            processData:false,	//FormData 사용시 false설정해야 함
            contentType:false,	//FormData 사용시 false설정해야 함
            dataType:'json',
            cache:false,
            success:function(res){
            	console.log(res);
            	if(res == 1) {
            		alert("저장에 성공하셨습니다.");
            	}else{
            		alert("파일 업로드 실패");
            	}
            },error:function(res){
                alert("오류 발생.\n관리자에게 문의해주세요.");
            }
        });
    });
});

</script>
</html>