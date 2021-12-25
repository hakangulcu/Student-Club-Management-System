const tbody = document.getElementById("tbody");
const tobbybest1 = document.getElementById("tobbybest");
const id= sessionStorage.getItem("clubId");
console.log(id);
const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/clubs/listStudentsInClub/'+id).then(function (response) {
            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                console.log(response.data[i]);
                var name = response.data[i].name;
                var surname = response.data[i].surname;
                var id1 = response.data[i].id;

                const line31 = document.createElement('line31');
                line31.innerHTML = '<tr class="ms-4" style="color: red"><td class="ms-4" style="color: red">'+ name +'</td><td>'+ surname +'</td><td>'+ id1 +'</td> </tr>';
                tbody.appendChild(line31);
            }
            ;
        }
    )

    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/'+id).then(function (response) {

            console.log(response);

            for (var i = 0; i < response.data.length; i++) {
                console.log(response.data[i]);
                var date = response.data[i].date;
                var desc = response.data[i].activityDescription;
                var club = response.data[i].organizerClubList[0].clubName;


                const line32 = document.createElement('line32');
                line32.innerHTML = '<tr><td>' + date + '</td><td>' + desc + '</td><td>' + club + '</td> </tr>';
                tobbybest1.appendChild(line32);
            }
            ;
        }
    )
};