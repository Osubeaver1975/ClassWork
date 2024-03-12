/* define the RUL path-component connection for the Application
  this tells angular router which component to switch for URL

*/
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// be sure we have imported all components that we are connecting to a URL path
import { SampleFormComponent } from './sample-form/sample-form.component';
import { StateSealsComponent } from './state-seals/state-seals.component';
import { HomeComponent }       from './home/home.component';
import { ApplicationInitStatus } from '@angular/core'
// the routes attribute defines the URL path component connection
// it is an array of objects with each object specifying a URL path
//      and the component it is connected to 
const routes: Routes = [
  // if there is no URL path use the /home path (redirection)
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  // if the URL path is /home switch to the "home" component
  { path: 'home', component: HomeComponent },
  { path: 'persinfo', component: SampleFormComponent },
    // if the URL path is /persinfo switch to the "persinfo" component
  { path: 'stateseals', component: StateSealsComponent }
    // if the URL path is /stateseals switch to the "stateseals" component
 ];

@NgModule({
  declarations: [],
  // we need to tell the routerModule the name of the array of paths
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}






