/**
 * 
 */
function swap(f) {
	if (f == -1) {
		return "Delete";
	} else if (f == 0) {
		return "Waiting";
	} else
		return "Success";
}
var table = document.getElementsByTagName("tbody"), trs = table[0]
		.getElementsByTagName("tr");
for (var x = 0; x < trs.length; x++) {
	var tds = trs[x].getElementsByTagName("td");
	tds[3].innerHTML = swap(tds[3].innerHTML);
}