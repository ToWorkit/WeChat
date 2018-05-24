//app.js
App({
  onLaunch: function () {
    // 登录，获取用户唯一ID，用于log记录
    wx.login({
      success: res => {
        // 发送秘钥到后台，后台根据秘钥获取用户的openid，session_key,unionid
      }
    })
  },
  globalData: {
    userInfo: null
  }
})