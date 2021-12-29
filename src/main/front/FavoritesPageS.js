let studentID = localStorage.getItem("studentId");

const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/students/getFavoriteClubs/' + studentID)
        .then(function (response) {

            console.log(response);


            for (var i = 0; i < response.data.length; i++) {

                var clubname = response.data[i].clubName;

                document.body.innerHTML += ' <ul class="list-group list-group-horizontal mt-3 justify-content-evenly" style="background-color: #cbcaca" >\n' +
                    '        <li class="list-group-item col-lg-4 col-sm-4 col-md-4 text-center ms-2" style="border: none;background-color: #cbcaca">' + clubname + '</li>\n' +
                    '        <li class="list-group-item  col-lg-2 ms-2 " style="border: none;background-color: #cbcaca">\n' +
                    '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Leave</button>\n' +
                    '        </li>\n' +
                    '        <li class="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                    '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Show</button>\n' +
                    '        </li>\n' +
                    '        <li class="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                    '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Remove From Favorite</button>\n' +
                    '        </li>\n' +
                    '    </ul>';

            }
        })
        .catch(function (error) {
            console.log(error);
        })
};



