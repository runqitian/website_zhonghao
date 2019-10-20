$('#msgForm').on('submit', function () {
    saveReport();
    event.preventDefault();
});
function saveReport() {
    var username = $('#username').val();
    var email = $('#email').val();
    var message = $('#message').val();
    console.log(username);
    $.ajax({
        url: "home/sendMsg",
        data: { username:username, email: email, message: message },
        success: function (res) {
            console.log(res);
        }
    });
}
// getAjax();