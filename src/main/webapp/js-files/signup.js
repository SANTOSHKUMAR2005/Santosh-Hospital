const timer=document.querySelector('#timer');
let time;
let timerId;

function runTimer(){
	timerId=setInterval(function(){
		timer.innerText=time;
		time--;
		if(time<0){
			timer.classList.add('nn');
			document.querySelector('#OTPSection').classList.add('nn'); 
			document.querySelector('#sendOTP').style.display='inline';
			document.querySelector('#username').disabled=false;
			document.querySelector("#phoneNo").disabled=false;
			clearInterval(timerId);
		}
	},1000)
}
const actions={
	sendOTP: sendOTP,
	verifyOTP: verifyOTP,
};

document.addEventListener('click',(e)=>{
	const action=e.target.dataset.action;
	if(action && actions[action]){
		actions[action](e);
	}
})
 

function sendOTP(e){
	let username=document.querySelector('#username').value.trim();
	let phone=document.querySelector('#phoneNo').value.trim();
	if(username!="" && phone!=""){
		if(phone.length!=10){
			alert("enter valid phone number");
			return;
		}
		fetch("sendOTPServlet",{
				method:"post",
				headers:{"Content-type":"application/x-www-form-urlencoded"},
				body:"username="+username+"&phone="+phone 
			}).then(res=>res.text()).then(data=>{
				if(data!=null && data=="send"){
		          document.querySelector('#OTPSection').classList.remove('nn');
				  document.querySelector('#username').disabled=true;
				  document.querySelector("#phoneNo").disabled=true;
				  e.target.style.display='none'; 
				  time=20;
				  runTimer();
				  timer.classList.remove('nn');
				}else{
					alert("OTP generation failed please resend OTP");
					documen.querySelector('#sendOTP').style.display="inline";
				}
			}) 
	}
	else{
		alert("username or pnone no should not be null");
	}
	
}

function verifyOTP(){
	let otp=document.querySelector('#otp').value.trim();
	if(otp.length==6){
		
		fetch("verifyOTP",{
			method:"post",
			headers:{"Content-type":"application/x-www-form-urlencoded"},
			body:"otp="+otp
		}).then(res=>res.text()).then(data=>{
			if(data=="verified"){
				alert("OTP Verified");
				
				
				clearInterval(timerId);
				timer.classList.add('nn');
				
				document.querySelector('#OTPSection').classList.add('nn');
				document.querySelector('#passwordSection').classList.remove('nn');
				document.querySelector('#signInButton').classList.remove('nn');	
			}else{
				alert(data);
			}
		})
		
	}else{
		alert("plese enter valied OTP");
	}	
}



