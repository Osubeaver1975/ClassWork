import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
// FormesModule is required if component uses html forms
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'sample-form', // this is the tag used in any page to include this form we created
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sample-form.component.html',
  styleUrl: './sample-form.component.css'
})
export class SampleFormComponent {
  
    
  
  
          // a method to process any data accessible to the component
          // public says this variable may be accessed by anything using this component
          // public --> access modifier --> is used to define data in a module instead of let/ var
          // private --> access modifier --> is another access modifier that limits access to code in this module
          // public allows angular to access the data
  onSubmit() {
      console.log(`-----------------------------------------------`)
      console.log(` First name: ${this.fname}`)
      console.log(`  Last name: ${this.lname}`)
      console.log(` Birth Date: ${this.birthDate}`)
      console.log(` Cuisine(s): ${this.foodPrefs}`)
      console.log(`      email: ${this.email}`)
      console.log(`allow email: ${this.email_preference}`)
    }


          // data used by the component

          // these variables are connected to input controls in a from via [(NgModule)]
      public fname = "";
      public lname = "";
      public birthDate = "";
      public foodPrefs = "";
      public email = "";
      public email_preference = "";

}
