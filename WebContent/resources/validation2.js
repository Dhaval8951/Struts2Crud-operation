function LoginDetails() {
	var email = document.forms["myForm"]["email"].value;
	var pass = document.forms["myForm"]["pass"].value;
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
		return (true)
	} else {
		alert("You have entered an invalid email address!")
		return (false)
	}
	if (pass == "") {
		alert("pass  must be filled out");
		return false;
	}

}
function validateRegistrationDetails() {
	console.log("inside register valid");
	var name = document.forms["registrationform"]["name"].value;
	var email = document.forms["registrationform"]["email"].value;
	var pass = document.forms["registrationform"]["pass"].value;
	var deg = document.forms["registrationform"]["deg"].value;

	if (name == "") {

		alert("Username cannot be blank");
		return false;
	}
	if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {
		alert("Enter valid email address");
		return false;
	}
	if (pass == "") {
		alert("Password cannot be blank");
		return false;
	}
	if (deg == "") {
		alert("Please select desiganation");
		return false;
	}

}