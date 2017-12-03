function FormUtil() {
	this.queryOption;
	this.data = {
		async : true
		,type : "POST"
		,cache : true
		,processData: false
		,contentType : false
		,url : ""
		,data: {}
		,dataType : "json"
		,success : function (jsonResult) {
			
		}
		,error : function(xhr, textStatus, errorThrown) {
			alert(xhr.responseText);
		}
	}
}

FormUtil.prototype.submit = function(option) {
	for (var key in option) {
		this.data[key] = option[key];
	}
	$.ajax(this.data);
}

FormUtil.prototype.binddata = function(item) {
	for(var key in item.tableData) {
		item.tableObj.find("[name=" + key + "]").val(item.tableData[key]);//如果是input屬性需使用val給值
		item.tableObj.find("[name=" + key + "]").text(item.tableData[key]);//td使用text
	}
}
var formUtil = new FormUtil();