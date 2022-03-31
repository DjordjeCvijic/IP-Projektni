function getCountry(){
	var request=new XMLHttpRequest();

    request.onreadystatechange=function(){
        if((request.readyState==4)&&(request.status==200)){
            var result=JSON.parse(request.responseText);


            var select=document.getElementById("country_select");
            result.forEach(element => {
                var option=document.createElement("option");
                option.text=element.name.common;
                option.value=element.cca2;
                select.add(option);
            });
        }
    }

    request.open("GET","https://restcountries.com/v3.1/region/europe",true);
    request.send(null);

}

function getRegion(){
    selectedCountry = document.getElementById("country_select").value;
   console.log("usao u get refion od zemlje",selectedCountry);

   var request=new XMLHttpRequest();
   request.onreadystatechange=function(){
       if((request.readyState==4)&&(request.status==200)){
           var result=JSON.parse(request.responseText)

           var select=document.getElementById("region_select");
        
           result.forEach(element => {
               var option=document.createElement("option");
               option.value=element.region;
               option.text=element.region;
               select.add(option);
           });
       }
   }

   request.open("GET","http://battuta.medunes.net/api/region/"+selectedCountry+"/all/?key=653c9ff668e214b2cc4187e30e531ceb",true);
   request.send(null);

   
}