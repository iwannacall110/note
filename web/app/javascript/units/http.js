/**
 * 在header中添加token
 * */

function getRequest(url, params){
  var req = {
    method: 'GET',
    url: url,
    headers: {'token': getCookie("token")},
    params: params     //路径参数
  }
  return req
}

function postRequest(url, data){
  var req = {
    method: 'POST',
    url: url,
    headers: {'token': getCookie("token")},
    data: data
  }
  return req
}

function deleteRequest(url, params){
  var req = {
    method: 'DELETE',
    url: url,
    headers: {'token': getCookie("token")},
    params: params
  }
  return req
}