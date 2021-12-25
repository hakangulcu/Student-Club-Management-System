
const tbody = document.getElementById("tbody");




const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/clubs/listStudentsInClub/1').then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var name = response.data[i].activityDescription;
                var surname = response.data[i].activityName;
                var sid = response.data[i].activityCapacity;
                var email = response.data[i].activityDate;
                var dep = response.data[i].activityPlace;
                const line31 = document.createElement('line31');
                line31.innerHTML = '<tr>\n' +
                    '                <th scope="col">'+ name+'</th>\n' +
                    '                <th scope="col"> '+surname+'</th>\n' +
                    '                <th scope="col">'+sid+'</th>\n' +
                    '                <th scope="col">'+email+'</th>\n' +
                    '                <th scope="col">'+dep+'</th>\n' +
                    '                <td style="text-align: center;"><button class="remove">\n' +
                    '                    Remove from Club\n' +
                    '                </button></td>\n' +
                    '            </tr>\n';
                tbody.appendChild(line31);
            }
            ;
        }
    )
};



