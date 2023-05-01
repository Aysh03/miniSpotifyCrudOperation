import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  constructor(public auth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  logout() {
    this.auth.loggingOut();
    // localStorage.clear();

    // this.router.navigate(["/thankyou"])
    // setTimeout(() => {
    //   setTimeout(() => {
    //     this.router.navigateByUrl("/home")
    //   });
    // }, 20000); //20seconds used
  }
}
