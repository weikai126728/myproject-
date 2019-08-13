(function() {
	x=document.getElementsByTagName('base')[0];
	var baseURL = x.href;
	var wsURL = baseURL.replace("http","ws");
    var websocket;

    
    // 首先判断是否 支持 WebSocket
    if('WebSocket' in window) {
        websocket = new WebSocket(wsURL+"/websocket.do");
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket(wsURL+"/websocket.do");
    } else {
        websocket = new SockJS(baseURL+"/sockjs/websocket.do");
    }

    // 打开时
    websocket.onopen = function(evnt) {

    };


    // 处理消息时
    websocket.onmessage = function(evnt) {
        onMessage&&onMessage(evnt.data);

    };


    websocket.onerror = function(evnt) {

    };

    websocket.onclose = function(evnt) {

    };


})();