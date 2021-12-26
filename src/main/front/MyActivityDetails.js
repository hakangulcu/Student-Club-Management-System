const tbody = document.getElementById("tbody");
const id= sessionStorage.getItem("clubId");
console.log(id);
const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/'+id).then(function (response) {
        console.log(response);
        for(var i = 0; i < response.data.length; i++) {
            var actName = response.data[i].activityName;
            var actQuota = response.data[i].capacity;
            var activityDesc = response.data[i].activityDescription;
            var date1 = response.data[i].date;
            var activityId = response.data[i].id;

            var clubname = response.data[i].clubName;
            const line31 = document.createElement('line31');
            line31.innerHTML +=' <tr style="height: 20%;"> <td style="width: 75%;"> <div class="card"> <div class="container1"> <h1 class="activity-name"><span id="activityname"> Activity Name: '+actName+'</span></h1> <p><span id="descr">description'+activityDesc+' </span></p> <h1 class="neon"><span id="quota">Quota:'+ actQuota+'</span> </h1> <h1 class="neon"><span id="date">Date:'+ date1 +'</span> </h1> </div><div class="container"><div class="row" style="text-align: center;"><button class="hidden-btn" onclick=""> Customize Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn2"> Delete Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn" onclick="goDetails('+ activityId +')";> Show Participant</button></div></div></div></td></tr>';
            tbody.appendChild(line31);
            


        }
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });

};
function goDetails(activityId) {
    var aId = activityId;
    sessionStorage.setItem("activityId", aId );
    document.location.href = "ActivityParticipantList.html";
}