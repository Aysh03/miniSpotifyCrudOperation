import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  constructor(private adminSer: AdminService, private route: Router, private auth: AuthService, private router: Router) {
    this.getAlltracks();
  }

  ngOnInit(): void {
  }


  trackForm = new FormGroup({
    'trackId': new FormControl(),
    'trackName': new FormControl(),
    'artistName': new FormControl(),
    'desc': new FormControl()

  });


  sendTrackData() {
    console.log(this.trackForm.value);
    this.adminSer.addTrack(this.trackForm.value).subscribe(
      response => {
        console.log(response);
        this.getAlltracks();
      }
    )
  }



  allTracks: any
  getAlltracks() {
    this.adminSer.getAlltracks().subscribe(
      response => {
        this.allTracks = response;
      }
    )
  }

  deleteTrack(trackId: string) {
    this.adminSer.deleteTrack(trackId).subscribe(
      response => {
        this.getAlltracks();
      }
    )
  }

  editedtrackForm = new FormGroup({
    'trackId': new FormControl(),
    'trackName': new FormControl(),
    'artistName': new FormControl(),
    'desc': new FormControl()

  });


  getEditedTrack(track: any) {
    console.log(track)
    this.editedtrackForm.setValue(track);
  }

  updateTrack() {
    this.adminSer.updateTrack(this.editedtrackForm.value).subscribe(
      response => {
        this.getAlltracks();
      }
    )
  }





  editStatus: boolean = false;



  canDeActiveAdmin() {
    if (!this.editStatus) {
      let response = confirm("Changes are not saved. Do you still want to Leave?")
      localStorage.clear();
      this.auth.isLoggingIn()==false;
      return response;
      
    }
    else

      return true;
  }



  // auth.isLoggingIn()== false
}
