
const tbody1 = document.getElementById("tbody");

const id= sessionStorage.getItem("activityId");
console.log(id);


const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/activities/getParticipantList/'+id).then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var name = response.data[i].name;
                var surname = response.data[i].surname;
                var sid = response.data[i].userId;
                var email = response.data[i].email;
                var dep = response.data[i].department;
                const line31 = document.createElement('line31');
                line31.innerHTML += '<tr><th scope="col "style="color:white;">'+ name+'</th><th scope="col"> '+surname+'</th> <th scope="col">'+sid+'</th> <th scope="col">'+ email +'</th> <th scope="col">'+dep+'</th> <td style="text-align: center;"><button class="remove" onclick="remove('+ response.data[i].id+' )">Remove from Activity</button></td> </tr>';
                    tbody1.appendChild(line31);
            }
            ;
        }
    )
};

async function remove(idst)
{
    const res = await axios.put('https://projectdeneme.herokuapp.com/students/deleteActivityFromStudent/'+ idst + '/'+ id)
        .then(function (response) {
        console.log(response);

    })
        .catch(function (error) {
            console.log(error);
        });
        document.location.href = "ActivityParticipantList.html"
}


