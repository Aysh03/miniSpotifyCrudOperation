import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private usrSer: UserService, private route: Router) { }

  ngOnInit(): void { }


  loginn = new FormGroup({
    'emailId': new FormControl(),
    'password': new FormControl()
  });



  responseData: any;
  sendLoginData() {
    console.log(this.loginn.value);
    this.usrSer.loginCheck(this.loginn.value).subscribe(
      response => {

        console.log(response);
        this.responseData = response;
        console.log(this.responseData.token);
        console.log(this.responseData.role);
        console.log(this.responseData.message);
        
        localStorage.setItem("jwt", this.responseData.token);
        localStorage.setItem("role", this.responseData.role);
    

        if (this.responseData.role == 'ROLE_ADMIN') {
          this.route.navigateByUrl("/AdminView")
        }
        else {
          this.route.navigateByUrl("/userView")
        }
      });
  }
}
