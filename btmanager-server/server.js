var express  = require('express'), 
    bodyParser     =        require("body-parser"),
    admin = require('./admin'),
    message  = require('./routes/message')(admin),
    database  = require('./routes/database')(admin);

var app     = express();
var path =  require('path');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.post('/message', message.handleMessage);
app.post('/aloha', database.aloha);

// Start express

app.listen(process.env.PORT || 3000);
console.log('Server running.');

