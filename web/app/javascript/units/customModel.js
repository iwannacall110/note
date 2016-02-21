/**
 * 自定义模块(方法和结构)
*/

/**
 * 判断数组是否包含指定元素
 */
Array.prototype.contains = function(obj){
  var i = this.length
  while(i--){
    if(self[i] == obj){
      return true
    }
  }
  return false
}

/**
 * 数组过滤重复元素
 * @returns {Array}
 */
Array.prototype.distinct = function(){
  var self = this
  var _array = []
  self.forEach(function(e){
    if(_array.contains(e)){
      _array.push(e)
    }
  })
  return _array
}

/**
 * 数组删除指定元素
 * @param ele
 * @returns {Array}
 */
Array.prototype.remove = function(obj){
  var self = this
  var _array = []
  self.forEach(function(e){
    if(e != obj){
      _array.push(e)
    }
  })
  return _array
}

/**
 * 获取字符串的字节数(区分中英文)
 * @returns {number}
 * @constructor
 */
String.prototype.byteLength = function() {
  var len = 0
  for (var i=0; i<this.length; i++) {
    if (this.charCodeAt(i)>127 || this.charCodeAt(i)==94) {
      len += 2
    } else {
      len ++
    }
  }
  return len
}

/**
 * 将单位为Byte的数值格式化为恰当的显示单位
 */
Number.prototype.byteFormat = function(){
  var str = ""
  if(this < 1024){
    str = this + "字节"
  } else if(this < 1024*2014){
    str = (this/1024).toFixed(1) + "KB"
  } else{
    str = this/(1024*1024).toFixed(1) + "MB"
  }
  return str
}