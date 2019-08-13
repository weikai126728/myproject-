;(function(){
	var root = $('#root').val();
	$('#pro-source').on('change',function(e){
		var index = $(this).val();
		productData.productSource = index;
		if(index!=0){
			$('#thirdID').show();
		}else{
			$('#thirdID').hide();
		}
	});
	//获取阿里数据，用于同步specId
	$('.xy-btn-update').on('click',function(){
		var productID = $(this).prev().val();
		if(!productID||productID==''){
			layer.msg('请准确填写数据！',{time:1000});
			return false;
		}
		$(this).addClass('xy-btn-update-transform');
		var that = this;
		$.post(root+'/manager/product/getAliData.do',{productID:productID},function(data){
			$(that).removeClass('xy-btn-update-transform');
			if(data.code==0){
				var result = data.result.productInfo;
				var subject = result.subject;
				$(that).next().html(subject);
				$(that).next().attr('title',subject);
				$('.thirdSpec').show();
				var str = [];
				var skuInfos = result.skuInfos;
				for(var i=0;i<skuInfos.length;i++){
					var attributes = skuInfos[i].attributes;
					var details = '';
					for(var j=0;j<attributes.length;j++){
						details += attributes[j].attributeValue+"&nbsp;&nbsp;";
					}
					str.push('<option value="'+skuInfos[i].specId+'" specId="'+skuInfos[i].specId+'">'+details+'</option>');
				}
				$('.thirdSpec').each(function(){
					$(this).find('select').append(str.join(''));
					var specId = $(this).parents('.spec-group').attr('specId');
					if(specId&&specId!=null&&specId!=''){
						$(this).find("select option[specId='"+specId+"']").attr("selected","selected");
						$(this).find('select').val(specId);
					}
					
				});
			}else{
				layer.msg('信息同步失败！',{time:1000});
			}
		},'json');
	});
})()