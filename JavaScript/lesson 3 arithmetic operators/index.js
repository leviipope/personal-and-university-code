/* arithmetic operators = operands (values, variables, etc. )
                          operators (+ - * /)
                          ex. 11 = x + 5;                       
*/

let students = 30;

/*
students = students + 1;
students = students - 1;
students = students * 2;
students = students / 2;
students = students ** 2; // students^2
let extraStudents = students % 2; // mod 2
*/

/*
students += 1;
students **= 2;
students %= 2;
*/

//students++;
//students--;

console.log(students);

/*
    operator precedence
    1. ()
    2. exponents
    3. * & / & % 
    4. + & -
*/

let result = 1 + 2 * 3 + 4 ** 2;
let result2 = 12 % 5 + 8 / 2;
console.log(`result: ` + result);
console.log(`result2: ` + result2);
