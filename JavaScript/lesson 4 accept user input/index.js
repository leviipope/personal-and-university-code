// How to accept user input

// 1. EASY WAY = window prompt
// 2. PROFESSIONAL WAY = HTML textbox


/* EASY WAY - just these two lines of code
let username = window.prompt("whats your username?");

console.log(username);
*/

// PRO WAY, this contains html and css too

let username;
document.getElementById("mySubmit").onclick = function(){
    username = document.getElementById("text").value;
    document.getElementById("myH1").textContent = `Hello ${username}`;
}