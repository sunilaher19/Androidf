<?php
 
/**
 * A class file to connect to database
 */
class DB_CONNECT {
 
    // constructor
    function __construct() {
        // connecting to database
        $this->connect();
    }
 
    // destructor
    function __destruct() {
        // closing db connection
        $this->close();
    }
 
    /**
     * Function to connect with database
     */
    function connect() {
        // import database connection variables
        require_once __DIR__ . '/db_config.php';
 
        // Connecting to <a href="#">mysql</a> database
        $con = <a href="#">mysql</a>_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(<a href="#">mysql</a>_error());
 
        // Selecing database
        $db = <a href="#">mysql</a>_select_db(DB_DATABASE) or die(<a href="#">mysql</a>_error()) or die(<a href="#">mysql</a>_error());
 
        // returing connection cursor
        return $con;
    }
 
    /**
     * Function to close db connection
     */
    function close() {
        // closing db connection
        <a href="#">mysql</a>_close();
    }
 
}
 
?>