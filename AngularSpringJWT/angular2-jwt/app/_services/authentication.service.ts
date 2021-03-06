import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import "rxjs/add/operator/map";

@Injectable()
export class AuthenticationService {
  api = "http://localhost:8090";

  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http
      .post(this.api + "/auth", { username: username, password: password })
      .map(user => {
        // login successful if there's a jwt token in the response
        console.log(JSON.stringify(user));
        if (user && user) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem("currentUser", JSON.stringify(user));
        }
        return user;
      });
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem("currentUser");
  }
}
