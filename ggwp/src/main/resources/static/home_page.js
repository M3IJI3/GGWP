function changeEmoji(element) {
    const emojis = ['&#x1F600;', '&#x1F603;', '&#x1F604;', '&#x1F601;', '&#x1F606;', '&#x1F605;',
                            '&#x1F923;', '&#x1F602;', '&#x1F642;', '&#x1F643;', '&#x1F609;', '&#x1F60A;',
                            '&#x1F607;', '&#x1F970;', '&#x1F60D;', '&#x1F929;', '&#x1F618;', '&#x1F617;',
                            '&#x1F61A;', '&#x1F619;', '&#x1F60B;', '&#x1F61B;', '&#x1F61C;', '&#x1F92A;',
                            '&#x1F61D;', '&#x1F911;', '&#x1F917;', '&#x1F92D;', '&#x1F92B;', '&#x1F914;',
                            '&#x1F910;', '&#x1F928;', '&#x1F610;', '&#x1F611;', '&#x1F636;', '&#x1F60F;'];

    const randomIndex = Math.floor(Math.random() * emojis.length);
    element.innerHTML = emojis[randomIndex];
}

function openSelector() {
    const emojiPicker = document.getElementById('emoji-picker');
    emojiPicker.classList.toggle('hidden');
}


