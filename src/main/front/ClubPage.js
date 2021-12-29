const clubDescription = document.getElementById('clubDescription');
const mission = document.getElementById('mission');
const vision = document.getElementById('vision');
//const pastActivities = document.getElementById('pastActivities');
const saveButtonClubPage = document.getElementById('saveButtonClubPage');

async function putActivityDataClubPage() {
    console.log("Description:" + clubDescription.value + "\n" + "Mission:" + mission.value + "\n" + "Vision: " + vision.value)
    const res = await axios.put('#', {
        clubTextDescription: "Description:" + clubDescription.value + "\n" + "Mission:" + mission.value + "\n" + "Vision: " + vision.value,

    }).then(function (response) {
        console.log(response);

    })
        .catch(function (error) {
            console.log(error);
        })
};


saveButtonClubPage.addEventListener('click', putActivityDataClubPage);