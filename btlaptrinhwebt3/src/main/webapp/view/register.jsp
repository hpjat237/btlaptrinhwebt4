<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f2f2f2;
    }
    .container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        margin-top: 50px;
        max-width: 600px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .alert {
        margin-bottom: 20px;
    }
    .registerbtn {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin-top: 10px;
        cursor: pointer;
        border-radius: 5px;
    }
    .registerbtn:hover {
        background-color: #45a049;
    }
    .signin {
        margin-top: 20px;
    }
    .signin a {
        color: #007bff;
    }
    .signin a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Register</h1>
    <p class="text-center">Please fill in this form to create an account.</p>
    <hr>
    <form action="/maven-sample/register" method="post">
        <c:if test="${alert != null}">
            <div class="alert alert-danger" role="alert">
                ${alert}
            </div>
        </c:if>
        <div class="form-group">
            <label for="uname">Username</label>
            <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" required>
        </div>
        <div class="form-group">
            <label for="fullname">Fullname</label>
            <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter Fullname" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter Phone" required>
        </div>
        <div class="form-group">
            <label for="psw">Password</label>
            <input type="password" class="form-control" id="psw" name="psw" placeholder="Enter Password" required>
        </div>
        <div class="form-group">
            <label for="psw-repeat">Repeat Password</label>
            <input type="password" class="form-control" id="psw-repeat" name="psw-repeat" placeholder="Repeat Password" required>
        </div>
        <button type="submit" class="registerbtn">Register</button>
    </form>
    <div class="signin text-center">
        <p>Already have an account? <a href="/maven-sample/login">Sign in</a>.</p>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
