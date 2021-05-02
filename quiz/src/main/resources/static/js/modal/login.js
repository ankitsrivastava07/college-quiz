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
				required: "Please enter your email/username",
			},

			password: {
				required: "Please enter your password",
			},
		},
		onclick: true,

		submitHandler: function(data) {

			var formData = {
				"username": "ankit",
				"password": "ankit"
			}
			var auth = "Basic " + formData.usname + ":" + formData.password;
			

			$.ajax({
				type: "POST",
				url: "http://localhost:8081/quiz-application/login",
				headers: {
					"Authorization": auth
				},
				contentType: "application/json",
				data: JSON.stringify(formData),
				success: function(response) {
					alert("Successfully added" + response.tocken)
				},
				error: function(error) {
					alert("Something went wrong  please try again later")
					//loginPopClose();
					//$('.modal').modal('hide');

				}
			})

		}
	});

});

function loginPopClose() {

	$(document).ready(function() {

		$('#login-form').trigger("reset");

		$('#popup-modal').on('hidden.bs.modal', function() {
			$("#popup-modal").validate().resetForm();
		});
	});
}
/*$(document).ready(function() {

	$('#login-form').trigger("reset");
	$('#popup-modal').on('hidden.bs.modal', function(e) {

		$('#popup-modal').on('hidden.bs.modal', function() {
			var $alertas = $('#login-form');
			$alertas.validate().resetForm();
			//$alertas.find('.error').removeClass('error');
		});

	})
});*/