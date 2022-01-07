function json(response) {
    return response.json();
}

export function post(url, data) {
    return fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        },
        body: JSON.stringify(data)
    }).then(json);
}

export function get(url) {
    return fetch(url).then(json);
}