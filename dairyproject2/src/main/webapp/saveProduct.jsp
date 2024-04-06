<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-image: url('https://cdn.wallpapersafari.com/53/74/1WbBzA.jpg');
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 400px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h1>Add Product</h1>

<form id="add-product-form" action="product_add" method="post">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name">
    
    <label for="price">Price:</label>
    <input type="number" id="price" name="price">
    
    <label for="category">Category:</label>
    <input type="text" id="category" name="category">
    
    <label for="brand">Brand:</label>
    <input type="text" id="brand" name="brand">
    
    <label for="brand">Image Link:</label>
    <input type="text" id="imageLink" name="imageLink">
    
    <button type="submit">Add Product</button>
</form>

</body>
</html>