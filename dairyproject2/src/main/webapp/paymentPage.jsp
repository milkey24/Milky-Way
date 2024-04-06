<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Page</title>
<style>
  /* CSS Styles */
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: lightblue;
  }

  .container {
    max-width: 600px;
    margin: 80px auto; /* Adjust margin to accommodate the navbar */
    padding: 20px;
    background-color: #fff;
    border-radius: 12px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  }

  h1 {
    text-align: center;
    color: #333;
    text-transform: uppercase;
    letter-spacing: 2px;
    margin-bottom: 30px;
  }

  .price-container {
    margin-bottom: 20px;
  }

  .total-price {
    font-weight: bold;
    font-size: 1.2em;
    color: #f39c12;
  }

  .payment-button {
    padding: 10px 20px;
    border: none;
    background-color: #3498db;
    color: white;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    display: block;
    margin: 20px auto 0;
    text-align: center;
    text-decoration: none;
  }

  .payment-button:hover {
    background-color: #2980b9;
  }
</style>
</head>
<body>

<div class="container">
  <h1>Payment Details</h1>
  <div class="price-container">
    <p>Total Price: <span id="totalPrice"></span></p>
  </div>
  <button class="payment-button" onclick="processPayment()">Proceed to Payment</button>
</div>

<script>
  function processPayment() {
    // Get the price query parameters from the URL
    const urlParams = new URLSearchParams(window.location.search);
    const prices = urlParams.getAll('price');

    let totalPrice = 0;
    for (let price of prices) {
      totalPrice += parseFloat(price);
    }

    const totalPriceElement = document.getElementById('totalPrice');

    // Update the total price on the payment page
    totalPriceElement.textContent = '$' + totalPrice.toFixed(2);
  }
  
  // Call processPayment function when the page loads
  processPayment();
</script>

</body>
</html>