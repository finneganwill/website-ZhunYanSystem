//iframe高度自适应
function setIframeHeight(elementId) {
    // document.getElementById("external-frame").height=0;//默认为0
    document.getElementById(elementId).height=document.getElementById(elementId).contentWindow.document.body.scrollHeight;
}
