
$('#imgSmall').on('change',function(e){
	var r = new FileReader();
	productData.imgSmall = e.target.files[0];
	r.readAsDataURL(e.target.files[0]);
	r.onload = function(e) {
		/*document.getElementById('small-img').src = this.result;*/
		   $("#small-img").attr("src", this.result); 
	}
});
$('#imgSmall1').on('change',function(e){
	var r = new FileReader();
	productData.imgSmall1 = e.target.files[0];
	r.readAsDataURL(e.target.files[0]);
	r.onload = function(e) {
		/*document.getElementById('small-img').src = this.result;*/
		   $("#small-img1").attr("src", this.result); 
	}
});
$('#imgSmall2').on('change',function(e){
	var r = new FileReader();
	productData.imgSmall2 = e.target.files[0];
	r.readAsDataURL(e.target.files[0]);
	r.onload = function(e) {
		/*document.getElementById('small-img').src = this.result;*/
		   $("#small-img2").attr("src", this.result); 
	}
});
$('#imgSmall3').on('change',function(e){
	var r = new FileReader();
	productData.imgSmall3 = e.target.files[0];
	r.readAsDataURL(e.target.files[0]);
	r.onload = function(e) {
		/*document.getElementById('small-img').src = this.result;*/
		   $("#small-img3").attr("src", this.result); 
	}
});
/*$('#imgSmall').on('change',function(e){
	var reader = new FileReader;
    reader.onload = function (e) {
        $scope.$apply(function () {
            vm.imageData = e.target.result;
        })
    }
    reader.readAsDataURL(vm.file);
});*/


