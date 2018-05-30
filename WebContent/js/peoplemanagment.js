$(function() {
	$("#menu").menu();
});

$(document).ready(function() {
	$("input").focus(function() {
		$(this).css("background-color", "#D8D8D8");
	});
	$("input").blur(function() {
		$(this).css("background-color", "#ffffff");
	});
});

function trim(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g, "");
}

function validateLoginForm() {
	var User_id = document.forms["loginForm"]["User_id"].value;
	var User_pswd = document.forms["loginForm"]["User_pswd"].value;
	var msg = "";
	if (User_id == null || User_id == "") {
		msg = msg + "User id must be filled out. \r\n";
	}
	if (User_pswd == null || User_pswd == "") {
		msg = msg + "Password must be filled out. \r\n";
	}
	document.forms["loginForm"]["actionHidden"].value = "login";
	document.forms["loginForm"]["errorMsg"].value = msg;
	document.getElementById("loginForm").submit();
}

function validateForgetPasswordForm() {
	var boolean = false;
	var msg = "";
	var User_id = trim(document.forms["ForgetPasswordForm"]["user_id"].value);
	if (User_id == null || User_id == "") {
		boolean = true;
		msg = msg + "User id must be filled out. \r\n";
	}
	var User_name = trim(document.forms["ForgetPasswordForm"]["user_name"].value);
	if (User_name == null || User_name == "") {
		boolean = true;
		msg = msg + "User name must be filled out. \r\n";
	}

	if (boolean == true) {
		alert(msg);
		return false;
	}
	if (boolean == false) {
		document.forms["ForgetPasswordForm"]["actionHidden"].value = "forgetPassword";
		document.getElementById("ForgetPasswordForm").submit();
	}
}

