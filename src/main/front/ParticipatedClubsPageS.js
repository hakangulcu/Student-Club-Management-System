let studentID = localStorage.getItem("studentId");

const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/students/getClubs/' + studentID).then(function (response) {

        console.log(response);


        for (let i = 0; i < response.data.length; i++) {

            let clubname = response.data[i].clubName;
            let clubID = response.data[i].id;

            document.body.innerHTML +=
                '<ul class="list-group list-group-horizontal mt-3 justify-content-evenly" style="background-color: white">' +
                    '<li class="list-group-item col-lg-4 col-sm-4 col-md-4 text-center ms-2" style="border: none;background-color:white">'+ clubname +
                    '</li>' +
                    '<li class="list-group-item  col-lg-2 ms-2 " style="border: none;background-color:white">' +
                        '<button type="button" class="btn btn-danger btn-outline-dark " style="color: white">Show</button> </li>' +
                    '<li class="list-group-item col-lg-2 ms-2" style="border: none;background-color:white"> ' +
                        '<button onclick="removeStudentFromClub('+studentID+ ','+clubID+')" type="button" class="btn btn-danger btn-outline-dark " style="color: white">Leave</button> ' +
                    '</li> ' +
                    '<li class="list-group-item col-lg-2 ms-2" style="border: none;background-color:white"> ' +
                    '<button onclick = "addFavorite('+studentID+ ','+clubID+')" "type="button" class="btn btn-danger btn-outline-dark " style="color: white">Add to Favorite</button> ' +
                    '</li> ' +
                '</ul>';

        }
    })
};


function addFavorite(studentID,clubID) {
   axios.get("https://projectdeneme.herokuapp.com/changeFavoriteStatus/"+ studentID + "/" + clubID )
       .then(function (response){
           console.log(response)
       })
       .catch(function (error) {
           console.log(error)
       })
}

function removeStudentFromClub(studentID, clubID) {
    axios.delete("https://projectdeneme.herokuapp.com/students/removeClubFromStudent/" + studentID + "/" + clubID)
        .then(function (response) {
            document.location.href = "ParticipatedClubsPageS.html";
            alert("student left club");
        })
        .catch(function (error) {
            console.log(error);
        })
}