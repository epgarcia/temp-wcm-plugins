var integration = require('integration');
var load = require('load-script');

var tracks = [];

/**
 * Expose plugin.
 */

module.exports = exports = function (analytics) {
  analytics.addIntegration(LiferayAnalytics);
};

/**
 * Expose `Liferay Analytics`
 */

var LiferayAnalytics = exports.Integration = integration('Liferay Analytics')
  .readyOnInitialize()
  .option('themeDisplay', themeDisplay)
  .option('anonymousUserId', '')

/**
 * Track.
 */

LiferayAnalytics.prototype.track = function(track){
	tracks.push(track);
};

/**
 * Load conversion.
 */

function flush(){
   // Build the post string from an object
  var post_data = querystring.stringify({
      'tracks': this.tracks,
	  'themeDisplay' : this.themeDisplay,
	  'anonymousUserId' : this.anonymousUserId
  });

  // An object of options to indicate where to post to
  var post_options = {
      host: 'localhost',
      port: '8080',
      path: '/analytics-hook/track',
      method: 'POST',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Content-Length': post_data.length
      }
  };

  // Set up the request
  var post_req = http.request(post_options, function(res) {
      res.setEncoding('utf8');
      res.on('data', function (chunk) {
          console.log('Response: ' + chunk);
      });
  });

  // post the data
  post_req.write(post_data);
  post_req.end();

	this.tracks.length = 0;
};

setInterval(function(){flush()}, 1000);