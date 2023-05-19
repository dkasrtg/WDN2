<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/TestFramework/cat-get" method="post" enctype="multipart/form-data">
    <p>Files:<input type="file" name="be" multiple></p>
    <p>FIle:<input type="file" name="kely" ></p>
    <p>Raw<input type="number" name="raw"></p>
    <p>Cara:
        <ul>
    <li>Cara1 <input type="checkbox" name="cara[]" value="cara1"></li>
    <li>Cara2 <input type="checkbox" name="cara[]" value="cara2"></li>
    <li>Cara3 <input type="checkbox" name="cara[]" value="cara3"></li>
</ul>
    </p>
    <button type="submit">OK</button>
</form>
</body>
</html>