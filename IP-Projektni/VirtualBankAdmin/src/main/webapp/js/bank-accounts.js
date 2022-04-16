function selectChance(selectId){
	var button=document.getElementById(selectId);
    button.disabled=false;
}

function saveBankAccountStatus(selectId,bankAccountId){
    var selectedValue=document.getElementById(selectId).value;
	window.location.assign("?action=saveStatus&selectedValue="+selectedValue+"&bankAccountId="+bankAccountId);

}