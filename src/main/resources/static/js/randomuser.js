function displayUser(user){
    document.getElementById("userImage").src = user.img;
    document.getElementById("userGender").innerHTML = user.gender;
    document.getElementById("userName").innerHTML = user.name;
}
function getAndDisplayRandomUser(){
    fetch('https://randomuser.me/api/')
        .then(function(res){
            return res.json();
        })
        .then(function(data){
            var user = data.results[0];
            var userData = {
                name: user.name.first + " " + user.name.last,   
                gender: user.gender,
                img: user.picture.large
            };
            displayUser(userData);
        })
        .catch(function(err){
            console.error("Error fetching user data:", err);
        }); 
}