// import { createPicker } from 'picmo'


const rootElement = document.querySelector('.emoji-container');
const picker = createPicker({rootElement})

picker.addEventListener('emoji:select', event=>{
    console.log("selected", event.emoji)
});