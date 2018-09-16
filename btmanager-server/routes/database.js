module.exports = function (admin) {

  const {google} = require('googleapis');

  var database = {};

  database.aloha = function(request,response) {
    var idToken = request.body.idToken;
    // check that the request is legitimate (see https://firebase.google.com/docs/auth/admin/verify-id-tokens)
    admin.auth()
      .verifyIdToken(idToken)
      .then(function(decodedToken) {
        var uid = decodedToken.uid;
        var bluetoothDevices = request.body.bluetoothDevices;
        console.log("user "+idToken+" reports that device "+request.body.registrationToken+" is paired with "+bluetoothDevices);
        // add the list of bluetooth devices to the user's device list in the database

        // broadcast the update to all registered devices

        response.end({status:"ok"});
      }).catch(function(error) {
        // Handle error
      });

  }

  return database;
}
