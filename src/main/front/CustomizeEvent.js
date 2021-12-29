const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('date');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');
const clubID = localStorage.getItem("clubId");
const activityID = localStorage.getItem("activityId");

function putActivityData() {
    let date = new Date($('#date').val());
    console.log(date.toDateString());

    /*
    axios.put('https://projectdeneme.herokuapp.com/activities/customizeActivity/' + activityID + "/", {

        headers: {
            'Access-Control-Allow-Origin': 'http://localhost:63342'
            // 'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
            // 'Access-Control-Allow-Headers': 'append,delete,entries,foreach,get,has,keys,set,values,Authorization'
        },

        activityName: activityNameText.value,
        activityDescription: descriptionText.value,
        guests: guestText.value,
        place: placeText.value,
        capacity: quotaText.value,
        date: date,
        ge250Point: ge250Text.value
    })
        .then(function () {
            console.log("i customized the event");
            document.location.href = "ActivityList.html";
        })
        .catch(function (error) {
            console.log(error);
        })

     */



    // 1. activityId'den activity name bul
    // 2. add new activity içine dewamke

    axios.get("https://projectdeneme.herokuapp.com/activities/getActivity/" + activityID)
        .then(function (response) {
            console.log(response);
            console.log(response.data);
            axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
                id: activityID,
                activityName: activityNameText.value,
                activityDescription: descriptionText.value,
                guests: guestText.value,
                place: placeText.value,
                capacity: quotaText.value,
                date: date,
                ge250Point: ge250Text.value
            })
                .then(function (response) {
                    console.log(response);
                    console.log("i added");
                    document.location.href = "ClubManagerMainPage.html";
                })
                .catch(function (error) {
                    console.log(error);
                })
        })
        .catch(function (error) {
            console.log(error);
        })

        /*
        .then(function () {
            console.log("i created an activity, or did i?");
        })
        .catch(function (error) {
            console.log(error);
        });
    */
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
