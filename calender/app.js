const express = require("express");
const app = express();

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
  });
  app.use('/', (req, res) => express.static(__dirname, './css')); 
  app.use('/', (req, res) => express.static(__dirname, './image'));
  app.use('/', (req, res) => express.static(__dirname, './js'));
  app.use('/', (req, res) => express.static(__dirname, './vendor'));   
app.listen(3000, () => {
  console.log("listening on *:3000");
});