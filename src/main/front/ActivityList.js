
const tbody = document.getElementById("tbody");




const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/1').then(function (response) {
            var today = new Date();
            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var activitydesc = response.data[i].activityDescription;
                var activityname = response.data[i].activityName;
                var activityquota = response.data[i].activityCapacity;
                var activitydate = response.data[i].activityDate;
                var activityplace = response.data[i].activityPlace;
                const line31 = document.createElement('line31');
                line31.innerHTML = '<tr style="height: 20%;"><td><div className="card"><div style="background-color:LightGray;" className="container1"><h1 className="activity-name">' + activityname + '</h1> <p style="color:black"> ' + activitydesc + '</p> <h1 className="neon">'+ activityquota+' </h1> <h1 className="neon"> '+ activitydate+' </h1> <h1 className="neon2">'+activityplace+'</h1> </div> </div> </td> </tr>';
                tbody.appendChild(line31);
            }
            ;
        }
    )
};




