
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
			document.querySelector("#password").disabled = false;
            document.querySelector("#email").disabled = false;
            clearInterval(timerId);
        }
    }, 1000)
}
const actions = {
    sendOTP: sendOTP,
    verifyOTP: verifyOTP,
};

document.addEventListener('click', (e) => {
    const action = e.target.dataset.action;
    if (action && actions[action]) {
        actions[action](e);
    }
})


function sendOTP(e) {
    let adminName = document.querySelector('#username').value.trim();
	let password = document.querySelector('#password').value.trim();
    let email = document.querySelector('#email').value.trim();
    if (adminName != "" && email != "" && password!="") {
        if (email.includes('@') && email.includes('.')) {
			fetch("admin_verification", {
			    method: "post",
			    headers: { "Content-type": "application/x-www-form-urlencoded" },
			    body: "adminName=" + adminName + "&password="+password + "&email=" + email
			}).then(res => res.text()).then(data => {
			    if (data != null && data == "send") {
					
					notificationMsg.innerText ="OTP hash been sent to Email : "+email +"." +
										         " Please check Spam folder also. ";
								
			        document.querySelector('#OTPSection').classList.remove('nn');
			        e.target.style.display = 'none';
					document.querySelector('#username').disabled = true;
					document.querySelector("#password").disabled = true;
					document.querySelector("#email").disabled = true;
			        time = 300;
			        runTimer();
			        timer.classList.remove('nn');
			    } else if(data != null && data == "sended"){
					notificationMsg.innerText ="OTP all ready sended on your email. please check your email or try after some time. ";
					document.querySelector('#OTPSection').classList.remove('nn');
					document.querySelector('#username').disabled = true;
					document.querySelector("#password").disabled = true;
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
			notificationMsg.innerText = "enter valid phone number";
        }
    }
    else {
        notificationMsg.innerText = "please fill all field first";
    }

    notificationBox.classList.remove("nn");
    notificationBox.classList.add("notificationBox");
    closeAfter();

}

function verifyOTP() {
    let otp = document.querySelector('#otp').value.trim();
    if (otp.length == 6) {
		
		document.querySelector('#username').disabled = false;
		document.querySelector("#email").disabled = false;
		let adminName = document.querySelector('#username').value.trim();
		   let email = document.querySelector('#email').value.trim();
		   document.querySelector('#username').disabled = true;
		   document.querySelector("#email").disabled = true;
         
        fetch("verifyOTP", {
            method: "post",
            headers: { "Content-type": "application/x-www-form-urlencoded" },
            body:"adminName="+ adminName + "&otp=" + otp +"&email="+email
        }).then(res => res.text()).then(data => {
            if (data == "verified") {

                notificationMsg.innerText = "OTP Verified";

                clearInterval(timerId);
                timer.classList.add('nn');

                document.querySelector('#OTPSection').classList.add('nn');
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



