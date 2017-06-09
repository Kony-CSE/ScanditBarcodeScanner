function onScanComplete(result) {
  kony.print(JSON.stringify(result));
  frmStartup.lblScanInfo.text=result;
}

function onBtnScanBarCode() {
  var key = "5QUxtFesM/dvalg0KpF1Q3TtD6XfCDky8MRYwMUCjvc";
  ScanditNS.invokeAAR(
		/**String*/ key, 
		/**Function*/ onScanComplete);
}