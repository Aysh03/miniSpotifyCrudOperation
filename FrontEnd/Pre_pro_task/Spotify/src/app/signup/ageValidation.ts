import { AbstractControl } from "@angular/forms";

export function ageValidation(fg:AbstractControl):{[key:string]:boolean}|null{
  if(fg.value<12){
    return{'age':true}
  }
  return null;
}

