function save(){
debugger;
var formData = {
"question":    $("#question").val(),
"option1":     $("#opt1").val(),
"option2":     $("#opt2").val(),
"option3":     $("#opt3").val(),
"option4":     $("#opt4").val(),
"correctOption" : $("#answer").val(),
}

 $.ajax({
 url: "/add-question",
 data: JSON.stringify(formData),
 cache: false,
 contentType: "application/json",
 type: 'POST',
 success: function (response) {
     alert("Successfully saved record")
 },
 error: function(error){
     alert("Something went wrong. Please try again later")
 }
});
  setTimeout(function(){
      location.reload();
    }, 3000);
}

 $(document).ready(function () {
     $('#add-question').validate({
     rules: {
       question: {
         required: true,
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
           required: true,
         },

       },
     messages :{
       "question" : {
           required : 'Please enter valid question'
        },
        "opt1" : {
           required : 'Please enter valid option1'
         },
         "opt2" : {
           required : 'Please enter valid option2'
        },
        "opt3" : {
             required : 'Please enter valid option3'
        },
        "opt4" : {
             required : 'Please enter valid option4'
          },
       "answer" : {
             required : 'Please select valid answer'
          }
      },
   submitHandler: function(e) {
       save();
   }
     });
 });