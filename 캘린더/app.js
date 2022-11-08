const express = require("express");
const app = express();

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
  });
  app.use(express.static('css'));
  app.use(express.static('image'));
  app.use(express.static('js'));
  app.use(express.static('vendor'));
  app.use(express.static('app.js'));

  app.listen(3000, () => {
    console.log("listening on *:3000");
});