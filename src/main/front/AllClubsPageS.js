const studentID = localStorage.getItem("studentId");


const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/students/getUnattendedClubs/' + studentID).then(function (response) {

        console.log(response);
        for (var i = 0; i < response.data.length; i++) {

            var clubname = response.data[i].clubName;
            var clubID = response.data[i].id;

            document.body.innerHTML += ' <ul class="list-group list-group-horizontal mt-3 justify-content-evenly" style="background-color: #cbcaca" >\n' +
                '        <li class="list-group-item col-lg-6 col-sm-4 col-md-4 text-center ms-2" style="border: none;background-color: #cbcaca">' + clubname + '</li>\n' +
                '        <li class="list-group-item  col-lg-2 ms-2 " style="border: none;background-color: #cbcaca">\n' +
                '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Show</button>\n' +
                '        </li>\n' +
                '        <li class="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black" onclick="addClubToStudent('+studentID+ ','+clubID+')">Join</button>\n' +
                '        </li>\n' +

                '    </ul>';

        }
    })
};

function addClubToStudent(studentID, clubID) {
    axios.put("https://projectdeneme.herokuapp.com/students/addClubToStudent/" + studentID + "/" + clubID, {})
        .then(function (response) {
            document.location.href = "AllClubsPageS.html";
            alert("club added to student clubs");
        })
        .catch(function (error) {
            console.log(error);
        })
}
