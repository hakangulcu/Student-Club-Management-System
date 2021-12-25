

const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/student/getFavoriteClubs/1').then(function (response) {

        console.log(response);




        for(var i = 0; i < response.data.length; i++) {

            var clubname = response.data[i].clubName;

            document.body.innerHTML =' <ul class="list-group list-group-horizontal mt-3 justify-content-evenly" style="background-color: #cbcaca" >\n' +
                '        <li class="list-group-item col-lg-6 col-sm-4 col-md-4 text-center ms-2" style="border: none;background-color: #cbcaca">' + clubName +'</li>\n' +
                '        <li class="list-group-item  col-lg-2 ms-2 " style="border: none;background-color: #cbcaca">\n' +
                '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Show</button>\n' +
                '        </li>\n' +
                '        <li class="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Join</button>\n' +
                '        </li>\n' +

                '    </ul>';

        }
    })
};



