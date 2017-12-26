<?php
require "init.php";
$name=$_POST["user"];
$user_name=$_POST["user_name"];
$pass_word=$_POST["pass_word"];

$sql_query = "insert into userprofile values('$name','$user_name','$pass_word');";

if(mysqli_query($con,$sql_query))
{

	//echo "<h3>input</h3>";
}
else
{

	//echo "error";
}


?>