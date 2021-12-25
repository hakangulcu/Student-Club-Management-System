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

var username = document.getElementById("userMail");
var pass = document.getElementById("password");
var login = document.getElementById("login");
var userIDcookie;
var currentID;
var now = new Date();
now.setMonth(now.getMonth()+1);


const getLoginResult = () => {
  axios.get('https://projectdeneme.herokuapp.com/clubManagers/loginPasswordCheck/' + username.value + '/' + pass.value).then(function (response) {
  console.log(response);
  console.log(response.data);
  if(response.data === true){
    //createCookie(username.value, pass.value);
    getID(username.value);
    document.cookie = "name="+userIDcookie +";path=/" + ";expires="+expire.toUTCString();
    document.location.href = "ClubManagerMainPage.html";
  }
  else{
    alert("E-mail or password is wrong!")
  }
  })
  .catch(function (error) {
  // handle error
  console.log(error);
  });
};


function getID(usern){
  axios.get('https://projectdeneme.herokuapp.com/clubManagers/getClubManagerIdByEmail/' + usern).then(function(response){
    console.log(response);
    currentID = response.data;
    userIDcookie = currentID;
  })
  .catch(function (error) {
    // handle error
    console.log(error);
    });
    
  };

 
  //document.cookie = "name="+name.value+";path=/" + ";expires="+expire.toUTCString();
  //document.cookie = "password="+encodeURI(pwd.value)+";path=/" + ";expires="+expire.toUTCString();
  //can only write one entity at a time (name, pass)


login.addEventListener('click', getLoginResult);

