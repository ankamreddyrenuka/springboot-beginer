var savedUsers = [];
var currentUserIndex = 0;
var currentGender = 'Male';

function displayUser(user) {
    document.getElementById("userImage").src = user.image || 'img/john.png';
    document.getElementById("userGender").innerHTML = (user.gender || '').charAt(0).toUpperCase() + (user.gender || '').slice(1);
    document.getElementById("userName").innerHTML = user.name || '';
}

function loadSavedUsers() {
    fetch('/api/users')
        .then(function(res) {
            return res.json();
        })
        .then(function(users) {
            savedUsers = users || [];
            if (savedUsers.length === 0) {
                console.warn('No saved users found');
                var defaultUser = { name: 'Renuka', gender: 'female', image: 'img/jane.png' };
                var defaultUser2 = { name: 'Sirish', gender: 'male', image: 'img/john.png' };
                savedUsers.push(defaultUser);
                savedUsers.push(defaultUser2);
            }
            currentUserIndex = 0;
            displayCurrentUser();
        })
        .catch(function(err) {
            console.error('Error fetching saved users:', err);
        });
}

function displayCurrentUser() {
    if (savedUsers.length === 0) return;
    
    // Find next user with current gender (case-insensitive)
    var attempts = 0;
    while (attempts < savedUsers.length) {
        var user = savedUsers[currentUserIndex % savedUsers.length];
        var userGender = (user.gender || '').toLowerCase();
        var targetGender = currentGender.toLowerCase();
        if (userGender === targetGender) {
            displayUser(user);
            return;
        }
        currentUserIndex++;
        attempts++;
    }
    // If no user of this gender found, show current anyway
    displayUser(savedUsers[currentUserIndex % savedUsers.length]);
}

function toggleUser() {
    if (currentGender === 'Male') {
        currentGender = 'Female';
    } else {
        currentGender = 'Male';
    }
    currentUserIndex = 0;
    displayCurrentUser();
}

document.addEventListener('DOMContentLoaded', function() {
    loadSavedUsers();
});