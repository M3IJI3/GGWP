const heartButtons = document.querySelectorAll(".heart-icon");
heartButtons.forEach((heartButton) => {
  heartButton.addEventListener("click", () => {
    if (heartButton.classList.contains("fa-regular")) {
      heartButton.classList.replace("fa-regular", "fa-solid");
    } else {
      heartButton.classList.replace("fa-solid", "fa-regular");
    }

    heartButton.classList.add("heart-icon-scale");

    setTimeout(() => {
      heartButton.classList.remove("heart-icon-scale");
    }, 300);
  });
});
