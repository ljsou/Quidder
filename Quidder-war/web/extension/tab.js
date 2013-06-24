/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

console.log("entró");

chrome.tabs.query({'active': true}, function(tabs) {
    var url = tabs[0].url;
    console.log("url: " + url);
    document.getElementById('currentLink').innerHTML = url;
});
