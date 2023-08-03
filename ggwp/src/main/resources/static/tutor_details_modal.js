// JavaScript to handle the modal functionality
const openModalBtn = document.getElementById("tutor-details-openModalBtn");
const modalOverlay = document.getElementById("tutor-details-modalOverlay");
const modal = document.getElementById("tutor-details-myModal");
const modalCloseBtn = document.getElementById("tutor-details-modalCloseBtn");


const tutorDetailsAvailabilities = {}

console.log(availabilities)
// Initialize tutorDetailsAvailabilities as an empty object

availabilities.forEach((availability) => {
  const userId = availability.tutorId;
  const dayOfWeek = availability.dayOfWeek;
  const startTime = availability.startTime;
  const endTime = availability.endTime;

  console.log(startTime)

  const options = {
    hour: '2-digit',
    minute: '2-digit',
  };

  const locale = 'en-US'; // English - United States
  const formattedStartTime = new Date(`1970-01-01T${startTime}Z`).toLocaleTimeString(locale, options);
  const formattedEndTime = new Date(`1970-01-01T${endTime}Z`).toLocaleTimeString(locale, options);



  const availabilityString = `${dayOfWeek} - ${formattedStartTime} to ${formattedEndTime}\n`;

  console.log(availabilityString);

  if (!tutorDetailsAvailabilities[userId]) {
    tutorDetailsAvailabilities[userId] = []; // Initialize as an empty array
  }

  tutorDetailsAvailabilities[userId].push(availabilityString); // Append to the array
});

// Now, tutorDetailsAvailabilities will contain arrays of availability strings for each tutor
console.log(tutorDetailsAvailabilities);


// Function to open the modal
function openModal() {
  modalOverlay.style.display = "block";
  modal.style.display = "block";
}

// Function to close the modal
function closeModal() {
  modalOverlay.style.display = "none";
  modal.style.display = "none";
}

// Event listeners
// openModalBtn.addEventListener("click", openModal);
modalCloseBtn.addEventListener("click", closeModal);

const openModalList = []
document.addEventListener('click', function (event) {
  const allTargetAvailabilityText = document.querySelectorAll('.tutor-details-availability')
  if (event.target.matches('.contact-button')) {
    const targetModalId = event.target.getAttribute('data-target-modal');
    const targetModal = document.getElementById(`tutor-details-modal-${targetModalId}`);
    const targetAvailabilityText = document.getElementById(`tutor-details-availability-${targetModalId}`);



    if (targetModal) {
      tutorDetailsAvailabilities[targetModalId].forEach((item) => {
        targetAvailabilityText.innerHTML += `<p>${item}</p>`
      })
      targetModal.style.display = 'block';
      modalOverlay.style.display = 'block';
      openModalList.push(targetModalId);
    }
  } else if (event.target.matches('.tutor-details-modal-close')) {
    const targetModal = event.target.closest('.tutor-details-modal');

    if (targetModal) {
      targetModal.style.display = 'none';
      modalOverlay.style.display = 'none';
      openModalList.pop();

      allTargetAvailabilityText.forEach((item) => {
        item.innerHTML = '';
      })

    }
  } else if (event.target.matches('.tutor-details-modal-overlay')) {
    const targetModal = document.getElementById(`tutor-details-modal-${openModalList[0]}`);

    console.log(targetModal)

    if (targetModal) {
      targetModal.style.display = 'none';
      modalOverlay.style.display = 'none';
      openModalList.pop();

      allTargetAvailabilityText.forEach((item) => {
        item.innerHTML = '';
      })
    }
  }
});