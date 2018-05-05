<?php
require "con1.php";
//$productName= $_POST["usr"];
//$productprice= $_POST["usr"];
//$productquantity= $_POST["usr"];
$Uname = $_POST["usr"];
$password = $_POST["pass"];
$type = "User";
$status = "false";
$Que1 = $_POST["Q1"];
$Que2 = $_POST["Q2"];

$mysql_qry = "INSERT INTO login values ('$Uname','$password','$type','$status','$Que1','$Que2')";

echo "data is ",$mysql_qry ;

if($con->query($mysql_qry) == TRUE)
{
	echo "New record created successfully";	
}
else{
	echo "Error: ";
}



//if( !mysqli_query($con ,$mysql_qry)) {
//	echo "Insertion Unsucessfull" ,mysql_error();
//}
//else 
//{
//	echo "1 record inserted" ;
//}
?>
