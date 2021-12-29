const tbody = document.getElementById("tbody");

const clubID = localStorage.getItem("clubId");
const clubMemberTable = document.getElementById("clubMembersTable");
console.log(clubID);


const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/clubs/listStudentsInClub/'+ clubID).then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name1 = response.data[i].name;
                var surname1 = response.data[i].surname;

                var sid = response.data[i].userId;
                var email1 = response.data[i].email;
                var dep = response.data[i].department;


                var row = clubMemberTable.insertRow(i + 1);

                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                var cell3 = row.insertCell(2);
                var cell4 = row.insertCell(3);
                var cell5 = row.insertCell(4);
                var cell6 = row.insertCell(5);
                var button = '<button onclick="remove(' + id + ')" class="remove">Remove from Club</button>';

                cell1.innerHTML = name1;
                cell2.innerHTML = surname1;
                cell3.innerHTML = sid;
                cell4.innerHTML = email1;
                cell5.innerHTML = dep;
                cell6.innerHTML = button;


            }
        }
    )
};

function remove(studentID) {
    axios.delete('https://projectdeneme.herokuapp.com/students/removeClubFromStudent/' + studentID + '/' + clubID)
        .then(function (response) {
            console.log(response);
            document.location.href = "ClubMembersPage.html";
        })
        .catch(function (error) {
            console.log(error);
        });

}




