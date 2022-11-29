var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost:3306',
  user     : 'wnstjq',
  password : 'zz1313',
  database : 'eventdata'
});

function save(title, start, end, color, description){
  connection.connect();
  
  var sql =  'INSERT INTO eventdata (title, start, end, color, description) values(?,?,?,?,?)';
  var params = [eventData]
  
  connection.end();
} 