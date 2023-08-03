const editorSubmitBtn = document.querySelector('.editor-submit-btn');

editorSubmitBtn.addEventListener('click', () => {
    const textEditorContent = tinymce.get("mytextarea").getContent();
    var plainContent = tinymce.get("mytextarea").getContent({ format: "text" });

    // Send the content to the server using the fetch API
    fetch(`http://localhost:8082/forum/${currentGameTitle}/createPost`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ content: textEditorContent, plainContent })
    })
        .then(response => response.json())
        .then(data => {
            // Handle the JSON response from the server
            if (data.redirectUrl) {
                // Redirect to the specified URL
                window.location.href = data.redirectUrl;
            } else {
                // Handle any other response data if needed
                console.log(data);
            }
        })
        .catch(error => {
            // Handle any errors that occurred during the fetch
            console.error('Error:', error);
        });
});
