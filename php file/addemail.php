<?php
require "init.php";
$name=$_POST["name"];
$email=$_POST["email"];

$sql_query = "select block,number from position where lec_name like '$name';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{

	if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {echo "Invalid email format";}
	else{
	$sql_query2 = "update position set lec_mail = '$email' where lec_name like '$name';";
	mysqli_query($con,$sql_query2);
	echo "data saved";
	}
}
else
{
	echo "name:".$name." is not found.";
}
?>