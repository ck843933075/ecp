/** ajax获取省市级联菜单 */

// 初始化省市级联菜单
$(function() {
	getProvince();
});

// 获取省份的ajax请求
function getProvince() {
	var pId = $("input[name=province]").val();
	console.log("==========province----id==========" + pId);

	$.ajax({
		url : "/province.do",
		method : "post",
		dataType : "json",
		async : true,
		success : function(data) {
			var provinceList = data.province;
			for (var i = 0; i < provinceList.length; i++) {
				// 浏览器控制台打印
				console.log(provinceList[i].id + "、" + provinceList[i].name);
				//$("select[name=province]").empty();
				var option = "<option value=\"" + provinceList[i].id + "\"";
				if(pId == provinceList[i].id) {
					// 回显省份
					option += " selected='selected'>" + provinceList[i].name + "</option>"; // 动态添加数据
					// 回显城市
					getCity(pId);
				}else {
					option += ">" + provinceList[i].name + "</option>"; // 动态添加数据
				}
				$("select[name=province]").append(option);
			}
		},
		error : function() {
			alert("对不起，省份出错啦！");
		}
	});
}

// 获取市的ajax请求
function getCity(id) {
	/*
	alert("====city--id====" + id);
	if(id == null || id == "") {
		id = $("input[name=province]").val();
	}
	*/
	var cId = $("input[name=city]").val();
	$("select[name=city]").empty();
	$("select[name=city]").append("<option>请选择</option>");
	// alert("获取城市===="+id);
	$.ajax({
		url : "/city.do",
		data : {
			"id" : id
		},
		method : "post",
		dataType : "json",
		async : true,
		success : function(data) {
			var cityList = data.cities;
			for (var i = 0; i < cityList.length; i++) {
				console.log(cityList[i].id + "、" + cityList[i].name);
				var option = "<option value=\"" + cityList[i].id + "\"";
				if(cId == cityList[i].id) {
					option += " selected='selected'>" + cityList[i].name + "</option>"; // 动态添加数据
				}else {
					option += ">" + cityList[i].name + "</option>"; // 动态添加数据
				}
				$("select[name=city]").append(option);
			}
		},
		error : function() {
			alert("对不起，城市出错啦！");
		}
	});
}