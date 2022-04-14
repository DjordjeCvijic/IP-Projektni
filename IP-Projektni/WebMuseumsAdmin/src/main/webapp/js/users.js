function selectChance(selectId){
	console.log(selectId);
	var button=document.getElementById(selectId);
    button.disabled=false;
}


function saveUserStatus(selectId,userId){
    var selectedValue=document.getElementById(selectId).value;
    console.log(selectId);
    console.log(userId);

    window.location.assign("users.jsp?userId="+userId+"&statusId="+selectedValue);
}

function goBack(){
	window.location.assign("admin-home.jsp");
}
function resetPassword(userId,username){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if((request.readyState==4)&&(request.status==200)){
           
        }
    }

    request.open("GET","http://localhost:1123/user-info/change-password?userId="+userId,true);
    request.send(null);
     document.getElementById("informations").innerHTML="";
    document.getElementById("informations").innerHTML="User "+username+" has a new password";
}