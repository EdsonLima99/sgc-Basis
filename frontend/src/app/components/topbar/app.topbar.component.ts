import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Authentication, User } from '@nuvem/angular-base';

@Component({
    selector: 'app-topbar',
    templateUrl: './app.topbar.component.html',
    // styles: ['h1 { font-size: 30px; display: inline; color: white ; text-align: center; position: relative}']
})
export class AppTopbarComponent {

    constructor(public app: AppComponent, private readonly _authentication: Authentication<User>) {
    }

    get usuario() {
        return this._authentication.getUser();
    }

    isAuthenticated() {
        return this._authentication.isAuthenticated();
    }
}
