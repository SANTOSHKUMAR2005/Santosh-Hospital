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
        timer.innerText = Math.floor(time/60 )+" : "+time%60;
        time--;
        if (time < 0) {
            timer.classList.add('nn');
            document.querySelector('#OTPSection').classList.add('nn');
            document.querySelector('#sendOTP').style.display = 'inline';
            document.querySelector('#username').disabled = false;
            document.querySelector("#email").disabled = false;
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
    let email = document.querySelector('#email').value.trim();
    if (username != "" && email != "") {
        if (email.includes('@') && email.includes('.') ) {
			
			fetch("sendOTPServlet", {
			    method: "post",
			    headers: { "Content-type": "application/x-www-form-urlencoded" },
			    body: "username=" + username + "&email=" + email
			}).then(res => res.text()).then(data => {
			    if (data != null && data == "send") {
					
					notificationMsg.innerText ="OTP hash been sent to Email : "+email +"." +
					                           " Please check Spam folder also. ";
					
	                document.querySelector('#OTPSection').classList.remove('nn');
			        document.querySelector('#username').disabled = true;
			        document.querySelector("#email").disabled = true;
			        e.target.style.display = 'none';
			        time = 300;
			        runTimer();
			        timer.classList.remove('nn');
			    } else if(data != null && data == "sended"){
					notificationMsg.innerText ="OTP all ready sended on your email. please check your email or try after some time. ";
					document.querySelector('#OTPSection').classList.remove('nn');
					document.querySelector('#username').disabled = true;
					document.querySelector("#email").disabled = true;
					e.target.style.display = 'none';
				}
				else {
			        notificationMsg.innerText = data;
			        documen.querySelector('#sendOTP').style.display = "inline";
			    }
			})

        }
        else {
			notificationMsg.innerText = "enter valid Email address";
        }
    }
    else {
        notificationMsg.innerText = "username or Email  should not be empty";
    }
	notificationBox.classList.add("notificationBox");
    notificationBox.classList.remove("nn");
    closeAfter();

}

function verifyOTP() {
    let otp = document.querySelector('#otp').value.trim();
    if (otp.length == 6) {
		
		document.querySelector("#email").disabled = false;
		let email = document.querySelector('#email').value.trim();
		document.querySelector("#email").disabled = true;
		
        fetch("verifyOTP", {
            method: "post",
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body: "otp=" + otp + "&email="+email
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
        notificationMsg.innerText = "Password not matched.";
    } else {

        let username = document.querySelector('#username');
        let email = document.querySelector("#email");
        username.disabled = false;
        email.disabled = false;

        let usernameVal = username.value.trim();
        let emailVal = email.value.trim();

        fetch("Signup", {
            method: "post",
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body: "username=" + usernameVal + "&password=" + password + "&email=" + emailVal
        }).then(res => res.text()).then(data => {
            if (data == "successful") {
                notificationMsg.innerText = "you have singned up successfylly : login now";
				setTimeout(()=>{
					window.location.href = "login";
				} , 2000);
            } else {
                notificationMsg.innerText = data;
            }
        })
    }

    notificationBox.classList.remove("nn");
    notificationBox.classList.add("notificationBox");
    closeAfter();
}

