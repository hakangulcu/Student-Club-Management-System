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




const getLoginResult2 = () => {
  axios.get('https://projectdeneme.herokuapp.com/students/loginPasswordCheck/' + username.value + '/' + pass.value).then(function (response) {
  console.log(response);
  console.log(response.data);
  if(response.data === true){
    getID(username.value);

   document.location.href = "MainPageS.html";
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

  axios.get('https://projectdeneme.herokuapp.com/students/getStudentIdByEmail/' + usern).then(function(response){
    console.log(response.data);
    currentID = response.data;
    console.log(currentID);


  console.log(currentID);
  sessionStorage.setItem("studentID", currentID );

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

