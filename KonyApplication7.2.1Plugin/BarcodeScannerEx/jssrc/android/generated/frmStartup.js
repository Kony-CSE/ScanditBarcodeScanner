function addWidgetsfrmStartup() {
    frmStartup.setDefaultUnit(kony.flex.DP);
    var lblScanInfo = new kony.ui.Label({
        "id": "lblScanInfo",
        "isVisible": true,
        "left": "23dp",
        "skin": "slLabel",
        "text": "Label",
        "textStyle": {
            "letterSpacing": 0,
            "strikeThrough": false
        },
        "top": "15dp",
        "width": kony.flex.USE_PREFFERED_SIZE,
        "zIndex": 1
    }, {
        "contentAlignment": constants.CONTENT_ALIGN_MIDDLE_LEFT,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {
        "textCopyable": false
    });
    var btnScanBarCode = new kony.ui.Button({
        "focusSkin": "slButtonGlossRed",
        "height": "50dp",
        "id": "btnScanBarCode",
        "isVisible": true,
        "left": "64dp",
        "onClick": AS_Button_2042221800744d168a619be70211f1de,
        "skin": "slButtonGlossBlue",
        "text": "Scan Barcode",
        "top": "301dp",
        "width": "260dp",
        "zIndex": 1
    }, {
        "contentAlignment": constants.CONTENT_ALIGN_CENTER,
        "displayText": true,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {});
    frmStartup.add(lblScanInfo, btnScanBarCode);
};

function frmStartupGlobals() {
    frmStartup = new kony.ui.Form2({
        "addWidgets": addWidgetsfrmStartup,
        "enabledForIdleTimeout": false,
        "id": "frmStartup",
        "layoutType": kony.flex.FREE_FORM,
        "needAppMenu": false,
        "skin": "slForm"
    }, {
        "displayOrientation": constants.FORM_DISPLAY_ORIENTATION_PORTRAIT,
        "layoutType": kony.flex.FREE_FORM,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {
        "footerOverlap": false,
        "headerOverlap": false,
        "menuPosition": constants.FORM_MENU_POSITION_AFTER_APPMENU,
        "retainScrollPosition": false,
        "titleBar": true,
        "titleBarSkin": "slTitleBar",
        "windowSoftInputMode": constants.FORM_ADJUST_PAN
    });
    frmStartup.info = {
        "kuid": "07d1a647b5804c4190c1ed0a9fc9c0eb"
    };
};