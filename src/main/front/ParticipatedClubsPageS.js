

const getData = () => {


    axios.get('https://projectdeneme.herokuapp.com/student/getClubs/1').then(function (response) {

        console.log(response);




        for(var i = 0; i < response.data.length; i++) {

            var clubname = response.data[i].clubName;

            document.body.innerHTML =' <ul className="list-group list-group-horizontal  justify-content-evenly " style="background-color: #cbcaca">\n' +
                '        <li className="list-group-item col-lg-4 col-sm-4 col-md-4 text-center ms-2"\n' +
                '         style="border: none;background-color: #cbcaca">'+clubname+'</li>\n' +
                '            <li className="list-group-item  col-lg-2 ms-2 " style="border: none;background-color: #cbcaca">\n' +
                '        <button type="button" className="btn btn-danger btn-outline-dark " style="color: white">Leave</button>\n' +
                '        <li class="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                '            <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Show</button></li>\n' +
                '        <li className="list-group-item col-lg-2 ms-2" style="border: none;background-color: #cbcaca">\n' +
                '        <button type="button" className="btn btn-danger btn-outline-dark " style="color: white">Add to Favorite</button>\n' +
                '    </li> <button type="button" class="btn btn-danger btn-outline-dark " style="color: black">Remove From Favorite</button>\n' +
                '        </li>\n' +
                '    </ul>';

        }
    })
};