function validateRegistrationForm() {
	var boolean = false;
	var msg = "";
	var User_id = trim(document.forms["RegistrationForm"]["user_id"].value);
	if (User_id == null || User_id == "") {
		boolean = true;
		msg = msg + "User id must be filled out. \r\n";
	}
	var User_name = trim(document.forms["RegistrationForm"]["user_name"].value);
	if (User_name == null || User_name == "") {
		boolean = true;
		msg = msg + "User name must be filled out. \r\n";
	}
	var User_pswd = trim(document.forms["RegistrationForm"]["password"].value);
	if (User_pswd == null || User_pswd == "") {
		boolean = true;
		msg = msg + "Password must be filled out. \r\n";
	}
	var cnfrim_pswd = trim(document.forms["RegistrationForm"]["confirm_password"].value);
	if (cnfrim_pswd == null || cnfrim_pswd == "") {
		boolean = true;
		msg = msg + "Confirm password must be filled out. \r\n";
	}
	var User_address1 = trim(document.forms["RegistrationForm"]["address1"].value);
	if (User_address1 == null || User_address1 == "") {
		boolean = true;
		msg = msg + "Address line1 must be filled out. \r\n";
	}
	var User_address2 = trim(document.forms["RegistrationForm"]["address2"].value);
	if (User_address2 == null || User_address2 == "") {
		boolean = true;
		msg = msg + "Address line2 must be filled out. \r\n";
	}
	var User_email = trim(document.forms["RegistrationForm"]["email"].value);
	if (User_email == null || User_email == "") {
		boolean = true;
		msg = msg + "Email must be filled out. \r\n";
	} else {
		var error = checkEmail(User_email);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_phone = trim(document.forms["RegistrationForm"]["phone"].value);
	if (User_phone != null || User_phone != "") {
		var error = checkPhoneNumber(User_phone);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_mobile = trim(document.forms["RegistrationForm"]["mobile"].value);
	if (User_mobile == null || User_mobile == "") {
		boolean = true;
		msg = msg + "Mobile must be filled out. \r\n";
	} else {
		var error = checkMobileNumber(User_mobile);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}
	var User_dob = trim(document.forms["RegistrationForm"]["dob"].value);
	if (User_dob == null || User_dob == "") {
		boolean = true;
		msg = msg + "Date of birth must be filled out. \r\n";
	} else {
		var error = validateDate(User_dob);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}
	var User_genderM = document.forms["RegistrationForm"]["genderM"].checked;
	var User_genderF = document.forms["RegistrationForm"]["genderF"].checked;
	if (User_genderM == false && User_genderF == false) {
		boolean = true;
		msg = msg + "Gender must be filled out. \r\n";
	}
	var User_nationality = trim(document.forms["RegistrationForm"]["nationality"].value);
	if (User_nationality == null || User_nationality == "") {
		boolean = true;
		msg = msg + "Nationality must be filled out. \r\n";
	}

	var password = trim(document.forms["RegistrationForm"]["password"].value);
	var confirm_password = trim(document.forms["RegistrationForm"]["confirm_password"].value);
	alert(password + " : " + confirm_password);
	if (password != null && password != "" && confirm_password != null
			&& confirm_password != "") {
		var error = checkConfimPasssword(password, confirm_password);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}
	if (boolean == true) {
		alert(msg);
		return false;
	}

	if (boolean == false) {
		document.forms["RegistrationForm"]["actionHidden"].value = "registration";
		document.getElementById("RegistrationForm").submit();
	}
}

function setSearchHiddenData() {
	document.forms["SearchForm"]["actionHidden"].value = "search";
	document.getElementById("SearchForm").submit();
}

function checkEmailAddress() {
	var email = trim(document.forms["RegistrationForm"]["email"].value);
	var atPosition = email.indexOf("@");
	var dotPosition = email.lastIndexOf(".");
	var error = "";
	if (atPosition < 1 || dotPosition < atPosition + 2
			|| dotPosition >= email.length) {
		error = "Please provide a valid email address.  \r\n";
		return error;
	}
}

function checkEmail(email) {
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var error = "";
	if (!filter.test(email)) {
		error = "Please provide a valid email address  \r\n";
		return error;
	}
}

function checkMobileNumber(mobile) {
	var filter = /^\d{10}$/;
	var error = "";
	if (!filter.test(mobile)) {
		error = "Enter the valid Mobile Number(Like : 9566137117). \r\n ";
		return error;
	}
}

function validateDate(dob) {
	var filter = /^([0-9]{4})\/([0-9]{2})\/([0-9]{2})$/;
	var error = "";
	if (!filter.test(dob)) {
		error = "Enter a valid date. \r\n ";
		return error;
	}

	var year = dob.split("/")[0];
	var month = dob.split("/")[1];
	var day = dob.split("/")[2];
	var dayobj = new Date(year, month - 1, day);
	if ((dayobj.getMonth() + 1 != month) || (dayobj.getDate() != day)
			|| (dayobj.getFullYear() != year)) {
		error = "Invalid Day, Month, or Year range detected.  \r\n";
		return error;
	}
}

function checkPhoneNumber(phone) {
	var filter = /^(\d{1,5})(\d{6,11})$/;
	var error = "";
	if (!filter.test(phone)) {
		error = "Enter a valid phone number. \r\n ";
		return error;
	}
}

function checkConfimPasssword(password, confirm_password) {
	var error = "";
	alert(password + " : " + confirm_password);
	if (password != confirm_password) {
		error = "Password do not match. \r\n ";
		return error;
	}
}

function validateResetPasswordForm() {
	var boolean = false;
	var msg = "";
	var User_id = trim(document.forms["ResetPasswordForm"]["user_id"].value);
	if (User_id == null || User_id == "") {
		boolean = true;
		msg = msg + "User id must be filled out. \r\n";
	}
	var User_name = trim(document.forms["ResetPasswordForm"]["user_name"].value);
	if (User_name == null || User_name == "") {
		boolean = true;
		msg = msg + "User name must be filled out. \r\n";
	}

	var User_pswd = trim(document.forms["ResetPasswordForm"]["old_password"].value);
	if (User_pswd == null || User_pswd == "") {
		boolean = true;
		msg = msg + "Old password must be filled out. \r\n";
	}
	
	var User_pswd = trim(document.forms["ResetPasswordForm"]["new_password"].value);
	if (User_pswd == null || User_pswd == "") {
		boolean = true;
		msg = msg + "New password must be filled out. \r\n";
	}
	if (boolean == true) {
		alert(msg);
		return false;
	}
	if (boolean == false) {
		document.forms["ResetPasswordForm"]["actionHidden"].value = "resetPassword";
		document.getElementById("ResetPasswordForm").submit();
	}
}

function validateModifyForm() {
	var boolean = false;
	var msg = "";	
	var User_address1 = trim(document.forms["ModifyForm"]["address1"].value);	
	if (User_address1 == null || User_address1 == "") {
		boolean = true;
		msg = msg + "Address line1 must be filled out. \r\n";		
	}

	var User_address2 = trim(document.forms["ModifyForm"]["address2"].value);
	if (User_address2 == null || User_address2 == "") {
		boolean = true;
		msg = msg + "Address line2 must be filled out. \r\n";
	}

	var User_email = trim(document.forms["ModifyForm"]["email"].value);
	if (User_email == null || User_email == "") {
		boolean = true;
		msg = msg + "Email must be filled out. \r\n";
	} else {
		var error = checkEmail(User_email);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_phone = trim(document.forms["ModifyForm"]["phone"].value);
	if (User_phone != null || User_phone != "") {
		var error = checkPhoneNumber(User_phone);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_mobile = trim(document.forms["ModifyForm"]["mobile"].value);
	if (User_mobile == null || User_mobile == "") {
		boolean = true;
		msg = msg + "Mobile must be filled out. \r\n";
	} else {
		var error = checkMobileNumber(User_mobile);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_dob = trim(document.forms["ModifyForm"]["dob"].value);
	if (User_dob == null || User_dob == "") {
		boolean = true;
		msg = msg + "Date of birth must be filled out. \r\n";
	} else {
		var error = validateDate(User_dob);
		if (error != null && error != "") {
			boolean = true;
			msg = msg + error;
		}
	}

	var User_genderM = document.forms["ModifyForm"]["genderM"].checked;
	var User_genderF = document.forms["ModifyForm"]["genderF"].checked;
	if (User_genderM == false && User_genderF == false) {
		boolean = true;
		msg = msg + "Gender must be filled out. \r\n";
	}

	var User_nationality = trim(document.forms["ModifyForm"]["nationality"].value);
	if (User_nationality == null || User_nationality == "") {
		boolean = true;
		msg = msg + "Nationality must be filled out. \r\n";
	}

	if (boolean == true) {
		alert(msg);
		return false;
	}

	if (boolean == false) {
		document.forms["ModifyForm"]["actionHidden"].value = "modify";
		document.getElementById("ModifyForm").submit();
	}
}