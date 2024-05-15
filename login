<!DOCTYPE html>
<html>
<head>
    <title>物流管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }

        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-container button:hover {
            background-color: #45a049;
        }

        .result-container {
            margin-top: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
    </style>
    <script>
        function login() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;

            // TODO: 发送登录请求到后端

            // 假设登录成功，显示结果
            displayResult("登录成功！用户名：" + username);
            console.log("登录成功！");
            window.location.href = "file:///E:/code/.vscode/wuliu/index.html";
        }

        function displayResult(result) {
            var resultContainer = document.getElementById("resultContainer");
            resultContainer.innerHTML = result;
        }
    </script>
</head>
<body>
    <h1>物流管理系统</h1>

    <div class="form-container">
        <h2>用户登录</h2>
        <input type="text" id="username" placeholder="用户名">
        <input type="password" id="password" placeholder="密码">
        <button onclick="login()">登录</button>
    </div>

    <div class="result-container" id="resultContainer"></div>
    <div><img src="C:\Users\17813\OneDrive\图片\Saved Pictures\test.jpg" width="200px" height="200px" ></div>
</body>
</html>
