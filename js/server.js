var http            =   require('http'),
    async           =   require('async'),
    mongoose        =   require('mongoose'),
    express         =   require('express'),
    SERVER_PORT     =   8181, 
    MONGODB_DB      =   'testildodb', 
    MONGODB_USER    =   'testildouser', 
    MONGODB_PASS    =   'testildopwd', 
    MONGODB_URI     =   'mongodb://' + MONGODB_USER + ':' + MONGODB_PASS + '@ds031637.mongolab.com:31637/' + MONGODB_DB;


var TestJSRecord    =   new mongoose.Schema( { title : String, body : String } ),
    INSERT_COUNT    =   500;      // how many records to insert on every /insert call

console.log('Connecting to MongoDB; ' + MONGODB_URI + '...');
var mongoConn = mongoose.createConnection(MONGODB_URI);
var TestJSRecordModel = mongoConn.model('TestJSRecord', TestJSRecord);
console.log('Connected and model initialized!');

// make sure app is aware of all the global stuff
var app = express.createServer();
app._connections = { 'mongoConn': mongoConn };
app._models = { 'TestJSRecordModel': TestJSRecordModel };

app.get('/', function(req, res){
    console.log('Request /');
    res.send('Hello World');
});

app.get('/insert', function(req, res) {
    console.log('Request /insert');
    res.send('Inserting random record');
    // TODO: generate a bunch of random models
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

app.listen(SERVER_PORT);
console.log('Open http://localhost:' + SERVER_PORT + ' in the browser to see this server in work');
