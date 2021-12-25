const tbody = document.getElementById("tbody");
const tobbybest = document.getElementById("tobbybest");
const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/clubs/liststudents/1').then(function (response) {
            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var name = response.data[i].studentName;
                var surname = response.data[i].studentSurname;
                var id = response.data[i].studentId;

                const line31 = document.createElement('line31');
                line31.innerHTML = '<tr><td>'+name+'</td><td>'+surname+'</td><td>'+id+'</td> </tr>';
                tbody.appendChild(line31);
            }
            ;
        }
    )

    axios.get('https://projectdeneme.herokuapp.com/clubs/listActivities/1').then(function (response) {

            console.log(response);


        var date = response.data[i].activityDate;
        var desc = response.data[i].activityDesc;
        var club = response.data[i].club;

        const line32 = document.createElement('line32');
        line32.innerHTML += '<tr><td>'+date+'</td><td>'+desc+'</td><td>'+club+'</td> </tr>';
        tobbybest.appendChild(line32);

        }
    )
};