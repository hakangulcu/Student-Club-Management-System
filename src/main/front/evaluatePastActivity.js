const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/activities/').then(function (response) {
        console.log(response);
        for (var i = 0; i < response.data.length; i++) {
            var clubName = "buraya cookiesden club name çekicez mk";
            var rate = response.data[i].rate;
            var activityDesc = response.data[i].activityDescription;

            document.getElementById("activitydesc").textContent = activityDesc;

            document.getElementById("clubName").textContent = clubName;

            document.getElementById("activityrate").textContent = rate;


        }
    })
        .catch(function (error) {
            // handle error
            console.log(error);
        });

};
