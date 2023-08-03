// change join button color
const join = document.getElementsByClassName('forum-button');

for (const element of join) {
    element.addEventListener('click', () => {

        const numOfMembers = document.getElementById("memberNumbers");
        const joinText = document.getElementById("join-text");
        let curCount = parseInt(numOfMembers.innerHTML);
        let joined = joinText.innerHTML;
        if(element.classList.contains('forum-join'))
        {
            element.classList.replace('forum-join', 'forum-joined');
            curCount++;
            joined = "joined";
            numOfMembers.innerHTML = curCount.toString();
            joinText.innerHTML = joined;
        }
        else
        {
            element.classList.replace('forum-joined', 'forum-join');
            curCount--;
            joined = "join";
            numOfMembers.innerHTML = curCount.toString();
            joinText.innerHTML = joined;
        }
    });
}