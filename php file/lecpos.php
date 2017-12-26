<?php
require "init.php";
$name=$_POST["name"];
$block=$_POST["block"];
$number=$_POST["number"];

$sql_query = "insert into position values('$name','$block','$number');";

if(mysqli_query($con,$sql_query))
{

	//echo "<h3>input</h3>";
}
else
{

	//echo "error";
}


?>