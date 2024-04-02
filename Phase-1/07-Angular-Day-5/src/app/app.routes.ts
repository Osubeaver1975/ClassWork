import { Routes } from '@angular/router';
import { HomeComponent }        from './home/home.component'              ;
import { SampleFormComponent }  from './sample-form/sample-form.component';
import { StateSealsComponent }  from './state-seals/state-seals.component';
import { LearnerlistComponent } from './learnerlist/learnerlist.component';

export const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full' },
    {path: 'home', component: HomeComponent},
    {path: 'learners', component: LearnerlistComponent},

    {path: 'persinfo', component: SampleFormComponent},
    {path: 'stateseals', component: StateSealsComponent}
];
