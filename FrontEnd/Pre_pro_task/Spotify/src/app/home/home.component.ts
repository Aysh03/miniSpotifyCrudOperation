import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userSer: UserService, private adminSer: AdminService,private _route:Router) {
    this.getAlltracks()
  }

  ngOnInit(): void {
  }


  

  userDetails: any;
  getUserDetails() {
    this.userSer.getUserDetails().subscribe(
      response => {
        console.log(response);
        this.userDetails = response;
      }
    )
  }

  allTracks: any;

  getAlltracks() {
    this.adminSer.getAlltracks().subscribe(
      response => {
        this.allTracks = response;
      }
    )
  }




  directToLogin(){
  this._route.navigate(["login"]);
  }

}
