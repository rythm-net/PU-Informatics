//  USER_CLICK_ON_SHAPE

var PubSub              = {};
PubSub.eventCollection  = {};

PubSub.publish = function(topic, data) {
    (this.eventCollection[topic])(data);
};


PubSub.subscibe = function(topic, actCollback) {
    this.eventCollection[topic] = actCollback;
};

// 
// PubSub.publish('USER_CLICK_ON_SHAPE', dataObject);
// 
// 
// PubSub.subscribe('USER_CLICK_ON_SHAPE', function(data) {
//  console.log("Hello user");
// });