import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AdminDashboardComponent } from '../admin-dashboard/admin-dashboard.component';

@Injectable({
  providedIn: 'root'
})
export class DeactForAdminGuard implements CanDeactivate<unknown> {
  canDeactivate(
    component: AdminDashboardComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return component.canDeActiveAdmin();
  }
  
}
