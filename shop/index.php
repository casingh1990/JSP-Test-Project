<?php 
require_once "Shop.class.php";
?>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  <head>
    <meta charset="UTF-8">
    <title></title>
  </head>
  <body>
    <?php
    
    $shop = new Shop();
    echo $shop->buy(1000, 15, 9000) . "<br />";
    echo $shop->buy(1000, 10, 5000) . "<br />";
    echo $shop->buy(1000, 5, 7000) . "<br />";
    echo "<br />Selling 5<br />";
    echo $shop->sell(2000, 5) . "<br />";
    echo "<br />Selling 10<br />";
    echo $shop->sell(6000, 10) . "<br />";
    ?>
  </body>
</html>
