
const tbody = document.getElementById("tbody");
const id= sessionStorage.getItem("clubId");
console.log(id);



const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/clubs/listStudentsInClub/'+id).then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var name = response.data[i].name;
                var surname = response.data[i].surname;
                var sid = response.data[i].userId;
                var email = response.data[i].email;
                var dep = response.data[i].department;
                const line31 = document.createElement('line31');
                line31.innerHTML = '<tr><th scope="col">'+ name +'</th><th scope="col"> '+ surname +'</th><th scope="col">'+ sid +'</th><th scope="col">'+ email +'</th><th scope="col">'+ dep +'</th><td style="text-align: center;"><button class="remove">Remove from Club</button></td></tr>';
                tbody.appendChild(line31);
            }
            ;
        }
    )
};




