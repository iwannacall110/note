/**
 * 在header中添加token
 * */
function postRequest(url, data){
  var req = {
    method: 'POST',
    url: url,
    headers: {'token': getCookie("token")},
    data: data
  }
  return req
}

function getRequest(url, params){
  var req = {
    method: 'GET',
    url: url,
    headers: {'token': getCookie("token")},
    params: params     //路径参数
  }
  return req
}