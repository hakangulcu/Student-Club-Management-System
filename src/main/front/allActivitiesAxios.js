
const navActivities = document.getElementById("navActivities");
//const axios = require('axios');
//https://projectdeneme.herokuapp.com/activities/listActivities
//const axios = require('axios').default;


const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/activities/listActivities').then(function (response) {
    console.log(response);
        for(var i = 0; i < response.data.length; i++) {
            var activityName = response.data[i].activityName;
            var activitydate = response.data[i].date;
            var activityplace = response.data[i].place;
            var accap = response.data[i].capacity;
            var ge250 = response.data[i].ge250Point;
            document.body.innerHTML = document.body.innerHTML + '<ul class="list-group list-group-horizontal mb-4  "  >\n' +
                '      <li class="list-group-item col-lg-2 col-sm-2 col-md-2 text-center  col-4" id="activityClub1" style="border: none">asdasd </li>\n' +
                '      <li class="list-group-item col-lg-2 col-sm-2 col-md-2 text-center  col-4" style="border: none"><span id="activityName1"> '+ activityName+ ' </span></li>\n' +
                '      <li class="list-group-item col-lg-2 col-sm-2 col-md-2 d-none d-sm-block text-center  col-2" style="border: none"><span id="activityDate1"> '+ activitydate+ ' </span></li>\n' +
                '      <li class="list-group-item col-lg-2 col-sm-2 col-md-2 d-none d-sm-block text-center  col-2" style="border: none"><span id="activityPlace1"> '+ activityplace+ ' </span></li>\n' +
                '      <li class="list-group-item col-lg-1 col-sm-1 col-md-1 d-none d-sm-block text-center  col-1" style="border: none"><span id="activityQuota1"> '+ accap+ '</span></li>\n' +
                '      <li class="list-group-item col-lg-1 col-sm-1 col-md-1 d-none d-sm-block text-center  col-1" style="border: none"><span id="activityGe1"> '+ ge250+ ' </span></li>\n' +
                '      <li class="list-group-item col-lg-2 col-2 justify-content-center d-none  d-sm-block" style="border: none">\n' +
                '        <button id = "joinButton" type="button" class="btn btn-danger btn-outline-dark justify-content-center" style="color: white">Join</button>\n' +
                '      </li>';

        }
    })
    .catch(function (error) {
    // handle error
    console.log(error);
    });
};
 
/**
const currentData = await axios.get('https://projectdeneme.herokuapp.com/activities/listActivities')then(res => res.data);
joinButton.addEventListener('click', getData)
*/

navActivities.addEventListener('click', getData)