<?php
require "init.php";

$name=$_POST["name"];
// $name="qwe";
$sql_query = "select lec_mail from position where lec_name like '$name';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{
	$row = mysqli_fetch_assoc($res);
	$email = $row["lec_mail"];
	echo "success =".$name."=".$email;
}
else
{

	echo "xjadi";
}


?>