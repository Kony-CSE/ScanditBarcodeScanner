//Type your code here
function onScanComplete(result) {
  kony.print(JSON.stringify(result));
  frmStartup.lblScanInfo.text=result;
}

function onBtnScanBarCode() {
  var key = "5QUxtFesM/dvalg0KpF1Q3TtD6XfCDky8MRYwMUCjvc";
  BarcodeScannerNamespace.startScanning(
		/**String*/ key, 
		/**Function*/ onScanComplete);
}