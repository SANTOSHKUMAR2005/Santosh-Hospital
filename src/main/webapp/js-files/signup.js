let notificationBox = document.querySelector('#notificationBox');
let notificationMsg = document.querySelector('#notificationMsg');

function closeNotification() {
    setTimeout(() => {
        notificationBox.classList.add("nn");
        notificationBox.classList.remove("notificationBox");
    }, 500);
}

document.querySelector('#closeBtn').addEventListener('click', closeNotification);

function closeAfter() {
    setTimeout(closeNotification, 5000);
}

const timer = document.querySelector('#timer');
let time;
let timerId;

function runTimer() {
    timerId = setInterval(function() {
        timer.innerText = time;
        time--;
        if (time < 0) {
            timer.classList.add('nn');
            document.querySelector('#OTPSection').classList.add('nn');
            document.querySelector('#sendOTP').style.display = 'inline';
            document.querySelector('#username').disabled = false;
            document.querySelector("#phoneNo").disabled = false;
            clearInterval(timerId);
        }
    }, 1000)
}
const actions = {
    sendOTP: sendOTP,
    verifyOTP: verifyOTP,
    SignIn: SignIn
};

document.addEventListener('click', (e) => {
    const action = e.target.dataset.action;
    if (action && actions[action]) {
        actions[action](e);
    }
})


function sendOTP(e) {
    let username = document.querySelector('#username').value.trim();
    let phone = document.querySelector('#phoneNo').value.trim();
    if (username != "" && phone != "") {
        if (phone.length != 10) {
            notificationMsg.innerText = "enter valid phone number";
        }
        else {
            fetch("sendOTPServlet", {
                method: "post",
                headers: { "Content-type": "application/x-www-form-urlencoded" },
                body: "username=" + username + "&phone=" + phone
            }).then(res => res.text()).then(data => {
                if (data != null && data == "send") {
					
					notificationMsg.innerText ="OTP sent to phone no. "+phone;
					
                    document.querySelector('#OTPSection').classList.remove('nn');
                    document.querySelector('#username').disabled = true;
                    document.querySelector("#phoneNo").disabled = true;
                    e.target.style.display = 'none';
                    time = 60;
                    runTimer();
                    timer.classList.remove('nn');
                } else {
                    notificationMsg.innerText = data;
                    documen.querySelector('#sendOTP').style.display = "inline";
                }
            })
        }
    }
    else {
        notificationMsg.innerText = "username or pnone no should not be null";
    }

    notificationBox.classList.remove("nn");
    notificationBox.classList.add("notificationBox");
    closeAfter();

}

function verifyOTP() {
    let otp = document.querySelector('#otp').value.trim();
    if (otp.length == 6) {

        fetch("verifyOTP", {
            method: "post",
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body: "otp=" + otp
        }).then(res => res.text()).then(data => {
            if (data == "verified") {

                notificationMsg.innerText = "OTP Verified";

                clearInterval(timerId);
                timer.classList.add('nn');

                document.querySelector('#OTPSection').classList.add('nn');
                document.querySelector('#passwordSection1').classList.remove('nn');
                document.querySelector('#passwordSection2').classList.remove('nn');
                document.querySelector('#signInButton').classList.remove('nn');
            } else {
                notificationMsg.innerText = data;
            }
        })

    } else {
        notificationMsg.innerText = "plese enter valied OTP";
    }

    notificationBox.classList.remove("nn");
    notificationBox.classList.add("notificationBox");
    closeAfter();
}

function SignIn() {
    const password = document.querySelector('#pass').value.trim();
    const confirmPass = document.querySelector('#Cpass').value.trim();
    if (password.length < 6) {
        notificationMsg.innerText = "password should have at least 6 digit";
    }
    else if (confirmPass != password) {
        notificationMsg.innerText = "confirm password not matched with original password .";
    } else {

        let username = document.querySelector('#username');
        let phone = document.querySelector("#phoneNo");
        username.disabled = false;
        phone.disabled = false;

        username = username.value.trim();
        phone = phone.value.trim();

        fetch("Signup", {
            method: "post",
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body: "username=" + username + "&password=" + password + "&phone=" + phone
        }).then(res => res.text()).then(data => {
            if (data == "successful") {
                notificationMsg.innerText = "you have singned up successfylly : login now";
				setTimeout(()=>{
					window.location.href = "login";
				} , 1500);
            } else {
                notificationMsg.innerText = data;
            }
        })
    }

    notificationBox.classList.remove("nn");
    notificationBox.classList.add("notificationBox");
    closeAfter();
}

