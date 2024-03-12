// Define the modules and other components this feature uses
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-learnerlist', // tag used in html to reference component
  standalone: true, // added to make data binding [ngModel] and routing easier
  imports: [CommonModule],      // external feature you use in the component
  templateUrl: './learnerlist.component.html',
  styleUrl: './learnerlist.component.css'
})
// "EXPORT" Defines the module for the component and makes it available externally
// Where data and methods for the component are defined
export class LearnerlistComponent {
  // Define the list of learner names we want to display
  // typically the data will come from a service

  //public says the data is accessible by anyone w/ access to the module
  // private - says the data is accesible only by methods in the component
  public learnerNames = ["Bertam", "Elana", "Guillermo", "Jakob", "Kris"]

}
