function validateUsername(){
    const usernameInput = document.getElementById("username").value;
    const username_regex = /^[a-zA-Z0-9_]{6,20}$/;
    return username_regex.test(usernameInput);
}

function validateEmail()
{
    const emailInput = document.getElementById("email").value;
    const email_regex = /^[\w.%+-]+@[\w.-]+\.[A-Za-z]{2,}$/;
    return email_regex.test(emailInput);
}

function validatePassword()
{
    const passwordInput = document.getElementById("password").value;
    const password_regex = /^(?=.*[\W_])(?!.*\s).{8,20}$/;
    return password_regex.test(passwordInput);
}

function handleUsernameInput()
{
    const usernameInput = document.getElementById("username").value;
    const usernameElement = document.getElementById("username");

    usernameElement.classList.remove("invalid-input");

    if(usernameInput.length > 0)
    {
        const isValid = validateUsername();
        console.log(isValid);

        if(isValid)
        {
            usernameElement.classList.remove("invalid-input");
            usernameElement.classList.add("valid-input");
        }
        else
        {
            usernameElement.classList.add("invalid-input");
            usernameElement.classList.remove("valid-input");
        }
    }
}

function handleEmailInput()
{
    const emailInput = document.getElementById("email").value;
    const emailElement = document.getElementById("email");

    emailElement.classList.remove("invalid-input");

    if(emailInput.length > 0)
    {
        const isValid = validateEmail();
        console.log(isValid);

        if(isValid)
        {
            emailElement.classList.remove("invalid-input");
            emailElement.classList.add("valid-input");
        }
        else
        {
            emailElement.classList.add("invalid-input");
            emailElement.classList.remove("valid-input");
        }
    }
}

function handlePasswordInput()
{
    const passwordInput = document.getElementById("password").value;
    const passwordElement = document.getElementById("password");

    passwordElement.classList.remove("invalid-input");

    if(passwordInput.length > 0)
    {
        const isValid = validatePassword();
        console.log(isValid);

        if(isValid)
        {
            passwordElement.classList.remove("invalid-input");
            passwordElement.classList.add("valid-input");
        }
        else
        {
            passwordElement.classList.add("invalid-input");
            passwordElement.classList.remove("valid-input");
        }
    }
}

function comparePassword()
{
    const password = document.getElementById("password").value;
    const confirm_password = document.getElementById("confirm-password").value;
    const confirm_password_element = document.getElementById("confirm-password");

    if(password === confirm_password)
    {
        confirm_password_element.classList.remove("invalid-input");
        confirm_password_element.classList.add("valid-input");
    }
    else
    {
        confirm_password_element.classList.add("invalid-input");
        confirm_password_element.classList.remove("valid-input");
    }
}