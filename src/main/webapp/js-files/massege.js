
function closeNotification(){
	setTimeout(()=>{
		const notificationBox= document.querySelector('#notificationBox');
		if(notificationBox!=null)
		 notificationBox.style.display="none";
	},500);
}

window.onload=function(){
    setTimeout(closeNotification,10000);
}
const closeBtn= document.querySelector('#closeBtn');
if(closeBtn!=null){
closeBtn.addEventListener('click',closeNotification);
}