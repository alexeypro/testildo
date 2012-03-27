var http            =   require('http')
  , mongoose        =   require('mongoose')
  , express         =   require('express')
  , SERVER_PORT     =   8181
  , MONGODB_DB      =   'testildodb'
  , MONGODB_USER    =   'testildouser'
  , MONGODB_PASS    =   'testildopwd'
  , MONGODB_URI     =   'mongodb://' + MONGODB_USER + ':' + MONGODB_PASS + '@ds031637.mongolab.com:31637/' + MONGODB_DB
  , Schema          =   mongoose.Schema;


console.log('Connecting to MongoDB; ' + MONGODB_URI + '...');
var mongoConn = mongoose.createConnection(MONGODB_URI);
console.log('Connected!');

// ---
var TestRecord = new Schema({
    title     : String
  , body      : String
});
mongoConn.model('TestRecord', TestRecord);
// TODO: generate a bunch of random models
var m = new TestRecord();
m.title = 'random title 1';
m.body = 'random body 1';
m.save();
// ---

var app = express.createServer();

app.get('/', function(req, res){
    console.log('request /');
    res.send('Hello World');
});

app.get('/insert', function(req, res){
    console.log('request /insert');
    res.send('Inserting random record');
});

app.listen(SERVER_PORT);
console.log('Open http://localhost:' + SERVER_PORT + ' in the browser to see this server in work');
