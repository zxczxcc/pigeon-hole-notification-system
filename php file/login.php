<?php
require "init.php";

$user_name=$_POST["log_name"];
$pass_word=$_POST["log_pass"];

$sql_query = "select name from userprofile where user_name like '$user_name' and pass_word like '$pass_word';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{

	$row = mysqli_fetch_assoc($res);
	$name = $row["name"];
	echo "login success.. welcome ".$name;
}
else
{

	echo "Login fail";
}


?>