const textarea = document.getElementById('textarea');
const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('datepicker');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');

const getDataCreateActivity = () => {
    console.log("salkjdsakjdsakj");
    axios.get('https://projectdeneme.herokuapp.com/activities/addNewActivity').then(function (response) {
    console.log(response);
    
    })
    
    .catch(function (error) {
    // handle error
    console.log(error);
    });
};

/** 
https://projectdeneme.herokuapp.com/activities/addNewActivity
function putActivityData() {
    axios.post('https://projectdeneme.herokuapp.com/activities/addNewActivity', {
       
    },
    })
}
*/

saveButton.addEventListener('click', getDataCreateActivity);
