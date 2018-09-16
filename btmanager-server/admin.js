var project = "btmanager-16eca";

var admin = require('firebase-admin');
var serviceAccount = require('./service-account.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: 'https://'+project+'.firebaseio.com'
});

module.exports = admin;
