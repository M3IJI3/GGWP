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

// change like button color
const homePostHeart = document.getElementsByClassName('home-post-like');

for (const element of homePostHeart) {
    element.addEventListener('click', () => {

        const numOfLikes = element.nextElementSibling;
        let curCount = parseInt(numOfLikes.innerHTML);

        if(element.classList.contains('bx-heart'))
        {
            element.classList.replace('bx-heart', 'bxs-heart');
            curCount++;
            numOfLikes.innerHTML = curCount.toString();
        }
        else
        {
            element.classList.replace('bxs-heart', 'bx-heart');
            curCount--;
            numOfLikes.innerHTML = curCount.toString();
        }
    });
}

// click comment button and display dropdown list
const commentButtons = document.querySelectorAll('.home-post-comment');
const commentDropDowns = document.querySelectorAll('.comment-dropdown')
commentButtons.forEach((element, index) => {
    element.addEventListener('click', () => {
        commentDropDowns[index].classList.toggle('show');
        commentDropDowns[index].style.animationName = 'expandAnimation';

    });
});

// display counter when input is clicked
// function displayCounter(){
//     const charCountElement = document.getElementById('cmt-char-count');
//     charCountElement.classList.remove('hidden');
// }

// listen the number of characters
const commentInput = document.getElementById('commentInput')
const charCountElement = document.getElementById('cmt-char-count');
const maxWordCount = 150;

const commentSendBtn = document.getElementById('cmt-send-btn');
commentInput.addEventListener('input', () => {
    const text = commentInput.value.trim();
    const words = text.split(/\s+/).filter(word => /^[A-Za-z]+$/.test(word)); // 过滤包含英文字符的单词
    const charCount = words.length;

    if (charCount > maxWordCount)
    {
        commentSendBtn.classList.add('limit-exceeded');
    }

    charCountElement.textContent = `${charCount} / ${maxWordCount}`;
});

// text editor



