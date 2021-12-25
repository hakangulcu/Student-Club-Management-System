
const navActivities = document.getElementById("navActivities");
//const axios = require('axios');
//https://projectdeneme.herokuapp.com/activities/listActivities
//const axios = require('axios').default;


const getData = () => {
    axios.get('').then(function (response) {

        console.log(response);
        var clubname = response.data[i].date;
        document.getElementById("clubName").textContent=clubname;
        for(var i = 0; i < response.data.length; i++) {
            var activityName = response.data[i].activityName;

            var clubdesc = response.data[i].place;

            document.body.innerHTML = document.body.innerHTML + '';

        }
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });
};



navActivities.addEventListener('click', getData)