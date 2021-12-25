
const tbody1 = document.getElementById("tbody");




const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/activities/getParticipantList/1').then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var name = response.data[i].name;
                var surname = response.data[i].surname;
                var sid = response.data[i].userId;
                var email = response.data[i].email;
                var dep = response.data[i].email;
                const line31 = document.createElement('line31');
                line31.innerHTML += '<tr><th scope="col "style="color:white;">'+ name+'</th><th scope="col"> '+surname+'</th> <th scope="col">'+sid+'</th> <th scope="col">'+ email +'</th> <th scope="col">'+dep+'</th> <td style="text-align: center;"><button class="remove">Remove from Activity</button></td> </tr>';
                    tbody1.appendChild(line31);
            }
            ;
        }
    )
};




