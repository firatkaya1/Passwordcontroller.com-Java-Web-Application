<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <title>Password Controller - Payment Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/css/swiper.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/css/swiper.min.css'>
    <link rel="stylesheet" href="css/style-payment.css">

</head>
<body>
<section class="modal open">
    <div class="wrapper">
        <div class="container">
            <span class="icon-close"></span>
            <div class="left">
                <div class="details">
                    <article>
                        <h2 class="title">Details</h2>
                    </article>
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide"><img src="img/table.svg" alt="Payment Picture"></div>
                        </div>
                    </div>
                    <article>
                        <h3 class="product">Password Controller</h3>
                        <h4>Your Shopping Cart</h4>
                        <p class="type">Medium Package</p>
                        <p class="total">Total</p>
                        <p class="price">$5.99</p>
                    </article>
                </div>
            </div>
            <div class="right">
                <div class="form">
                    <h2 class="title">Checkout</h2>
                    <form>
                        <div class="input-wrapper">
                            <label for="">Payment Method</label>
                            <select name="cards">
                                <option value="visa">Visa</option>
                                <option value="mastercard">Mastercard</option>
                                <option value="americanexpress">American Express</option>

                            </select>
                        </div>

                        <div class="input-wrapper">
                            <label for="">Cardholder's name</label>
                            <input id="name" type="text" placeholder="Name">
                        </div>

                        <div class="input-wrapper">
                            <label for="number">Card Number</label>
                            <input id="number" type="text" placeholder="XXXX-XXXX-XXXX-XXXX">
                        </div>

                        <div class="double">
                            <label for="date">Expiration Date</label>
                            <div class="double-input">
                                <div class="input-wrapper">
                                    <input id="dateM" type="number" placeholder="Month" minlength="0" maxlength="2">
                                </div>

                                <div class="input-wrapper">
                                    <input id="dateY" type="number" placeholder="Year" minlength="0" maxlength="4">
                                </div>
                            </div>
                        </div>
                        <div class="double">
                            <label for="date">Card Security Code</label>
                            <div class="double-input">
                                <div class="input-wrapper">
                                    <input id="date" type="number" placeholder="Code" maxlength="3" minlength="0" pattern="^\d{1,3}$">
                                </div>
                            </div>
                        </div>
                    </form>
                    <button class="btn"><span><a href="error.jsp">Confirm Order</a></span></button>
                </div>
            </div>
        </div>
    </div>
</section>

<script src='https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/js/swiper.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.0/js/swiper.min.js'></script>
<script src="js/payment.js"></script>

</body>
</html>