
function closeNotification(){
	setTimeout(()=>{
		document.querySelector('#notificationBox').style.display="none";
	},500);
}

window.onload=function(){
    setTimeout(closeNotification,10000);
}
document.querySelector('#closeBtn').addEventListener('click',closeNotification);