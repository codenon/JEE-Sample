//js 解析 xml 文档的函数, 只支持 ie
function parseXml(fileName) {
	// IE 内核的浏览器
	if (window.ActiveXObject) {
		// 创建 DOM 解析器
		var doc = new ActiveXObject("Microsoft.XMLDOM");
		doc.async = "false";
		// 加载 XML 文档, 获取 XML 文档对象
		doc.load(fileName);
		return doc;
	}
}
