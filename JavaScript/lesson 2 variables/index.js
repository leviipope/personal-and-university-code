// 1. declaration     let x;
// 2. assignment      x = 100;

let x;
x = 100;
// let x = 123;

/*
    NUMBERS
let age = 25;
let price = 10.99;
let gpa = 2.1;

console.log(typeof age);
console.log(`You are ${age} years old`);
console.log(`The price is $${price}`);
console.log(`Your GPA is ${gpa}`);
*/

/*
    STRINGS
let firstName = "Levi";
let favoriteFood = "pizza";
let email = "leventep71@gmail.com"

console.log(typeof firstName);
console.log(firstName);
console.log(`Your name is ${firstName}`);
console.log(`You like ${favoriteFood}`);
console.log(`Your email is ${email}`);
*/

/*
    BOOLEAN
let online = true;
let forSale = false;
let isStudent = true;

console.log(typeof online);
console.log(`Levi is online: ${online}`);
console.log(`Is this car for sale: ${forSale}`);
console.log(`Enrolled: ${isStudent}`); 
*/

let fullName = "Levente Polgari";
let age = 19;
let isStudent = true;

document.getElementById("p1").textContent = `Your name is ${fullName}`;
document.getElementById("p2").textContent = `You are ${age} years old.`;
document.getElementById("p3").textContent = `Enrolled: ${isStudent}`;