var http        =   require('http'),    
    SERVER_PORT =   8181;

console.log('Open http://localhost:' + SERVER_PORT + ' in the browser to see this server in work');
http.createServer(function (req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World!');
    console.log('Request came in!');
}).listen(SERVER_PORT);
