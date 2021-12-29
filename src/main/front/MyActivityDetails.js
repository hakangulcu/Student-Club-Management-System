const tbody = document.getElementById("tbody");
const clubID = localStorage.getItem("clubId");
console.log(clubID);

function getData() {
    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/'+ clubID ).then(function (response) {
        console.log(response);
        for (let i = 0; i < response.data.length; i++) {
            let actName = response.data[i].activityName;
            let actQuota = response.data[i].capacity;
            let activityDesc = response.data[i].activityDescription;
            let date1 = response.data[i].date;
            let activityId = response.data[i].id;

            let clubname = response.data[i].clubName;
            const line31 = document.createElement('line31');
            line31.innerHTML += ' <tr style="height: 20%;"> <td style="width: 75%;"> <div class="card"> <div class="container1"> <h1 class="activity-name"><span id="activityname"> Activity Name: ' + actName + '</span></h1> <p><span id="descr">description' + activityDesc + ' </span></p> <h1 class="neon"><span id="quota">Quota:' + actQuota + '</span> </h1> <h1 class="neon"><span id="date">Date:' + date1 + '</span> </h1> </div><div class="container"><div class="row" style="text-align: center;"><button class="hidden-btn" onclick="goCustom(' + activityId + ')"> Customize Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn2" onclick="deleteEvent(' + activityId + ')"> Delete Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn" onclick="goDetails(' + activityId + ')"> Show Participant</button></div></div></div></td></tr>';
            tbody.appendChild(line31);
        }
        console.log(response);
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });

}

function goDetails(activityID) {
    localStorage.setItem("activityId", activityID);
    document.location.href = "ActivityParticipantList.html";
}

function goCustom(activityID) {
    localStorage.setItem("activityId", activityID);
    document.location.href = "CustomizeEvent.html";
}

function deleteEvent(activityID) {
    axios.delete("https://projectdeneme.herokuapp.com/activities/deleteActivity/" + activityID)
        .then(function () {
            console.log("i deleted this activity with id " + activityID);
            document.location.href = "ClubManagerMainPage.html";
        })
        .catch(function (error) {
            console.log(error);
        })
}