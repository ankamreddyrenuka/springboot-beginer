
var currentUserIndex = 1;
var userArray = [
    {"name" : "John", "gender" : "Male", "img" : "img/john.png"},
    {"name" : "Jane", "gender" : "Female", "img" : "img/jane.png"}
];


function toggleUser(){
    currentUserIndex =1-currentUserIndex;
    var nextUser = userArray[currentUserIndex];
    displayUser(nextUser);
    // DOM Manipulation
  function displayUser(user){
    document.getElementById("userImage").src = user.img;
    document.getElementById("userGender").innerHTML = user.gender;
    document.getElementById("userName").innerHTML = user.name;
}
}