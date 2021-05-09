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
		submitHandler: function(form) {

			var formData = {

				"userName": $("#email").val(),
				"password": $("#password").val()
			}
			login(formData);
		}
	})
})

function loginPopClose() {

	$(document).ready(function() {

		$('#login-form').trigger("reset");
		$(".alert").remove();

		$('#popup-modal').on('hidden.bs.modal', function() {
			$("#popup-modal").validate().resetForm();
		});
	});
}

function login(formData) {

	if ($("#login-form").valid()) {

		$.ajax({

			type: "POST",
			url: "/login",
			contentType: "application/json",
			data: JSON.stringify(formData),
			beforeSend: function(request) {
				$(".alert").remove();
				token = $.cookie('session_Tocken');
				request.setRequestHeader("Authorization", token);
			},
			success: function(response, status, xhr) {

				$(".alert").remove();

				if (!response.status) {
					//	$("#login-form").prepend(("<div class='alert alert-danger' role='alert'>" + response.message + "</div>"));

					setTimeout(function() {
						$(".modal-body").prepend(("<div class='alert alert-danger' role='alert'>" + response.message + "</div>"));
					}, 500);

				}
				if (response.status == true) {
					if (!!$.cookie('session_Tocken')) {
					$(".modal-body").prepend(("<div class='alert alert-success' role='alert'>" + response.message+ "  Tocken created in cookies"+ "</div>"));
						token = $.cookie('session_Tocken', response.token);
						
						setTimeout(function() {
						$(".alert").remove();
					}, 4000);
						
						
					}
					else {
						var token = $.cookie('session_Tocken', xhr.getResponseHeader('Authorization'), { expires: 1 });
						$.cookie('session_Tocken', response.token);
						alert(response.token)
					}
				}

			},
			complete: function(response) {

				},
				 rror: function(error) {
				alert("Something went wrong  please try again later")
				//loginPopClose();
				//$('.modal').modal('hide');

			}
		})
	}
	return false;
}

