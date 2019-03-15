function getAjax() {
    request().get('http://zhonghaollc.com/api/home/bannersectioninit', function (res) {
        console.log(res);
    });
}
getAjax();