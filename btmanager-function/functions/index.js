// The Cloud Functions for Firebase SDK to create Cloud Functions and setup triggers.
const functions = require('firebase-functions');

// The Firebase Admin SDK to access the Firebase Realtime Database.
const admin = require('firebase-admin');
admin.initializeApp();

admin.initializeApp(functions.config().firebase, "firestore");
var db = admin.firestore();
const settings = {timestampsInSnapshots: true};
db.settings(settings);

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });

function postFcmDataMessage(receipientToken, data) {
  var message = {
        "token" : receipientToken,
        "data" : data
      };
  var f = admin.messaging().send(message);
  console.log("sent message "+message+" to "+receipientToken);
  return f;
}
  
function log(status,x) {
  console.log(status,x);
}

exports.disconnectBTDevice = functions.https.onRequest((req, res) => {
  // Grab the address parameter.
  const address = req.query.address;
  // get user id
  const userid = req.query.userid;
  // fetch data from db
  db.collection('users').doc(userid).get()
    .then(doc => {
      if (!doc.exists) {
        console.log('No such document!');
        res.send("error");
        return "error";
      } else {
        console.log('Document data:', doc.data());
        res.send(doc.data());
        var registrationTokens = doc.data().registrationTokens;
        var promises=[];
        for (var i = 0; i < registrationTokens.length; i++) {
          var registrationToken = registrationTokens[i];
          promises[i] = postFcmDataMessage(registrationToken, {"command": "bluetooth.enable"});
        }
        return Promise.all(promises);
      }
    })
    .then(results => {
      console.log(results);
      return "ok";
    })
    .catch(err => {
      console.log('Error getting document', err);
    });
});

