var https = require('https')
 //const request = require('request');
exports.handler = function (request, context) {
	console.log("name "+request.directive.header.name);
	console.log("namespace "+request.directive.header.namespace);
	
    if (request.directive.header.namespace === 'Alexa.Discovery' && request.directive.header.name === 'Discover') {
        log("DEBUG:", "Discover request",  JSON.stringify(request));
        handleDiscovery(request, context, "");
    }
    else if (request.directive.header.namespace === 'Alexa.PowerController') {
        if (request.directive.header.name === 'TurnOn' || request.directive.header.name === 'TurnOff') {
            log("DEBUG:", "TurnOn or TurnOff Request", JSON.stringify(request));
            handlePowerControl(request, context);
        }
	}
		 else if (request.directive.header.namespace === 'Alexa') {
        if (request.directive.header.name === 'ReportState') {
            log("DEBUG:", "ReportState Request", JSON.stringify(request));
            handleReportState(request, context);
        }
    }

 function handleDiscovery(request, context) {
	 
	 var token=request.directive.payload.scope.token;
//	 var appliances=getAppliances(token);
	 	//var payload={};
	//var endpoints=[];
                var endpoint = "https://www.autoiinnovations.com/Test/rest/utility/getAllDevices/"+token;
                console.log(endpoint);
              var body ="";
               var chunk="";
            
                https.get(endpoint,(response) => {
              response.on('data', (chunk) => { body += chunk })
              response.on('end', () => {
                var data = JSON.parse(body)
				  var arr=data.response;
				  var endpoints=[];
				  var payload={};
				  	console.log((arr.length));
				  for(i=0;i<arr.length;i++)
				  {
					  	console.log((arr[i]));
					 var temp={};
			temp.endpointId=arr[i].controllerId+"-"+arr[i].deviceId;
				temp.manufacturerName="Autoi Innovations";
				temp.friendlyName=arr[i].deviceName;
				temp.description=arr[i].controllerName+"'s "+arr[i].deviceName;
				var displayCategories=[];
				displayCategories[0]="SWITCH";
				temp.displayCategories=displayCategories;
				var capabilities=[];
				var secondary={};
				secondary.type="AlexaInterface";
				secondary.interface="Alexa";
				secondary.version="3";
				capabilities[0]=secondary;
				var primary={};
				primary.interface="Alexa.PowerController";
				primary.type="AlexaInterface";
				primary.version="3";
				//primary.proactivelyReported= true;
             // primary.retrievable= true;
				var primaryT={};
				primaryT.retrievable=true;
				primaryT.proactivelyReported=true;
				var primaryArray=[];
				var primaryArrayJ={};
				primaryArrayJ.name="powerState";
				primaryArray[0]=primaryArrayJ;
				primaryT.supported=primaryArray;
				primary.properties=primaryT;
				capabilities[1]=primary;
				temp.capabilities=capabilities;
				console.log(JSON.stringify(temp));
				endpoints[i]=temp;
				  }
				   payload.endpoints=endpoints;
				   var header = request.directive.header;
        header.name = "Discover.Response";
        log("DEBUG", "Discovery Response: ", JSON.stringify({ header: header, payload: payload }));
        context.succeed({ event: { header: header, payload: payload } });
				 
				  console.log(payload );
				  })
             
                
              })
//console.log("appliances "+appliances);
       
    }// handleDiscovery
    function log(message, message1, message2) {
        console.log(message + message1 + message2);
    }

    function handlePowerControl(request, context) {
        // get device ID passed in during discovery
        var requestMethod = request.directive.header.name;
        var responseHeader = request.directive.header;
        responseHeader.namespace = "Alexa";
        responseHeader.name = "Response";
        responseHeader.messageId = responseHeader.messageId + "-R";
        // get user token pass in request
        var requestToken = request.directive.endpoint.scope.token;
		var deviceId=request.directive.endpoint.endpointId;
        var powerResult;
        console.log(requestMethod + responseHeader + requestToken);

        if (requestMethod === "TurnOn") {

            // Make the call to your device cloud for control
            // powerResult = stubControlFunctionToYourCloud(endpointId, token, request);
            powerResult = "ON";
        }
       else if (requestMethod === "TurnOff") {
            // Make the call to your device cloud for control and check for success
            // powerResult = stubControlFunctionToYourCloud(endpointId, token, request);
            powerResult = "OFF";
        }
		  var endpoint = "https://www.autoiinnovations.com/Test/rest/utility/alexaSmartHome/"+powerResult+"/"+deviceId+"/"+requestToken;
                console.log(endpoint);
              var body ="";
               var chunk="";
            
                https.get(endpoint,(response) => {
              response.on('data', (chunk) => { body += chunk })
              response.on('end', () => {
        var contextResult = {
            "properties": [{
                "namespace": "Alexa.PowerController",
                "name": "powerState",
                "value": powerResult,
                "timeOfSample": "2017-09-03T16:20:50.52Z", //retrieve from result.
                "uncertaintyInMilliseconds": 50
            }]
        };
        var response = {
            context: contextResult,
            event: {
                header: responseHeader,
                endpoint: {
                    scope: {
                        type: "BearerToken",
                        token: requestToken
                    },
                    endpointId: deviceId
                },
                payload: {}
            }
        };
        log("DEBUG", "Alexa.PowerController ", JSON.stringify(response));
        context.succeed(response);      
			  })
				})
        
    }
	
	
	function handleReportState(request, context) {
        // get device ID passed in during discovery
        var requestMethod = request.directive.header.name;
        var responseHeader = request.directive.header;
        responseHeader.namespace = "Alexa";
        responseHeader.name = "StateReport";
        responseHeader.messageId = responseHeader.messageId + "-R";
        // get user token pass in request
        var requestToken = request.directive.endpoint.scope.token;
		var deviceId=request.directive.endpoint.endpointId;
        var powerResult;
		    var endpoint = "https://www.autoiinnovations.com/Test/rest/utility/getCurrentState/"+deviceId;
                console.log(endpoint);
              var body ="";
               var chunk="";
            
                https.get(endpoint,(response) => {
              response.on('data', (chunk) => { body += chunk })
              response.on('end', () => {
                var data = JSON.parse(body)
				  var currentStatus=data.status;
				 console.log(currentStatus);
        console.log(requestMethod + responseHeader + requestToken);
		  var contextResult = {
            "properties": [{
               "namespace": "Alexa.PowerController",
                "name": "powerState",
                "value": currentStatus,
                "timeOfSample": "2017-09-03T16:20:50.52Z", //retrieve from result.
                "uncertaintyInMilliseconds": 50
            }]
        };
 var response = {
            context: contextResult,
            event: {
                header: responseHeader,
                endpoint: {
                    scope: {
                        type: "BearerToken",
                        token: requestToken
                    },
                    endpointId: deviceId
                },
                payload: {}
            }
        };
		
          log("DEBUG", "Alexa.ReportState ", JSON.stringify(response));
		 context.succeed(response);   
						})
						
				})   
        
    }
	
	 function getAppliances(token) {
  // var accessToken = event.payload.accessToken
  console.log("token " +token);
 // var http = require('http')
	//var payload={};
	var endpoints=[];
                var endpoint = "https://www.autoiinnovations.com/Test/rest/utility/getAllDevices/"+token;
                console.log(endpoint);
              var body ="";
               var chunk="";
            
                https.get(endpoint,(response) => {
              response.on('data', (chunk) => { body += chunk })
              response.on('end', () => {
                var data = JSON.parse(body)
				  var arr=data.response;
				  var endpoints=[];
				  var payload={};
				  	console.log((arr.length));
				  for(i=0;i<arr.length;i++)
				  {
					  	console.log((arr[i]));
					 var temp={};
			temp.endpointId=arr[i].controllerId+arr[i].deviceId;
				temp.manufacturerName="Autoi Innovations";
				temp.friendlyName=arr[i].deviceName;
				temp.description=arr[i].deviceName;
				var displayCategories=[];
				displayCategories[0]=arr[i].deviceName;
				temp.displayCategories=displayCategories;
				var capabilities=[];
				var secondary={};
				secondary.type="AlexaInterface";
				secondary.interface="Alexa";
				secondary.version="3";
				capabilities[0]=secondary;
				var primary={};
				primary.interface="Alexa.PowerController";
				primary.type="AlexaInterface";
				primary.version="3";
				var primaryT={};
				primaryT.retrievable=true;
				var primaryArray=[];
				var primaryArrayJ={};
				primaryArrayJ.name="powerState";
				primaryArray[0]=primaryArrayJ;
				primaryT.supported=primaryArray;
				primary.properties=primaryT;
				capabilities[1]=primary;
				temp.capabilities=capabilities;
				console.log(JSON.stringify(temp));
				endpoints[i]=temp;
				  }
				  payload.endpoints=endpoints;
				  console.log(payload );
				  //return payload;
                //var price = data.response
             
              })
             
                
              })
           
	 }
// getSampleAppliances
};