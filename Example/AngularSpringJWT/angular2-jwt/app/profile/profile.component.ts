import { Component, OnInit } from "@angular/core";
import "rxjs/add/operator/first";
import { User } from "../_models/index";
import { UserService } from "../_services/index";

@Component({
  moduleId: module.id,
  templateUrl: "profile.component.html"
})
export class ProfileComponent implements OnInit {
  user: Object;

  constructor(private userService: UserService) {}

  ngOnInit() {
    // get users from secure api end point
    this.userService
      .getUser()
      .first()
      .subscribe(users => {
        this.user = users;
      });
  }
}
