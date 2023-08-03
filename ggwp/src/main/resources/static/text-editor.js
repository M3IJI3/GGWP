const editorSubmitBtn = document.querySelector('.editor-submit-btn');

editorSubmitBtn.addEventListener('click', () => {
    const textEditorContent = tinymce.get("mytextarea").getContent();

    // Send the content to the server using the fetch API
    fetch('http://localhost:8082/forum/createPost', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ content: textEditorContent })
    })
        .then(response => response.text())
        .then(data => {
            // Handle the server response if necessary
            console.log("Server response: ")
            console.log(data);
        })
        .catch(error => {
            // Handle any errors that occurred during the fetch
            console.error('Error:', error);
        });
});
