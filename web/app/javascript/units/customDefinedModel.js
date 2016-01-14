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
