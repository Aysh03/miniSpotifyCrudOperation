import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private router: Router) {}

  // isLoggedIn:boolean=false;

  isLoggingIn() 
  {
    return !!localStorage.getItem('jwt');
  }

  loggingOut() {
    localStorage.clear();

    this.router.navigate(['/thankyou']);
    setTimeout(() => {
      setTimeout(() => {
        this.router.navigateByUrl('/home');
      });
    }, 12000); //12seconds used
  }
}
