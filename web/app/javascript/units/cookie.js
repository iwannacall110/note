/**
 * 操作cookie的js
 */

/**
 * 设置cookie
 * @param name
 * @param value
 * @param validMinites  有效时间(分钟)
 */
function setCookie(name,value,validMinites) {
  var extime = new Date()
  extime = new Date(extime.setMinutes(extime.getMinutes() + validMinites))
  document.cookie = name + "=" + escape(value)+
      ((validMinites==null) ? "" : ";expires=" + extime.toGMTString())
}

/**
 * 读取cookie
 * @param name
 * @returns {string}
 */
function getCookie(name){
  if (document.cookie.length>0){
    var start = document.cookie.indexOf(name + "=")
    if (start!=-1){
      start = start + name.length+1
      var end = document.cookie.indexOf(";",start)
      if (end==-1) end = document.cookie.length
      return unescape(document.cookie.substring(start,end))
    }
  }
  return ""
}

/**
 * 清除cookie
 * @param name
 * @returns {string}
 */
function removeCookie(name){
  var extime = new Date("1970-01-01")
  extime = new Date(extime.setMinutes(extime.getMinutes()))
  document.cookie = name + "=" + escape("")+ ";expires=" + extime.toGMTString()
}

/**
 * 检查cookie是否存在
 */
function checkCookie(name) {
  var cookieName = getCookie(name)
  if(cookieName == ""){
    return false
  } else {
    return true
  }
}