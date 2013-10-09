var dialer = {
	createEvent: function(telNumber, successCallback, errorCallback) {
		cordova.exec(
			successCallback, // success callback function
			errorCallback, // error callback function
			'Dialer', // mapped to our native Java class called "Dialer"
			'call', // with this action name
			[telNumber]
		);
	}
}
module.exports = dialer;