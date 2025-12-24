// utils/httpUtils.js
(function (global) {
    // HTTP请求工具类
    var HttpUtils = {
        // 应用上下文路径
        contextPath: '/baseFramework',

        // 设置上下文路径
        setContextPath: function (path) {
            this.contextPath = path || '';
        },

        // 封装HTTP请求方法
        httpRequest: function (options) {
            var defaultOptions = {
                url: options.url,
                type: options.type || 'GET',
                timeout: options.timeout || 30000,
                data: options.data || null,
                headers: options.headers || {},
                processData: options.processData !== undefined ? options.processData : true,
                contentType: options.contentType !== undefined ? options.contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
                success: function (response) {
                    if (response.code === 200) {
                        // 成功，调用原始 success 回调
                        if (options.success) {
                            options.success(response);
                        }
                    } else if (response.code === 401) {
                        // 未授权，跳转登录页
                        alert(response.message || '登录已过期，请重新登录');
                        window.location.href = './login.html';
                    } else {
                        // 失败，调用原始 error 回调
                        if (options.error) {
                            options.error(response);
                        }
                    }
                },
                error: function(xhr, status, error) {
                    if (options.error) {
                        options.error(xhr, status, error);
                    }
                }
            };

            // 添加上下文路径
            if (this.contextPath && defaultOptions.url.charAt(0) === '/') {
                defaultOptions.url = this.contextPath + defaultOptions.url;
            }

            return $.ajax(defaultOptions);
        }
    };

    // 暴露到全局对象
    global.HttpUtils = HttpUtils;
})(window);
