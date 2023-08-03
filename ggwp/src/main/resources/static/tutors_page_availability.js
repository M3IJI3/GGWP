const availabilityIconsParent = document.querySelectorAll(".availability-icons")

const tutorIds= []

availabilityIconsParent.forEach((item) => {
    tutorIds.push(item.getAttribute("data-tutor-id"));
})

// console.log(tutorIds)

// // Create an object to store user availabilities
const tutorAvailabilities = {};

// Group availabilities by user ID
availabilities.forEach((availability) => {
    const userId = availability.tutorId;
    const dayOfWeek = availability.dayOfWeek;

    if (!tutorAvailabilities[userId]) {
        tutorAvailabilities[userId] = [];
    }

    tutorAvailabilities[userId].push(dayOfWeek);
});


for (let i = 0; i < tutorIds.length; i++) {
    const tutorId = tutorIds[i];
    const icons = [];

    availabilityIconsParent.forEach(item => {
        if (tutorId === item.getAttribute("data-tutor-id")) {
            const elementNodes = Array.from(item.childNodes).filter(node => node.nodeType === 1);
            icons.push(...elementNodes); // Spread the element nodes into the 'icons' array
        }
    });

    const tutorAvailability = tutorAvailabilities[tutorId];

    if (tutorAvailability) {
        icons.forEach((icon, index) => {
            const dayOfWeek = icon.getAttribute("data-day-of-week");


            if (tutorAvailability.includes(dayOfWeek)) {
                icon.style.color = "#ff004f";
                icon.style.border = "1px solid #ff004f";
            }
        });
    }
}


