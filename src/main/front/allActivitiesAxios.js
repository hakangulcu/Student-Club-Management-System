const navActivities = document.getElementById("navActivities");
//const axios = require('axios');
//https://projectdeneme.herokuapp.com/activities/listActivities
//const axios = require('axios').default;
let studentID = localStorage.getItem("studentId");


function getData() {
    axios.get('https://projectdeneme.herokuapp.com/activities/listActivities')
        .then(function (response) {
            console.log(response);

            for (let i = 0; i < response.data.length; i++) {
                // let activityClubName = "";
                // if(response.data[i].organizerClubList[0] !== null)

                let activityClubName = response.data[i].organizerClubList[0].clubName;
                let activityName = response.data[i].activityName;
                let activityDate = response.data[i].date;
                let activityPlace = response.data[i].place;
                let activityCapacity = response.data[i].capacity;
                let activityGePoints = response.data[i].ge250Point;
                let activityID = response.data[i].id;

                document.body.innerHTML = document.body.innerHTML + '<ul class="list-group list-group-horizontal mb-2 mt-4 "  >\n' +
                    '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" id="activityClub1" style="border: none"><span id="activityName1"> ' + activityClubName + ' </span> </li>\n' +
                    '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityName1"> ' + activityName + ' </span></li>\n' +
                    '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityDate1"> ' + activityDate + ' </span></li>\n' +
                    '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityPlace1"> ' + activityPlace + ' </span></li>\n' +
                    '      <li class="list-group-item  col-lg-1 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityQuota1"> ' + activityCapacity + '</span></li>\n' +
                    '      <li class="list-group-item  col-lg-1 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityGe1"> ' + activityGePoints + ' </span></li>\n' +
                    '      <li class="list-group-item col-lg-1 col-2 justify-content-center d-none  d-sm-block" style="border: none">\n' +

                    '        <button id="joinButton" type="button" onclick="addActivityToStudent('+studentID+ ',' +activityID+')" class="btn btn-danger btn-outline-dark justify-content-center" style="color: white">Join</button>\n' +

                    '      </li>';

            }

            /*
            axios.get('https://projectdeneme.herokuapp.com/students/getUnattendedActivities/' + studentID)
                .then(function (response) {
                    for(let i = 0; i < response.data.length; i++) {
                        let activityClubName = response.data[i].organizerClubList[0].clubName;
                        let activityName = response.data[i].activityName;
                        let activityDate = response.data[i].date;
                        let activityPlace = response.data[i].place;
                        let activityCapacity = response.data[i].capacity;
                        let activityGePoints = response.data[i].ge250Point;
                        let activityID = response.data[i].id;

                        document.body.innerHTML = document.body.innerHTML + '<ul class="list-group list-group-horizontal mb-2 mt-4 "  >\n' +
                            '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" id="activityClub1" style="border: none"><span id="activityName1"> ' + activityClubName + ' </span> </li>\n' +
                            '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityName1"> ' + activityName + ' </span></li>\n' +
                            '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityDate1"> ' + activityDate + ' </span></li>\n' +
                            '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityPlace1"> ' + activityPlace + ' </span></li>\n' +
                            '      <li class="list-group-item  col-lg-1 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityQuota1"> ' + activityCapacity + '</span></li>\n' +
                            '      <li class="list-group-item  col-lg-1 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityGe1"> ' + activityGePoints + ' </span></li>\n' +
                            '      <li class="list-group-item col-lg-1 col-2 justify-content-center d-none  d-sm-block" style="border: none">\n' +

                            '        <button id="joinButton" type="button" onclick="addActivityToStudent('+ studentID + ',' +activityID+')" class="btn btn-danger btn-outline-dark justify-content-center" style="color: white">Join</button>\n' +

                            '      </li>';
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })

             */


            /*
            axios.get("https://projectdeneme.herokuapp.com/activities/listActivities")
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })

             */
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });
}

navActivities.addEventListener('click', getData);

function addActivityToStudent(studentID, activityID) {
    axios.put("https:projectdeneme.herokuapp.com/students/addActivityToStudent/" + studentID + "/" + activityID)
        .then(function () {
            console.log("i added yeah");
            document.location.href = "MainPageS.html";
        })
        .catch(function (error) {
            console.log(error);
        })
}