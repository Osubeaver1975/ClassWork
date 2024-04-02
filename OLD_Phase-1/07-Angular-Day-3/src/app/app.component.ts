// import gives us access to external features and components
// most imported names must be included in the imports property of the component
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SampleFormComponent } from './sample-form/sample-form.component';

@Component({
  selector: 'app-root', // this is what is used to includ this 
                        // component on a page
  standalone: true,   // added in angular 17 to allow components to be independent
  imports: [RouterOutlet, SampleFormComponent], //identifies things used
  templateUrl: './app.component.html', // where to find the html file
  styleUrl: './app.component.css'     // where to find the css
})
// this defines a module for this component
// export - says let things outside this component access it
// class- this is a group of things associated with this component
export class AppComponent {
  pageTitle = 'Welcome to FSD - Cohort-1-2024 Angular App';
}
