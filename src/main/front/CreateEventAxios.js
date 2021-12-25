
const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('date');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');

 /** 
const getDataCreateActivity = () => {
    console.log("salkjdsakjdsakj");
    axios.get('https://projectdeneme.herokuapp.com/activities/addNewActivity').then(function (response) {
        console.log(response);

    }

        .catch(function (error) {
            // handle error
            console.log(error);
        });
};
*/
async function putActivityData() {
    console.log(typeof($('#date').val()));
    console.log(typeof(quotaText.value));
    const res = await axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
    
    activityName: activityNameText.value,
    date: $('#date').val(),
     
    capacity: quotaText.value,
    ge250Point: ge250Text.value,
      
    //averageRate: guestText.value,
    place: placeText.value,
    
    participantList: null,
    activityDescription: null
    
})        .then(function (response) {
    console.log(response);
    
})
.catch(function (error) {
    console.log(error);
});
/** 
const res2 = await axios.put('http://localhost:8080/clubs/addActivityToClub/1/1', {

});
*/
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
};




saveButton.addEventListener('click', putActivityData);