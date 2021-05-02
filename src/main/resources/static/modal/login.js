$(document).ready(function() {

	$("#loginModalPop").click(function() {

		$(".modal").modal("show");
		document.body.style.overflow = "scroll";
	});
});

$(document).ready(function() {
	
	
	//$('.form').append($('<label id="email-error" class="error" for="email"></label>'));

	/*jQuery.validator.addMethod("emailValidation", function(value, element) {

		var email_flag = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);

		var username_flag = this.optional(element) || /^[a-zA-Z0-9 ]+$/.test(value);

		if (email_flag == true || username_flag == true)
			return true;

	}, "Please enter valid email/username"

	);
*/
	$("#login-form").validate({

		rules: {

			email: {
				required: true,
			},

			password: {
				required: true,
			},

		},
		messages: {

			email: {
				required: "Please enter your email",
			},

			password: {
				required: "Please enter your password",
			},
		},

		submitHandler: function(data) {

			var formData = {
				"username": "ankit",
				"password": "2"
			}

			$.ajax({
				type: "POST",
				url: "http://localhost:8081/quiz-application/login",
				contentType: "application/json",
				data: JSON.stringify(formData),
				success: function(response) {
					alert("Successfully added"+response.tocken)
				},
				error: function(error) {
					alert("Something went wrong  please try again later")
				}
			})

		}
	});

});

function loginPopClose() {

	$("#login-form")[0].reset();
	$(".error").html("");

}