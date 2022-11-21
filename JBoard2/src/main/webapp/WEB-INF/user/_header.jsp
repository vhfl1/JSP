<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link rel="stylesheet" href="/JBoard2/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <style>
        #board > .list > form {
            float: right;
            margin-bottom: -14px;
        }

        #board > .list > form > input[name=search]{
            width: 200px;
            height: 26px;
            text-indent: 6px;
            border: 1px solid #d7d7d7;
        }
        #board > .list > form > input[type=submit]{
            border: 1px solid #d7d7d7;
            background: #f2f2f2; 
            color: #111;
            padding: 6px;
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <header>
            <h3>Board System v1.0</h3>
            
        </header>
        