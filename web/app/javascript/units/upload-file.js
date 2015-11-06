/**
 *使用html5来实现文件的批量拖拽上传
*/

/*阻止浏览器的默认行为, 将文档的拖放事件全部重写*/
document.ondragleave = function(e){    //拖离
  e.preventDefault()
}

document.ondrop = function(e){         //拖后放
  e.preventDefault()
}

document.ondragenter = function(e){    //拖进
  e.preventDefault()
}

document.ondragover = function(e){     //拖去
  e.preventDefault()
}

function uploadFile(){
  //获取拖拽事件传递的文件信息
  var fileList = e.dataTransfer.files
  //获取文件的数量
  var fileNum = fileList.length
  if(fileNum == 0){
    return false
  }
  for(var i=0;i<fileList.length;i++){
    var filesize = Math.floor((fileList[i].size)/1024)   //获取文件大小(KB)
    if(filesize){}
  }
  //获取拖拽区域
  val fileArea = document.getElementById("file_upload_area")
  fileArea.addEventListener("drop",function(e){

  })
}