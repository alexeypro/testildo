var http            =   require('http'),
    async           =   require('async'),
    mongoose        =   require('mongoose'),
    express         =   require('express'),
    SERVER_PORT     =   process.argv[2] || 8000, 
    MONGODB_DB      =   'testildodb', 
    MONGODB_USER    =   'testildouser', 
    MONGODB_PASS    =   'testildopwd', 
    MONGODB_URI     =   'mongodb://' + MONGODB_USER + ':' + MONGODB_PASS + '@ds031637.mongolab.com:31637/' + MONGODB_DB;


var TestJSRecord    =   new mongoose.Schema( { title : String, body : String } ),
    SELECT_COUNT    =   50,         // how mnay records to select on every /list call
    INSERT_COUNT    =   500;        // how many records to insert on every /insert call

console.log('Connecting to MongoDB; ' + MONGODB_URI + '...');
var mongoConn = mongoose.createConnection(MONGODB_URI);
var TestJSRecordModel = mongoConn.model('TestJSRecord', TestJSRecord);
console.log('Connected and model initialized!');

// make sure app is aware of all the global stuff
var app = express.createServer();

app.get('/', function(req, res){
    console.log('Request /');
    res.send('Hello World');
    console.log('Response to / was sent');
});

app.get('/save', function(req, res) {
    console.log('Request /save');
    res.send('Inserting random record');
    console.log('Response to /save was sent');
    var count = 0;
    async.whilst(
        function continueWhileTrue() { 
            return count < INSERT_COUNT; 
        },
        function executeTask(callback) {
            count++;
            var ts = Math.round((new Date()).getTime());
            var m = new TestJSRecordModel();
            m.title = 'random title ' + count + ' @ ' + ts;
            m.body = 'random body ' + count + ' @ ' + ts;
            m.save();            
            callback();
        },
        function doneExecution(err) {
            console.log('Finished inserting ' + count + ' record(s)!');
        }
    );    
});

app.get('/find', function(req, res){
    console.log('Request /find');
    var q = TestJSRecordModel.find( { } ).limit(SELECT_COUNT);
    q.execFind(function (err, result) {
        res.send(result);
        console.log('Response to /find was sent');
    });    
});

app.listen(SERVER_PORT);
console.log('http://localhost:' + SERVER_PORT + '/      - Hello World');
console.log('http://localhost:' + SERVER_PORT + '/save  - async save ' + INSERT_COUNT + ' record(s) into database');
console.log('http://localhost:' + SERVER_PORT + '/find  - find ' + SELECT_COUNT + ' record(s) in database');
