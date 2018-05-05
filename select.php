<?php
require "con1.php";
$user_name= $_POST["usr"];
$user_pass= $_POST["pass"];
//$user_name= "123";
//$user_pass= "234";

$mysql_qry = "select * from login where Uname = $user_name and password = $user_pass";
$result = mysqli_query($con ,$mysql_qry);
if(mysqli_num_rows($result) > 0) {
		$row=mysqli_fetch_row($result);
	 echo "Login suceed '$row[0]'  --> '$row[1]'  --> '$row[2]' ";
}
else 
{
echo "login not successd  '$user_pass'  --> '$user_name'";
}
?>
