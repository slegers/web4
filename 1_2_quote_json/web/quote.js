var xHRObject = new XMLHttpRequest();

function getNewQuote () {
	xHRObject.open("GET", "ManageQuoteServlet", true);
	xHRObject.onreadystatechange = getData;
	xHRObject.send(null);
}

function getData () {
	if (xHRObject.status == 200) {
		if (xHRObject.readyState == 4) {
			alert(xHRObject.responseText);
			var serverResponse = JSON.parse(xHRObject.responseText);
			var quote = serverResponse.quote; // of je kan ook doen: serverResponse["quote"]
	
			var quoteDiv = document.getElementById("quote");
			var quoteParagraph = quoteDiv.childNodes[0];
			
			if (quoteParagraph == null) {
				quoteParagraph = document.createElement('p');
				quoteParagraph.id = "quoteText";
				var quoteText = document.createTextNode(quote);
				quoteParagraph.appendChild(quoteText);
				quoteDiv.appendChild(quoteParagraph);
			}
			else {
				var quoteText = document.createTextNode(quote);
				quoteParagraph.removeChild(quoteParagraph.childNodes[0]);
				quoteParagraph.appendChild(quoteText);
			}	
		}
else {
	
}
	}
}