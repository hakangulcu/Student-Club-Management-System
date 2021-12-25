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
var currentID;




const getLoginResult = () => {
  axios.get('https://projectdeneme.herokuapp.com/clubManagers/loginPasswordCheck/' + username.value + '/' + pass.value).then(function (response) {
  console.log(response);
  console.log(response.data);
  if(response.data === true){
    getID(username.value);

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
    console.log(response.data);
    currentID = response.data;
    console.log(currentID);


  console.log(currentID);
  axios.get('https://projectdeneme.herokuapp.com/clubManagers/getClub/' + currentID).then(function(response) {
    console.log(response);
    var clubId = "" + response.data.id;
    console.log(typeof(clubId));
    console.log(clubId);
    sessionStorage.setItem("clubId", clubId );

  })
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

