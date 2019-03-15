function getAjax() {
    request().get('/api/home/bannersectioninit', function (res) {
        console.log(res);
    });
}
getAjax();