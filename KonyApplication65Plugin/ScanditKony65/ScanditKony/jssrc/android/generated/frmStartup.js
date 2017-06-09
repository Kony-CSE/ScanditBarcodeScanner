//Form JS File
function frmStartup_button1234623160182_onClick_seq0(eventobject) {
    onBtnScanBarCode.call(this);
};

function addWidgetsfrmStartup() {
    var button1234623160182 = new kony.ui.Button({
        "id": "button1234623160182",
        "top": "80dp",
        "left": "95dp",
        "width": "260dp",
        "height": "50dp",
        "zIndex": 1,
        "isVisible": true,
        "text": "Scan Barcode",
        "skin": "btnNormal",
        "focusSkin": "btnFocus",
        "onClick": frmStartup_button1234623160182_onClick_seq0
    }, {
        "padding": [0, 0, 0, 0],
        "contentAlignment": constants.CONTENT_ALIGN_CENTER,
        "displayText": true,
        "marginInPixel": false,
        "paddingInPixel": false,
        "containerWeight": 11
    }, {});
    var lblScanInfo = new kony.ui.Label({
        "id": "lblScanInfo",
        "top": "159dp",
        "left": "79dp",
        "width": "100dp",
        "height": "26dp",
        "zIndex": 1,
        "isVisible": true,
        "text": "Label",
        "skin": "lblNormal"
    }, {
        "padding": [0, 0, 0, 0],
        "contentAlignment": constants.CONTENT_ALIGN_MIDDLE_LEFT,
        "marginInPixel": false,
        "paddingInPixel": false,
        "containerWeight": 6
    }, {
        "textCopyable": false
    });
    frmStartup.add(button1234623160182, lblScanInfo);
    frmStartup.setDefaultUnit(kony.flex.DP);
};

function frmStartupGlobals() {
    var MenuId = [];
    frmStartup = new kony.ui.Form2({
        "id": "frmStartup",
        "enableScrolling": true,
        "bounces": true,
        "allowHorizontalBounce": true,
        "allowVerticalBounce": true,
        "pagingEnabled": false,
        "needAppMenu": true,
        "title": null,
        "enabledForIdleTimeout": false,
        "skin": "frm",
        "layoutType": kony.flex.FREE_FORM,
        "addWidgets": addWidgetsfrmStartup
    }, {
        "padding": [0, 0, 0, 0],
        "displayOrientation": constants.FORM_DISPLAY_ORIENTATION_PORTRAIT,
        "paddingInPixel": false
    }, {
        "retainScrollPosition": false,
        "windowSoftInputMode": constants.FORM_ADJUST_RESIZE,
        "titleBar": true,
        "footerOverlap": false,
        "headerOverlap": false,
        "inTransitionConfig": {
            "formAnimation": 0
        },
        "outTransitionConfig": {
            "formAnimation": 0
        },
        "menuPosition": constants.FORM_MENU_POSITION_AFTER_APPMENU
    });
};