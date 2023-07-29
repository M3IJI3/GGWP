const actions = document.querySelectorAll(".action");
const icons = document.querySelectorAll(".action i");

// Loop through all the action buttons except the last one because that one has fa variations

for (let i = 0; i < actions.length - 1; i++) {
  actions[i].addEventListener("click", () => {
    if (icons[i].classList.contains("far")) {
      icons[i].classList.replace("far", "fas");
    } else {
      icons[i].classList.replace("fas", "far");
    }
  });
}
