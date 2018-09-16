module.exports = function (admin) {
  const {google} = require('googleapis');

  var message = {}

  function postFcmDataMessage(receipientToken, data) {
  
    var message = {
          "token" : receipientToken,
          "data" : data
        };
  
    return admin.messaging().send(message);
  
  }
  
  message.handleMessage = function (request,response) {
    var receiverToken=request.body.receiverToken;
    var data=request.body.data;
    console.log("data="+data);
    postFcmDataMessage(receiverToken, data).then(function(end) {
      response.end("ok");
    })
    .catch(function(err) {
      response.status(500).send(err);
    });
  }

  return message;
}

