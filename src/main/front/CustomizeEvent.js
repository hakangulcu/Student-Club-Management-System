
const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('date');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');
var position = -1;

function getActivity(){
    axios.get('https://projectdeneme.herokuapp.com/activities/listActivities').then(function (response) {
    console.log(response);
        for(var i = 0; i < response.data.length; i++) {

            if(activityName.equals(response.data[i].activityName) && date.equals(response.data[i].date) && place.equals(response.data[i].place)){
                
                activityNameText.value = response.data[i].activityName
                //descriptionText.value = response.data[i].
                //guestText.value = response.data[i].
                datepicker.value = response.data[i].date
                quotaText.value = response.data[i].capacity
                placeText.value = response.data[i].place
                ge250Text.value = response.data[i].ge250Point
            }

        }
    })
    .catch(function (error) {
    // handle error
    console.log(error);
    });
};

async function putActivityData() {
    var mydate = new Date($('#date').val());
    console.log(mydate.toDateString());
    const res = await axios.put('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
    
    activityName: activityNameText.value,
    date: mydate,
     
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

};

saveButton.addEventListener('click', getActivity);