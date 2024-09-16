<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        box-sizing: border-box;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .alert {
        color: red;
        text-align: center;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #555;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 12px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="checkbox"] {
        margin-right: 10px;
    }
    button {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 4px;
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        cursor: pointer;
        margin-top: 10px;
    }
    button:hover {
        background-color: #45a049;
    }
    .container.cancelbtn {
        background-color: #f44336;
        margin-top: 0;
    }
    .container.cancelbtn:hover {
        background-color: #e53935;
    }
    .psw {
        text-align: center;
        margin-top: 10px;
    }
    .psw a {
        color: #2196F3;
        text-decoration: none;
    }
    .psw a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="/maven-sample/login" method="post">
            <c:if test="${alert != null}">
                <div class="alert">${alert}</div>
            </c:if>
            <label for="uname">Username</label>
			<input type="text" placeholder="Tài khoản" name="username" required>
            
            <label for="psw">Password</label>
			<input type="password" placeholder="Mật khẩu" name="password" required>

            
            <label>
                <input type="checkbox" name="remember"> Remember me
            </label>
            
            <button type="submit">Login</button>
            <button type="button" class="cancelbtn">Cancel</button>
            
            <div class="psw">
                Forgot <a href="#">password?</a>
            </div>
        </form>
    </div>
</body>
</html>
