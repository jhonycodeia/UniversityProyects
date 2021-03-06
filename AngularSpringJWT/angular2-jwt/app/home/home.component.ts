import { Component, OnInit } from '@angular/core';
import 'rxjs/add/operator/first';
import { User } from '../_models/index';
import { UserService } from '../_services/index';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent { }