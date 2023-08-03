document.getElementById('submit-btn').addEventListener('click', function(event) {
    console.log("Event clicked");
    var iconElement = document.querySelector('.submit-btn i');
    iconElement.classList.add('fa-spinner', 'fa-spin');
});