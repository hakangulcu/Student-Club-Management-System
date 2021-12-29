const pastact = document.getElementById("pastact1");
const upact = document.getElementById("upact1");
const studentID = localStorage.getItem("studentId");
console.log(studentID);

const getData = () => {

    console.log("getData");
    console.log(studentID);
    console.log(typeof (studentID));
    console.log(localStorage);
    axios.get('https://projectdeneme.herokuapp.com/students/listAllActivities/' + studentID)
        .then(function (response) {
            let today = new Date();
            console.log(response);

            for (let i = 0; i < response.data.length; i++) {
                let clubs = response.data[i].organizerClubList;
                let clubNamesList = "";

                for(let j = 0; j < clubs.length; j++) {
                    clubNamesList += clubs[j].clubName;
                }

                let activityDate = response.data[i].date;
                let activityName = response.data[i].activityName;
                let activityID = response.data[i].id;

                let line31 = document.createElement('line31');
                line31.innerHTML += '<u1 class="list-group list-group-horizontal mb-3">'
                    + '<li class="list-group-item col-lg-3 col-sm-2 col-md-2 col-4" style="border: none"> ' + clubNamesList
                    + '</li><li class="list-group-item col-lg-3 col-sm-2 col-md-2 col-4" style="border: none"> ' + activityName
                    + '</li><li class="list-group-item col-lg-3 col-sm-2 col-md-2" style="border: none">' +
                    '<button type="button" class="btn btn-danger btn-outline-dark " style="color: white">Show</button></li>' +
                    '<button onclick="removeStudentFromActivity('+studentID+ ','+activityID+')" type="button" class="btn btn-danger btn-outline-dark " style="color: white">Leave</button></u1>';

                if (activityDate > today) {
                    pastact.appendChild(line31);
                } else {
                    upact.appendChild(line31);
                }
            }
        })
        .catch(function (error) {
            console.log(error);
        })
};

function removeStudentFromActivity(studentID, activityID) {
    axios.put("https://projectdeneme.herokuapp.com/students/deleteActivityFromStudent/" + studentID + "/" + activityID)
        .then(function (response) {
            document.location.href = "MainPageS.html";
            alert("student has left activity");
        })
        .catch(function (error) {
            console.log(error);
        })
}

