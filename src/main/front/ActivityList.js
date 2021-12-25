
const tbody2 = document.getElementById("tbody1");

const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/1').then(function (response) {

            console.log(response);

            for (var i = 0; i < response.data.length; i++) {
                var activitydesc = response.data[i].activityDescription;
                var activityname = response.data[i].activityName;
                var activityquota = response.data[i].capacity;
                var activitydate = response.data[i].date;
                var activityplace = response.data[i].place;
                const line32 = document.createElement('tbody1');
                line32.textContent = "";
                line32.innerHTML += '<tr style="height: 20%;"><td><div className="card"><div style="background-color:LightGray;" className="container1"><h1 className="activity-name">' + activityname + '</h1> <p style="color:black"> ' + activitydesc + '</p> <h1 className="neon">'+ activityquota+' </h1> <h1 className="neon"> '+ activitydate+' </h1> <h1 className="neon2">'+activityplace+'</h1> </div> </div> </td> </tr>';
                tbody2.appendChild(line32);
            }
            ;
        }
    )
};

async function putActivityListData(){
    const res = await axios.put('#', {

    })
}

/**
 * async function putActivityData() {
    var mydate = new Date($('#date').val());
    console.log(mydate.toDateString());
    const res = await axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
    
    activityName: activityNameText.value,
    date: mydate,
     
    capacity: quotaText.value,
    ge250Point: ge250Text.value,
      
    //averageRate: guestText.value,
    place: placeText.value,
    
    participantList: null,
    activityDescription: null
    
})        .then(function (response) {
    console.log(response);
    
})
.catch(function (error) {
    console.log(error);
});
 */


