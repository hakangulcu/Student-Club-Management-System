const textarea = document.getElementById('textarea');
const activityNameText = document.getElementById('activityNameText');
const descriptionText = document.getElementById('descriptionText');
const guestText = document.getElementById('guestText');
const datepicker = document.getElementById('datepicker');
const quotaText = document.getElementById('quotaText');
const placeText = document.getElementById('placeText');
const ge250Text = document.getElementById('ge250Text');
const saveButton = document.getElementById('saveButton');
const asdsadsa = document.getElementById('saveButton');

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


const sendDataCreateActivity = () => {
    axios
      .put(
        'https://projectdeneme.herokuapp.com/activities/addNewActivity',
        { 
          activityName: activityNameText.value,
          date: datepicker.value,
          capacity: quotaText.value,
          ge250Point: ge250Text.value,
          averageRate: "",
          place: placeText.value,
          
          // password: 'pistol'
          //activityName :
        },
        {
          // headers: {
          //   'Content-Type': 'application/json'
          // }
        }
      )
      .then(response => {
        console.log(response);
      })
      .catch(err => {
        console.log(err, err.response);
      });
  };


asdsadsa.addEventListener('click', getDataCreateActivity);
saveButton.addEventListener('click', sendDataCreateActivity);
asdsadsa.addEventListener('click', getDataCreateActivity);