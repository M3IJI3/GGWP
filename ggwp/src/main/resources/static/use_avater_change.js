function openFileInput() {
    // 触发文件选择框的点击事件
    document.getElementById('fileInput').click();
}

function handleFileSelect(event) {
    const file = event.target.files[0];
    if (file) {
        // 在这里可以对文件进行处理，例如上传到服务器
        const reader = new FileReader();
        reader.onload = function(e) {
            const userAvatar = document.getElementById('userAvatar');
            userAvatar.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
}
