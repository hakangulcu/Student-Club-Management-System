

const pastact = document.getElementById("pastact1");
const upact = document.getElementById("upact1");



const getData = () => {

    axios.get('https://projectdeneme.herokuapp.com/clubs/getClub/1').then(function (response) {

        console.log(response);
        var clubname = response.data.clubName;
        var clubdesc = response.data.clubTextDescription;

        document.getElementById("clubName").textContent=clubname;
        document.getElementById("clubDesc").textContent=clubdesc;

    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });
    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/1').then(function (response) {
        var today = new Date();
        console.log(response);




        for(var i = 0; i < response.data.length; i++) {
            var activitydate = response.data[i].date;
            var activityname = response.data[i].activityName;
            const line31 = document.createElement('line31');
            line31.innerHTML ='<u1 class="list-group list-group-horizontal mb-3"><li class="list-group-item col-lg-10 col-sm-2 col-md-2  col-4 "style="border: none"> '+ activityname + '</li><li class="list-group-item col-lg-2 col-sm-2 col-md-2   "style="border: none"><button type="button" class="btn btn-danger btn-outline-dark " style="color: white">Show</button></li></u1>';

            if(activitydate > today) {
                pastact.appendChild(line31);}
            else {
                upact.appendChild(line31); }
        }
    })
};



