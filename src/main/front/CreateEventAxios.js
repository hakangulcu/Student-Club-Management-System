const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('date');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');
const clubID = localStorage.getItem("clubId");

function putActivityData() {
    let date = new Date($('#date').val());
    console.log(date.toDateString());
    axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
        activityName: activityNameText.value,
        date: date,
        capacity: quotaText.value,
        ge250Point: ge250Text.value,
        place: placeText.value,
        participantList: null,
        activityDescription: null

    })
        .then(function () {
            console.log("i created an activity, or did i?");
            let activityID;
            axios.get("https://projectdeneme.herokuapp.com/activities/getActivityIdByName/" + activityNameText.value)
                .then(function (response) {
                    console.log(typeof (response));
                    console.log(response);
                    activityID = response.data;
                    console.log("let's try adding the activity to club");
                    axios.put("https://projectdeneme.herokuapp.com/clubs/addActivityToClub/" + activityID + "/" + clubID, {})
                        .then(function () {
                            console.log("added activity to club");
                            axios.get("https://projectdeneme.herokuapp.com/activities/getActivity/" + activityID)
                                .then(function (response) {
                                    console.log("new activity details")
                                    console.log(response);
                                })
                                .catch(function (error) {
                                    console.log(error);
                                })
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                    document.location.href = "ClubManagerMainPage.html";
                })
                .catch(function (error) {
                    console.log(error);
                });

        })
        .catch(function (error) {
            console.log(error);
        });

    // find activity id by name
    // add to clubID's activity list



    // GET http://localhost:8080/clubs/addActivityToClub/{{activityId}}/{{clubId}}

}

saveButton.addEventListener('click', putActivityData);
/*
axios.get('https://projectdeneme.herokuapp.com/students/loginPasswordCheck/' + userEmail.value + '/' + password.value).then(function (response) {
    console.log("axios get login password check");
    if (response.data === true) {
        console.log("response data is true");
        getID(userEmail.value);
        console.log("h" + localStorage["studentID"]);
        document.location.href = "MainPageS.html";
    } else {
        alert("E-mail or password is wrong!")
    }

})
    .catch(function (error) {
        // handle error
        console.log(error);
    });

 */


    // axios.put('http://localhost:8080/clubs/addActivityToClub/1/1', {

//http://localhost:8080/clubs/addActivityToClub/1/1


    /**   axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
        activityName: activityNameText.value,
        date: datepicker.value,
        capacity: quotaText.value,
        ge250Point:ge250Text.value,
        averageRate:guestText.value,
        place:placeText.value,
        organizerClubList: null,
        participantList:null,
        activityDescription: null,
        evaluationList:null,
        commentList:null,
        schedule:null
    })
     .then(function (response) {
            console.log(response);
        })
     .catch(function (error) {
            console.log(error);
        });
     */
