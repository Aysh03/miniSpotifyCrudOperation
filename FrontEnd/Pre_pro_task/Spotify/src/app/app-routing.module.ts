import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AuthGuard } from './guards/auth.guard';
import { DeactForAdminGuard } from './guards/deact-for-admin.guard';
import { DeactGuard } from './guards/deactForSignUp.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PlayingComponent } from './playing/playing.component';
import { SignupComponent } from './signup/signup.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';


const routes: Routes = [
  
  
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: SignupComponent,canDeactivate:[DeactGuard]},
  { path: "AdminView", component: AdminDashboardComponent ,canActivate:[ AuthGuard],canDeactivate:[DeactForAdminGuard]},
  { path: "thankyou", component: ThankYouComponent},
  { path: "play", component: PlayingComponent,canActivate:[ AuthGuard] },
  { path: "userView", component: UserDashboardComponent,canActivate:[ AuthGuard] },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: "**", component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


