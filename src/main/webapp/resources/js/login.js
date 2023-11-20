const loginForm=document.getElementById('form-login');
loginForm.addEventListener('submit',validateLoginForm);

function validateLoginForm(event) {	
	event.preventDefault();	

	const username = document.getElementById("email").value;
	const password = document.getElementById("password").value;
	console.log("username: "+username+" password: "+password);
	
	if (username.length == 0) {
		document.getElementById("usernameError").textContent = 'email cannot be empty';
		return;
	} else if (password.length == 0) {
		document.getElementById("passwordError").textContent = 'password cannot be empty';
		return;
	}
	
	loginForm.submit();
}



