<?php
$db_name="fypdb";
$mysql_user="root";
$mysql_pass="";
$server_name="localhost";

$con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);

if(!$con)
	{//echo "connection error..".mysqli_connect_error();
}
else
{
	//echo "<h3>db success</h3>";
}

?>