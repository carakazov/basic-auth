import jwt_decode from 'jwt-decode'

const BASE_URL = 'http://localhost:8080/auth'

class AuthApi {
    constructor(baseUrl) {
        this.baseUrl = baseUrl;
    }

    async requestToken(tokenRequest) {
        let requestResponse = await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.parse(tokenRequest)
        });
    }
}