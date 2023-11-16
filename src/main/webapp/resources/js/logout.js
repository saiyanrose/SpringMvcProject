$(document).ready(function(){
	$("#logout-link").on("click",function(){
		  submitLogoutForm();	
	});  	
});

function submitLogoutForm(){		
	let getLogoutForm=$("#logout-form");
	getLogoutForm.submit();	
}