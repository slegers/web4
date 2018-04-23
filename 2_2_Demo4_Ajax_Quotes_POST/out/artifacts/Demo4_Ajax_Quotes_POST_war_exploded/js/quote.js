var quotebutton = document.getElementById('quotebutton');
quotebutton.onclick = addQuote;

var getNewQuoteRequest = new XMLHttpRequest();
var newQuoteRequest = new XMLHttpRequest();

function addQuote () {
    var quoteText = document.getElementById("quotetext").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    var information = "quote=" + encodeURIComponent(quoteText);
    newQuoteRequest.open("POST", "ManageQuoteServlet", true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    newQuoteRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newQuoteRequest.send(information); // quote=XXX
}

function getNewQuote () {
	getNewQuoteRequest.open("GET", "ManageQuoteServlet", true);
	getNewQuoteRequest.onreadystatechange = getData;
	getNewQuoteRequest.send(null);
}

function getData () {
	if (getNewQuoteRequest.readyState == 4) {
		if (getNewQuoteRequest.status == 200) {
			var serverResponse = JSON.parse(getNewQuoteRequest.responseText);
			var quoteXML = serverResponse.quote;
			
			var quoteDiv = document.getElementById("quote");
			var quoteParagraph = quoteDiv.childNodes[0];
			
			if (quoteParagraph == null) {
				quoteParagraph = document.createElement('p');
				quoteParagraph.id = "quoteText";
				var quoteText = document.createTextNode(quoteXML);
				quoteParagraph.appendChild(quoteText);
				quoteDiv.appendChild(quoteParagraph);
			}
			else {
				var quoteText = document.createTextNode(quoteXML);
				quoteParagraph.removeChild(quoteParagraph.childNodes[0]);
				quoteParagraph.appendChild(quoteText);
			}
			setTimeout("getNewQuote()", 1000);
		}
	}
}