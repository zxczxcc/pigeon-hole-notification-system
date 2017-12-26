<?php
require "init.php";
$name=$_POST["name"];
$block=$_POST["block"];
$number=$_POST["number"];

$sql_query = "select block,number from position where lec_name like '$name';";

$res = mysqli_query($con,$sql_query);

if(mysqli_num_rows($res)>0)
{

	$row = mysqli_fetch_assoc($res);
	$block = $row["block"];
	$number = $row["number"];
	echo "cant save.. Data with name: ".$name." has already saved at block: ".$block." and number: ".$number;
}
else
{
	$sql_query = "select lec_name from position where block like '$block' and number like '$number';";
	$res = mysqli_query($con,$sql_query);
	if(mysqli_num_rows($res)>0)
{
	$row = mysqli_fetch_assoc($res);
	$names=$row["lec_name"];
	echo "cant save.. Data with block: ".$block." and number: ".$number." has already saved with name: ".$names;
}
else
{
	$sql_query2 = "insert into position values('$name','$block','$number','null');";
	mysqli_query($con,$sql_query2);
	echo "data saved";
}
}
?>