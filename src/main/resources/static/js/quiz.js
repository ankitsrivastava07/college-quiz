$("#quizForm").submit(function() {

	var list = []

	$("input[type=radio]:checked").each(function(index) {
		index = index + 1

		selectedOptions = {

			"optionId": $(this).attr('data-id'),
			"questionId": $(this).val()
		}
		list.push(selectedOptions);

	});

	submit(list)
	//$("#quizForm")[0].reset();
	return false
});

function submit(list) {

	$.ajax({
		type: "POST",
		url: "/quiz/submit",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(list),
		success: function(response) {
			$(response).each(function(index, item) {
				var text = $("#res").html();
				
				$('#answered').html("Number of correct answers "+item.answered);

				$('#marks').html(item.marks);
				$('#unanswered').html("Un answered of given questions " +item.unAnswered);
				$('#result').html(item.result);

			});

			$(".option").html("");

			$(document).ready(function() {

				$(response.correctOptionIds).each(function(index, optionId) {
					var id = "#optionId" + optionId
					$(id).html("&nbsp;&nbsp;<img src='/images/checked.png'>");

				});

			});

			$(document).ready(function() {
				$(response.wrongAnswerIds).each(function(index, optionId) {
					var wrong_answer = "#wrong_answer" + optionId;
					$(wrong_answer).html("&nbsp;&nbsp;<img src='/images/cross_image.png'>");

				});

			});

			$("#modal-fade").modal("show");
			window.scrollTo(0, 0);

		},

		error: function(res) {
			alert(res)
		}

	});
}

$(document).ready(function() {

$('#btn').on('click', function() {
    $("#add-question").valid();
});

	$("#add-question").validate({
		ignoreTitle: true,

		rules: {
			question: {
				required: true,
				minlength: 7
			},
			opt1: {
				required: true,
			},

			opt2: {
				required: true,
			},

			opt3: {
				required: true,
			},

			opt4: {
				required: true,
			},

			answer: {
				required: true
			}

		},
		messages: {

			question: {
				required: "Please Enter question here",
			},

			opt1: {
				required: "Please Enter Option1",
			},

			opt2: {
				required: "Please Enter Option2",
			},

			opt3: {
				required: "Please Enter Option 3",
				minlength: "Option at least 15 characters long"
			},

			opt4: {
				required: "Please Enter Option 4",
			},

			answer: {
				required: "Please select answer"
			}
		},

		submitHandler: function(form) {

			var options = []

			$("#add-question input[type=text]").each(function() {

				options.push(this.value);
			});

			var correctOption = $("#answer").val()

			var formData = {

				"question": $("#question").val(),

				"option1": $("#opt1").val(),
				"option2": $("#opt2").val(),
				"option3": $("#opt3").val(),
				"option4": $("#opt4").val(),

				"correctOption": correctOption
			}

			let map = new Map()

			if (map.has(formData.option1)) {
				alert("Duplicate Option 1: containing value " + formData.option1)
				return false;
			}

			map.set(formData.option1, 1);

			if (map.has(formData.option2)) {
				alert("Duplicate Option 2: containing value " + formData.option2)
				return false;
			}

			map.set(formData.option2, 1);

			if (map.has(formData.option3)) {
				alert("Duplicate Option 3: containing value " + formData.option3)
				return false;
			}

			map.set(formData.option3, 1);

			if (map.has(formData.option4)) {
				alert("Duplicate Option 4: containing value " + formData.option4)
				return false;
			}

			map.set(formData.option4, 1);

			$.ajax({
				type: "POST",
				url: "/add-question",
				contentType: "application/json",
				data: JSON.stringify(formData),

				success: function(response) {
					alert("Successfully added")
				},
				error: function(error) {
					alert("Something went wrong  please try again later")
				}
			})
			$("#add-question")[0].reset();
		}

	});

});

function getNextPage(offset) {

	formdata = {
		"offSet": offset,
		"limit": 3
	}

	$.ajax({
		type: "GET",
		url: "/quiz",
		contentType: "application/json",
		data: formdata,

		success: function(response) {
			alert("Successfully added")
		},
		error: function(error) {
			alert("Something went wrong  please try again later")
		}
	})

}


function removeLoader() {

	$("#loadingDiv").fadeOut(300, function() {
		// fadeOut complete. Remove the loading div

		$("#loadingDiv").remove(); //makes page more lightweight 

		showPage();
		$('.center').show();
	});
}

function showGIF() {

	//$('.center').hide();

	setTimeout(removeLoader, 200); //wait for page load PLUS two seconds.

}

function showPage() {
	document.getElementById("loader").style.display = "none";
}