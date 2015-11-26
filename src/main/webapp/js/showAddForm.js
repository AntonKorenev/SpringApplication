function showAddForm() {
	var addWindow = document.getElementById("add pop-up content");
	addWindow.style.visibility  = "visible";
	var p_name = document.getElementById("p_name");
	var p_price = document.getElementById("p_price");
	var p_id = document.getElementById("p_id");

	p_name.value = "";
	p_price.value = "";
	p_id.value = "";
}