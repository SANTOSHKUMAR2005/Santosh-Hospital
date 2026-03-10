/**
 * 
 */
document.addEventListener('DOMContentLoaded',()=>{
const doctorAdd=document.querySelector("#AddDoc");
var RemoveDoc=document.querySelector('#RemoveDoc');
var changePass=document.querySelector('#changePass');
var addAdm=document.querySelector('#addAdm');


var doctorAddF=document.querySelector('#doctorAddF');
var doctorRemoveF=document.querySelector('#doctorRemoveF');
var changeAdminPass=document.querySelector('#changeAdminPass');
var addAdmin=document.querySelector('#addAdmin');

doctorAdd.addEventListener('click',()=>{
doctorAddF.classList.toggle('fl');
doctorAddF.classList.toggle('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

addAdmin.classList.remove('fl');
addAdmin.classList.add('nn');

})

RemoveDoc.addEventListener('click',()=>{
doctorRemoveF.classList.toggle('remove');
doctorRemoveF.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

addAdmin.classList.remove('fl');
addAdmin.classList.add('nn');

})

changePass.addEventListener('click',()=>{
changeAdminPass.classList.toggle('changePassword');
changeAdminPass.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

addAdmin.classList.remove('fl');
addAdmin.classList.add('nn');

})

addAdm.addEventListener('click',()=>{
	
addAdmin.classList.toggle('fl');
addAdmin.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

})



})


