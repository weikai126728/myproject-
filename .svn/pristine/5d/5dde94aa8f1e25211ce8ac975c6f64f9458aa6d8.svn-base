;(function(){
	var upload = {
		default:{
			id:'btn-container',
			submit:'submit',
			url:'http://localhost/SChimneyLife/manager/product/upload.do'
		}
	}
	productData.fileData = [];
	var file = document.getElementsByClassName('btn-files')[0];
	file.onchange = function(e) {
		var files = e.target.files;
		var container = document.getElementById(upload.default.id);
		for(var i = 0; i < files.length; i++) {
			var r = new FileReader();
			productData.fileData.push(files[i]);
			r.readAsDataURL(files[i]);
			var that = i;
			r.onload = function(e) {
				var index = productData.fileData.length;
				var span = document.createElement('span');
				span.setAttribute('index',index);
				var em = document.createElement('em');
				em.className = 'btn-del';
				if(window.addEventListener){ // Mozilla, Netscape, Firefox 
					em.addEventListener('click', function(){
						var nodes = this.parentNode;
						var index = nodes.getAttribute("index");
						nodes.remove();
						productData.fileData.splice(index,1);
						var spans = document.getElementById(upload.default.id).childNodes;
						var ii = 0;
						for(var j=0;j<spans.length;j++){
							var s = spans[j];
							if(s.tagName=='SPAN'){
								s.setAttribute("index",ii++);
							}
						}
					}, false);
				} else { // IE 
					em.attachEvent('onclick', function(){
						var nodes = this.parentNode;
						var index = nodes.getAttribute("index");
						nodes.remove();
						productData.fileData.splice(index,1);
						var spans = document.getElementById(upload.default.id).childNodes;
						var ii = 0;
						for(var j=0;j<spans.length;j++){
							var s = spans[j];
							if(s.tagName=='SPAN'){
								s.setAttribute("index",ii++);
							}
						}
					});
				} 
				span.appendChild(em);
				var img = document.createElement('img');
				
				img.src = this.result;
				span.appendChild(img);
				var btn = document.getElementById("btn-img-add");
				container.appendChild(span, btn);
			};

		}
	}
//	var submit = document.getElementById(upload.default.submit);
//	if(window.addEventListener){
//		submit.addEventListener('click', function(){save()},false);
//	}else{
//		submit.attachEvent('onclick', function(){save();});
//	}
	function save(){
		var formData = new FormData();
		for(var i=0;i<productData.fileData.length;i++){
			formData.append('files',productData.fileData[i]);
		}
		var httpRequest = new XMLHttpRequest();  
        httpRequest.onreadystatechange = function(){  
            if(httpRequest.readyState == 4 && httpRequest.status == 200){  
                alert("结果: "+httpRequest.responseText);  
            }  
        };  
        httpRequest.open("post",upload.default.url,true);  
        //httpRequest.setRequestHeader("Content-type","multipart/form-data");  
        httpRequest.send(formData);  
	};

})()