const tbody = document.getElementById("tbody");
const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/1').then(function (response) {
        console.log(response);
        for(var i = 0; i < response.data.length; i++) {
            var actName = response.data[i].activityName;
            var actQuota = response.data[i].cappacity;
            var activityDesc = response.data[i].activityDescription;
            var date = response.data[i].activityDate;

            for(var i = 0; i < response.data.length; i++) {

                var clubname = response.data[i].clubName;
                const line31 = document.createElement('line31');
                line31.innerHTML =' <tr style="height: 20%;"> <td style="width: 75%;"> <div class="card"> <div class="container1"> <h1 class="activity-name"><span id="activityname"> activityname'+actName+'</span></h1> <p><span id="descr">description'+activityDesc+' </span></p> <h1 class="neon"><span id="quota">Quota : 27 / 55'+ actQuota+'</span> </h1> <h1 class="neon"><span id="date">date'+ date +'</span> </h1> </div><div class="container"><div class="row" style="text-align: center;"><button class="hidden-btn" onclick=""> Customize Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn2"> Delete Event</button></div><div class="row" style="text-align: center;"><button class="hidden-btn" onclick="";> Show Participant</button></div></div></div></td></tr>';
                tbody.appendChild(line31);
            }


        }
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });

};
