//app.js
App({
  onLaunch: function () {
    // 登录，获取用户唯一ID，用于log记录
    wx.login({
      success: res => {
        // 发送秘钥到后台，后台根据秘钥获取用户的openid，session_key,unionid
        if (res.code) {
          var appid = "wxdfb59d87c87380bf";
          var secret = "95af4939c3af5bcf3eabdc014efad68b";
          var code = res.code;
          //发起网络请求
          wx.request({
            url: 'https://api.weixin.qq.com/sns/jscode2session?appid=' + appid + '&secret=' + secret + '&js_code=' + code + '&grant_type=authorization_code',
            success: function (r) {
              //获取到每个用户的对立id
              //console.log(r.data.openid)
              //把openid保存到本地
              wx.setStorageSync('openid', r.data.openid)
            }
          })
        } else {
          console.log('获取用户登录态失败！' + res.errMsg)
        }
      }
    })
  },
  globalData: {
    userInfo: null
  }
})