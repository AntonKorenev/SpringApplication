function addProduct() {
	var table = document.getElementById("product_table");
	var row = table.insertRow(1);
	row.s

	var cellProduct = row.insertCell(0);
	var cellPrice = row.insertCell(1);
	var cellId = row.insertCell(2);

	var p_name = document.getElementById("p_name");
	var p_price = document.getElementById("p_price");
	var p_id = document.getElementById("p_id");

	if(p_name.value != "" && p_id.value != "" && p_price.value != ""){
		cellProduct.innerHTML = p_name.value;
		cellPrice.innerHTML = p_price.value;
		cellId.innerHTML = p_id.value;

		var addWindow = document.getElementById("add pop-up content");
		addWindow.style.visibility  = "hidden";
	} else{
		alert("Empty field");
	}

}