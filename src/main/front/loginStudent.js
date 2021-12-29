let tabStudent = document.querySelector(".tab-form");
let tabHeaderStudent = tabStudent.querySelector(".tab-header");
let tabHeaderElementsStudent = tabStudent.querySelectorAll(".tab-header > div");
let tabBodyStudent = tabStudent.querySelector(".tab-body");
let tabBodyElementsStudent = tabStudent.querySelectorAll(".tab-body > div");

for (let i = 0; i < tabHeaderElementsStudent.length; i++) {
    tabHeaderElementsStudent[i].addEventListener("click", function () {
        tabHeaderStudent.querySelector(".active").classList.remove("active");
        tabHeaderElementsStudent[i].classList.add("active");
        tabBodyStudent.querySelector(".active").classList.remove("active");
        tabBodyElementsStudent[i].classList.add("active");
    });
}

let userEmail = document.getElementById("userMail");
let password = document.getElementById("password");
let login = document.getElementById("login");
let signup = document.getElementById("signup_button");

let currentID;
let firstPassword = document.getElementById("firstPassword");
let secondPassword = document.getElementById("secondPassword");

let name = document.getElementById("signup_name");
let email = document.getElementById("signup_email");
let surname = document.getElementById("signup_surname");

function getSignupStudent() {
    // if not equal
    if(firstPassword.value !== secondPassword.value) {
        alert("password is not same");
    }

    else {
        axios.put("https://projectdeneme.herokuapp.com/students/addNewStudent",
            {
                name: name.value,
                surname: surname.value,
                email: email.value,
                password: firstPassword.value
            })
            .then(function () {
                console.log("im adding the student");
                axios.get("https://projectdeneme.herokuapp.com/students/getStudentIdByEmail/" + email.value)
                    .then(function (response) {
                        getID(email.value);
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
            })
            .catch(function (error) {
                console.log(error);
            })
    }
}

function getLoginResultStudent() {
    console.log("get login result student");
    axios.get('https://projectdeneme.herokuapp.com/students/loginPasswordCheck/' + userEmail.value + '/' + password.value)
        .then(function (response) {
            if (response.data === true) {
                getID(userEmail.value);
            } else {
                alert("E-mail or password is wrong!");
            }
        })
        .catch(function (error) {
            // handle error
            console.log(error);
        });
    // alert("get login result student finished");
}

function getID(studentEmail) {
    console.log("in get id");
    // GET http://sessionhost:8080/students/getStudentIdByEmail/{{studentEmail}}
    console.log("student email is " + studentEmail);
    console.log(typeof(studentEmail));

    axios.get('https://projectdeneme.herokuapp.com/students/getStudentIdByEmail/' + studentEmail).then(function (response) {
        console.log("get student id by email");
        currentID = response.data;
        console.log(currentID);
        localStorage.setItem("studentId", currentID);
        // alert("local storage set student id to currentID = " + currentID);
        // alert(localStorage.getItem("studentId"));
        document.location.href = "MainPageS.html";
        // document.location.href = "MainPageS.html";
    })
        .catch(function (error) {
            // handle error
            alert(error);
            console.log(error);
        });
}

login.addEventListener('click', getLoginResultStudent);
signup.addEventListener('click', getSignupStudent);
// document.location.href = "MainPageS.html";