// Custom JS functions for Illuminate Gym 

function clearFormField(formfield) {
	
	formfield.className += " darker";
	
	if (formfield.defaultValue == formfield.value) {
		formfield.value = "";
	}
}

function formatPhone(elem) {
	var phonenum = elem.value;
    var regexObj = /^(?:\+?1[-. ]?)?(?:\(?([0-9]{3})\)?[-. ]?)?([0-9]{3})[-. ]?([0-9]{4})$/;
    if (regexObj.test(phonenum)) {
        var parts = phonenum.match(regexObj);
        var phone = "";
        if (parts[1]) { phone += "+1 (" + parts[1] + ") "; }
        phone += parts[2] + "-" + parts[3];
        elem.value = phone;
    }
    else {
        elem.value = 'invalid';
    }
}
