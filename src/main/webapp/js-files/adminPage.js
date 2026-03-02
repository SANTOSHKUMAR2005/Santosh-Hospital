/**
 * 
 */
document.addEventListener('DOMContentLoaded',()=>{
    
const doctorAdd=document.querySelector("#AddDoc");
var RemoveDoc=document.querySelector('#RemoveDoc');
var changePass=document.querySelector('#changePass');
var changeAdm=document.querySelector('#changeAdm');
var doctorAddF=document.querySelector('#doctorAddF');
var doctorRemoveF=document.querySelector('#doctorRemoveF');
var changeAdminPass=document.querySelector('#changeAdminPass');
var changeAdmin=document.querySelector('#changeAdmin');

doctorAdd.addEventListener('click',()=>{
doctorAddF.classList.toggle('fl');
doctorAddF.classList.toggle('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

changeAdmin.classList.remove('fl');
changeAdmin.classList.add('nn');

})

RemoveDoc.addEventListener('click',()=>{
doctorRemoveF.classList.toggle('remove');
doctorRemoveF.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

changeAdmin.classList.remove('fl');
changeAdmin.classList.add('nn');

})

changePass.addEventListener('click',()=>{
changeAdminPass.classList.toggle('changePassword');
changeAdminPass.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

changeAdmin.classList.remove('fl');
changeAdmin.classList.add('nn');

})

changeAdm.addEventListener('click',()=>{
changeAdmin.classList.toggle('fl');
changeAdmin.classList.toggle('nn');

doctorAddF.classList.remove('fl');
doctorAddF.classList.add('nn');

doctorRemoveF.classList.remove('remove');
doctorRemoveF.classList.add('nn');

changeAdminPass.classList.add('nn');
changeAdminPass.classList.remove('changePassword');

})



})


