const hearts = document.querySelectorAll(".not-found-heart-icon");
const refillHeathBtn = document.querySelector(".refill-btn");

refillHeathBtn.addEventListener("click", () => {
  hearts.forEach((heart) => {
    heart.style.color = "#ff6b6b";
    heart.classList.replace("fa-regular", "fa-solid");
    heart.classList.remove("shaking");
  });
});
