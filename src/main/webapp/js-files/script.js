
// Prevent page reload
const doctorLink = document.getElementById("doc");

doctorLink.addEventListener("click", (e) => {
    e.preventDefault();
});

const menuIcon=document.querySelector('#menuIcon');
 

  const doctorTypes = document.getElementById("doctorTypes");
  const navbar = document.querySelector('.navbar');
	let showNav=false;
	let showDoc=false;

document.addEventListener('click',(e)=>{
	if(showNav){
			navbar.style.display='none';	
			showNav=false;
		}else if(e.target.id=="menuIcon"){		
			navbar.style.display='flex';
			showNav=true;		
		}
	
	if(showDoc){
		doctorTypes.classList.add("doctorHide");
		doctorTypes.classList.remove("doctorShow");		
		showDoc=false;
	}else if(e.target.id=="doc"){
		doctorTypes.classList.remove("doctorHide");
		doctorTypes.classList.add("doctorShow");
		showDoc=true;		
	}
	 
})



