function validateForm() {
    var fields = [document.forms["Form"]["date"], document.forms["Form"]["calories"]];
    var message = 'Field(s) cannot be empty: ';
    var isValid = true;
    for (var i = 0; i < fields.length; i++) {
        if (fields[i].value === "") {
            isValid = false;
            message += fields[i].name += ' ';
        }
    }
    if (!isValid) {
        alert(message);
        return isValid;
    }
}