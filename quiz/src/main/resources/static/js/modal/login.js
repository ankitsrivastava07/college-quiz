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

			var tocken = ""

			var formData = {

				"userName": $("#email").val(),
				"password": $("#password").val()
			}
			loginPopClose1(formData);

			$.ajax({

				type: "POST",
				url: "http://localhost:8081/college-quiz/login",
				contentType: "application/json",
				data: JSON.stringify(formData),
				beforeSend: function(request) {
					tocken = $.cookie('session_Tocken');
					request.setRequestHeader("Authorization", tocken);
				},
				success: function(response, status, xhr) {

					$(".alert").remove();

					if (!status == 'success')
						$("#login-form").prepend(("<div class='alert alert-danger' role='alert'>" + response.message + "</div>"));

					if (xhr.status == 200) {
						if (!!$.cookie('session_Tocken')) {
							tocken = $.cookie('session_Tocken');
							alert('cookies ' + tocken)
						}
						else {
							var tocken = $.cookie('session_Tocken', xhr.getResponseHeader('Authorization'), { expires: 1 });
							//Cookies.set('session_Tocken', response.tocken);

						}
					}

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

function loginPopClose1(formData) {
	tocken = $.cookie('session_Tocken') == undefined ? null : $.cookie('session_Tocken');

	$.ajax({

		type: "POST",
		url: "http://localhost:8081/college-quiz/login1",
		contentType: "application/json",
		data: JSON.stringify(formData),
		beforeSend: function(request) {
			request.setRequestHeader("Authorization", tocken);
		}, success: function(response, status, xhr) {

			alert('hh');
		}

	})
}

function loginPopClose() {

	$(document).ready(function() {

		$('#login-form').trigger("reset");
		$(".alert").remove();

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