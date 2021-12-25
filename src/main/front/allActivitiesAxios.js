
const joinButton = document.getElementById("joinButton");
//const axios = require('axios');
//https://projectdeneme.herokuapp.com/activities/listActivities
//const axios = require('axios').default;


const getData = () => {
    axios.get('https://projectdeneme.herokuapp.com/activities/listActivities').then(function (response) { 
    console.log(response);
    //console.log(response.data[0].id);
    })
    .catch(function (error) {
    // handle error
    console.log(error);
    });
};
 
/**
const currentData = await axios.get('https://projectdeneme.herokuapp.com/activities/listActivities')then(res => res.data);
joinButton.addEventListener('click', getData)
*/

joinButton.addEventListener('click', getData)