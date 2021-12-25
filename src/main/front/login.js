
let tab = document.querySelector(".tab-form");
let tabHeader = tab.querySelector(".tab-header");
let tabHeaderElements = tab.querySelectorAll(".tab-header > div");
let tabBody = tab.querySelector(".tab-body");
let tabBodyElements = tab.querySelectorAll(".tab-body > div");

for(let i=0;i<tabHeaderElements.length;i++){
  tabHeaderElements[i].addEventListener("click",function(){
    tabHeader.querySelector(".active").classList.remove("active");
    tabHeaderElements[i].classList.add("active");
    tabBody.querySelector(".active").classList.remove("active");
    tabBodyElements[i].classList.add("active");
  });
}

function validate(){
    var username = document.getElementById("userMail");
    var password = document.getElementById("password");
}

const getDataCreateActivity = () => {
  console.log("salkjdsakjdsakj");
  axios.get('https://projectdeneme.herokuapp.com/activities/addNewActivity').then(function (response) {
      console.log(response);

  })

      .catch(function (error) {
          // handle error
          console.log(error);
      }
      )
}
/** 
function createCookie(name,pwds){
  let mail = document.getElementById("userMail");
  let pwd = document.getElementById("password");


  today = new Date();
  var expire = new Date();
  expire.setTime(today.getTime() + 3600000*24*15);
 

  document.cookie = "name="+mail.value+";path=/" + ";expires="+expire.toUTCString();
  document.cookie = "password="+encodeURI(pwd.value)+";path=/" + ";expires="+expire.toUTCString();
  //can only write one entity at a time (name, pass)
}  


//event handler for page load - runs on every refresh
window.onload = function(){

  //for now
  var uname = 'berk@hotmail.com';
  var pass = 'hakan123';

  document.getElementById('user').value = uname;
  document.getElementById('pd').value = pass;

}

*/