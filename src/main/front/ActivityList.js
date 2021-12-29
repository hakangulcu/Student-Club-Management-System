//const axios = require('axios');
//https://projectdeneme.herokuapp.com/activities/listActivities
//const axios = require('axios').default;
const clubID = localStorage.getItem("clubId");


function getData2() {
    axios.get('https://projectdeneme.herokuapp.com/activities/listActivities').then(function (response) {
        console.log(response);
        for (let i = 0; i < response.data.length; i++) {
            let activityClub = response.data[i].organizerClubList[0].clubName;
            let activityName = response.data[i].activityName;
            let activitydate = response.data[i].date;
            let activityplace = response.data[i].place;
            let accap = response.data[i].capacity;
            let ge250 = response.data[i].ge250Point;
            document.body.innerHTML = document.body.innerHTML + '<ul class="list-group list-group-horizontal mb-2 mt-4 "  >\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityClub1"> ' + activityClub + ' </span></li>\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityName1"> ' + activityName + ' </span></li>\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityDate1"> ' + activitydate + ' </span></li>\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityPlace1"> ' + activityplace + ' </span></li>\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityQuota1"> ' + accap + '</span></li>\n' +
                '      <li class="list-group-item  col-lg-2 col-sm-2 col-md-2 col-4 text-center" style="border: none"><span id="activityGe1"> ' + ge250 + ' </span></li>';
        }
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });
}

