var users = [
    {"name": "John", "gender": "Male", "img": "img/John.png"},
    {"name": "Jane", "gender": "Female", "img": "img/Jane.png"}
];

var currentUserIndex = 0;

function toggleUser() {
    currentUserIndex = (currentUserIndex + 1) % users.length;
    var user = users[currentUserIndex];

    document.getElementById("userImage").src = user.img;
    document.getElementById("userGender").innerHTML = user.gender;
    document.getElementById("userName").innerHTML = user.name;
}