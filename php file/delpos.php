<?php
require "init.php";

$user_name=$_POST["lec_name"];

$sql_query = "select block,number from position where lec_name like '$user_name';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{
	$sql_query = "delete from position where lec_name like '$user_name';";
	$res = mysqli_query($con,$sql_query);
	echo "data deleted";
}
else
{

	echo "data not found";
}


?>