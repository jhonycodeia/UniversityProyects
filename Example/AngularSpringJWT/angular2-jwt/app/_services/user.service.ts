import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {

    api = 'http://localhost:8090';

    constructor(private http: HttpClient) { }

    getUser() {
        return this.http.get(this.api + '/user');
    }
}