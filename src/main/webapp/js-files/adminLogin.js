/**
 * 
 */let notificationBox = document.querySelector('#notificationBox');
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
};

document.addEventListener('click', (e) => {
    const action = e.target.dataset.action;
    if (action && actions[action]) {
        actions[action](e);
    }
})


function sendOTP(e) {
    let username = document.querySelector('#username').value.trim();
	let password = document.querySelector('#password').value.trim();
    let phone = document.querySelector('#phoneNo').value.trim();
    if (username != "" && phone != "" && password!="") {
        if (phone.length != 10) {
            notificationMsg.innerText = "enter valid phone number";
        }
        else {
            fetch("admin_verification", {
                method: "post",
                headers: { "Content-type": "application/x-www-form-urlencoded" },
                body: "username=" + username + "&password="+password + "&phone=" + phone
            }).then(res => res.text()).then(data => {
                if (data != null && data == "send") {
					
					notificationMsg.innerText ="OTP sent to phone no. "+phone;
								
                    document.querySelector('#OTPSection').classList.remove('nn');
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
        notificationMsg.innerText = "please fill all field first";
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



