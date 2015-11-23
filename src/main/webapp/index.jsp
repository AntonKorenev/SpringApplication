<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/styles.css"></link>
	<script language="javascript" type="text/javascript" src="js/addProduct.js"></script>
	<script language="javascript" type="text/javascript" src="js/showAddForm.js"></script>
	<script language="javascript" type="text/javascript" src="js/closeAddForm.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
        $(document).ready(function(){
            $("#submit_button").click(function(){
                var firstName = $("#fname").val();
        		var lastName = $("#lname").val();
        		var taskDescription = $( "#task_select option:selected" ).text();
        		var positions = $('#product_table tr:has(td)').map(function(i, v) {
            		var $td =  $('td', this);
                		return {
                         	id: ++i,
                         	id: $td.eq(2).text(),
                         	price: $td.eq(1).text(),
                         	name: $td.eq(0).text()
                       	}
        		}).get();

        		var postData = {
        			firstName: firstName
        			, lastName: lastName
        			, taskDescription: taskDescription
        			, products: positions
        		}

        		$.ajax({
                    url: 'ServletJSON'
                    , type: 'POST'
                    , data: JSON.stringify(postData)
                    , success: function(res) {
                        alert(res);
                    }
                });

            });
        });
	</script>
</head>

<body>
	<p>Click on this paragraph.</p>
	<header>
		<h1>Check your order details</h1>
	</header>

	<nav>
		<ul>
			<li><a href="index.html">Order</a></li>
		</ul>
	</nav>

	<section class="order_section">
		<h2>Details</h2>

		<article class="order_article">
			<h2>Order N:</h2>
			<div name="order_form">

				<p align="center">
					<table class="contact_table">
						<tr>
                    		<td class="contact_text">First Name: </td>
                    		<td class="contact_input">
								<input class="contact_input_field" type="text" name="fname" id="fname">
							</td>
                		</tr>
                		<tr>
                    		<td class="contact_text">Last Name: </td>
                    		<td class="contact_input">
								<input class="contact_input_field" type="text" name="lname" id="lname">
							</td>
                		</tr>
                		<tr>
                    		<td class="contact_text">Action: </td>
                    		<td class="contact_input">
								<select id="task_select" class="contact_input_field">
									<option>buy</option>
									<option>change</option>
									<option>service</option>
								</select>
							</td>
                		</tr>
					</table>
				</p>

				<div class="product_container">
					<table class="product_table" id="product_table">
						<thead>
						<tr class="product_table_cell">
							<th class="product_table_cell">Product</th>
							<th class="product_table_cell">Price</th>
							<th class="product_table_cell">Id</th>
						</tr>
						</thead>
						<tbody id="product_table_content">
						</tbody>
					</table>
				</div>

				<p class="buttons_panel">
						<button onclick="showAddForm()">Add</button>
						<button id="submit_button">Submit</button>
				</p>

			</div>
		</article>
	</section>

	<div id="add pop-up content" class="add_window">
		<div class="add_window_content">
			<table>
				<tr>
					<td class="order_position_text">Name: </td>
					<td><input type="text" name="p_name" id="p_name"></td>
				</tr>
				<tr>
					<td class="order_position_text">Price: </td>
					<td><input type="text" name="p_price" id="p_price"></td>
				</tr>
				<tr>
					<td class="order_position_text">Id: </td>
					<td><input type="text" name="p_id" id="p_id"></td>
				</tr>
			</table>
			<p>
				<button onclick="addProduct()">Add</button>
       			<button onclick="closeAddForm()">Close</button>
			</p>
		</div>
	</div>

	<footer class="page_footer">
		<address>
			Written by Anton Korenev.<br>
			anton.korenev@sigma.software<br>
			Kiev, Ukraine
		</address>
	</footer>
</body>

</html>