<!------ Include the above in your HEAD tag ---------->
<div class="modal show" tabindex="-1" role="dialog"  id="popup-modal" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <center><h5 class="modal-title" id="exampleModalLabel">Login</h5></center>
        <button type="button" class="close" onclick="loginPopClose();" id="pop-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
           <div class="modal-body">
          <form id="login-form" method="post" name="login-form">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Email ID / Username </label>
            <input type="text" class="form-control" maxlength="100" class="form-control error" name="email" id="email" Placeholder="Enter your email/username" aria-invalid="true" autocomplete=off >
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Password</label>
            <input type="password" maxlength="20" class="form-control" class="form-control error" name="password" id="password" Placeholder="Enter your password" aria-invalid="true" id="password" >
          </div>
        
      </div>
      <div class="modal-footer">
      <input type="submit" id="loginButton" class="btn-primary" value="Login">
      </div>
       <span class="register">Don't have an account?
        <a href="/register" class="register-form" for="message-text">Register</span>
    </div>
 </div>
</div>
</form>     
