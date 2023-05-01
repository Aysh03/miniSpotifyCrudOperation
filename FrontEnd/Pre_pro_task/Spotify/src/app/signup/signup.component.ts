import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../services/user.service';
import { ageValidation } from './ageValidation';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  canDeactivate: any;

  constructor(
    private fb: FormBuilder,
    private _snackBar: MatSnackBar,
    private userService: UserService
  ) {}

  ngOnInit(): void {}
  registrationForm = this.fb.group(
    {
      name: ['', Validators.required],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(
            /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/
          ),
        ],
      ],
      confirmPassword: [
        '',
        [
          Validators.required,
          Validators.pattern(
            /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/
          ),
        ],
      ],
      emailId: ['', [Validators.required, Validators.email]],
      age: ['', [Validators.required, ageValidation]],
      mobileNo: [
        '',
        [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],
      ],
      address: [''],
    },
    { validators: [this.mustMatchValidator] }
  );

  get firstName() {
    return this.registrationForm.get('firstName');
  }

  get lastName() {
    return this.registrationForm.get('lastName');
  }

  get email() {
    return this.registrationForm.get('email');
  }

  get mobileNo() {
    return this.registrationForm.get('phone');
  }

  get password() {
    return this.registrationForm.get('password');
  }

  get age() {
    return this.registrationForm.get('age');
  }

  get confirmPassword() {
    return this.registrationForm.get('confirmPassword');
  }

  get address() {
    return this.registrationForm.get('address');
  }

  mustMatchValidator(fg: AbstractControl) {
    const passwordValue = fg.get('password')?.value;
    const confirmPasswordValue = fg.get('confirmPassword')?.value;
    if (!passwordValue || !confirmPasswordValue) {
      return null;
    }
    if (passwordValue != confirmPasswordValue) {
      return { mustMatch: false };
    }
    return null;
  }

  onSubmit() {
    console.log(this.registrationForm.value);
    this.userService
      .registerUser(this.registrationForm.value)
      .subscribe((response: any) => {
        console.log(response);
        this._snackBar.open(
          'Congrats!!You have submiited the form!!',
          'success',
          {
            duration: 5000,
            panelClass: ['mat-toolbar', 'mat-primary'],
          }
        );
        this.registrationForm.reset();
      });
  }

  editStatus: boolean = false;

  canDeActive() {
    if (!this.editStatus) {
      let response = confirm(
        'Changes are not saved. Do you still want to Leave?'
      );
      return response;
    } else return true;
  }
}
