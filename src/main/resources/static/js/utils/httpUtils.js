// utils/httpUtils.js
(function(global) {
    // HTTP请求工具类
    var HttpUtils = {
        // 应用上下文路径
        contextPath: '/baseFramework',
        
        // 设置上下文路径
        setContextPath: function(path) {
            this.contextPath = path || '';
        },
        
        // 封装HTTP请求方法
        httpRequest: function(options) {
            var defaultOptions = {
                url: options.url,
                type: options.type || 'GET',
                data: options.data || null,
                headers: options.headers || {},
                processData: options.processData !== undefined ? options.processData : true,
                contentType: options.contentType !== undefined ? options.contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
                success: options.success || function() {},
                error: options.error || function() {}
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
