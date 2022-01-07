import { get, post } from './ajax.js';


[...document.querySelectorAll('button[name]')].forEach(b => b.addEventListener("click", onClick));

function onClick(e) {
    console.log(e.target.name);
    listeners[e.target.name]();
}

function print(data) {
    output.innerHTML = JSON.stringify(data);
}

let c = 1;

function generateItem() {
    return { description: 'Number ' + c++ };
}

const listeners = {
    getAll() {
        get("http://localhost:8080/items").then(print);
    },
    post100() {
        const promises=Array.from({length: 20},v=> post("http://localhost:8080/items", generateItem()));
        Promise.all(promises).then(print);
    }
};

listeners.getAll();