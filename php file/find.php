<?php
require "init.php";

$user_name=$_POST["lec_name"];

$sql_query = "select block,number from position where lec_name like '$user_name';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{

	$row = mysqli_fetch_assoc($res);
	$block = $row["block"];
	$number = $row["number"];
	echo "block: ".$block." | number: ".$number;
}
else
{

	echo "block: no data | number:no data";
}


?>