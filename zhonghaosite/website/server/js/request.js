function request() {
    var apiUrl = 'http://zhonghaollc.com/api/';
    var utils = {
        /**
         * 异步get请求
         * @param url 请求地址
         * @param data 数据
         * @param okCallback 成功的回调
         * @param failCallback 失败的回调
         * @param errorCallback 错误的回调
         */
        get: function (url, data, okCallback, failCallback, errorCallback) {
            var dataType = typeof(data);
            var options = {
                "url": url,
                "type": "GET",
                "dataType": "json",
                "okCallback": okCallback
                    ? okCallback
                    : null,
                "failCallback": failCallback
                    ? failCallback
                    : null,
                "errorCallback": errorCallback
                    ? errorCallback
                    : null
            };
            if (data) {
                if (dataType === "object") {
                    options.data = data;
                } else if (dataType === "function") {
                    options.data = "";
                    options.okCallback = data;
                    options.failCallback = okCallback;
                } else {
                    alert("数据格式不支持");
                }
            } else {
                options.data = {};
            }
            utils.ajax(options);
        },
        /**
         * 异步post请求
         * @param url 请求地址
         * @param data 数据
         * @param okCallback 成功的回调
         * @param failCallback 失败的回调
         * @param errorCallback 错误的回调
         */
        post: function (url, data, okCallback, failCallback, errorCallback) {
            var dataType = typeof(data);
            var options = {
                "url": url,
                "type": "POST",
                "dataType": "json",
                "okCallback": okCallback
                    ? okCallback
                    : null,
                "failCallback": failCallback
                    ? failCallback
                    : null,
                "errorCallback": errorCallback
                    ? errorCallback
                    : null
            };
            if (data) {
                if (dataType === "object") {
                    options.data = data;
                } else if (dataType === "function") {
                    options.data = "";
                    options.okCallback = data;
                    options.failCallback = okCallback;
                } else {
                    alert("数据格式不支持");
                }
            } else {
                options.data = "";
            }
            utils.ajax(options);
        },
        /*
        *
        * var options={
        *   "url":"/test",//报文中的请求方法
        *   "type":"POST",//请求方式
        *   "data":null,//请求数据(必须是对象类型)
        *   "headers":null,//自定义头信息
        *   "dataType":"json",//返回数据类型
        *   "beforeSend":null,//请求前回调
        *   "okCallback":null,//成功回调
        *   "failCallback":null,//失败回调
        *   "errorCallback":null,//报错回调
        *   "complete":null,//执行完回调
        *   "needSourceResponse": false
        * }
        *
        * */
        ajax: function (options) {
            var url = options.url;
            sendAjax();

            function sendAjax() {
                var headerObj = {};
                headerObj = $.extend(headerObj, options.headers || {});
                var settings = {
                    url: /^http/.test(url) ? url : apiUrl + url,
                    data: options.data || {},
                    type: options.type
                        ? options.type
                        : "GET",
                    headers: headerObj,
                    dataType: options.dataType
                        ? options.dataType
                        : "json",
                    cache: false,
                    contentType: 'application/json',
                    beforeSend: function (xhr) {
                        if (options.beforeSend && typeof(options.beforeSend) === "function") {
                            options.beforeSend(xhr);
                        }
                    },
                    success: function (rs, textStatus, jqXHR) {
                        try {
                            if (options.needSourceResponse) {
                                options.okCallback(rs, textStatus, jqXHR);
                            } else {
                                if (rs.code === '00000') {
                                    if (options.okCallback && typeof(options.okCallback) == "function") {
                                        var callbackData = rs.data;
                                        options.okCallback(callbackData, textStatus, jqXHR);
                                    }
                                } else {
                                    if (options.failCallback && typeof(options.failCallback) == "function") {
                                        options.failCallback(rs, textStatus, jqXHR);
                                    } else {
                                        console.log(rs.msg || rs.code);
                                    }
                                }
                            }

                        } catch (error) {
                            if (options.errorCallback && typeof(options.errorCallback) == "function") {
                                options.errorCallback(jqXHR, textStatus);
                            }
                            console.log(error);
                        }
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        if (options.errorCallback && typeof(options.errorCallback) == "function") {
                            options.errorCallback(xhr, textStatus, errorThrown);
                        } else {
                            var settings_str = JSON.stringify(options.data);
                            if (textStatus == "timeout") {
                                console.log("超时了,请求参数:" + settings_str);
                            } else {
                                console.log("请求异常,请求参数:" + settings_str);
                            }
                        }

                    },
                    complete: function (xhr, status) {
                        if (options.complete && typeof(options.complete) == "function") {
                            options.complete(xhr, status);
                        }
                    }
                };
                if (options.dataType) {
                    settings.dataType = options.dataType;
                }
                console.log(settings.data);
                $.ajax(settings);
            }
        }
    };
    return utils
}