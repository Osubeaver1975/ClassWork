import { Component }     from '@angular/core';
import { MoviesInfo }    from '../moviesInfo';      // include the MoviesInfo 'INTERFACE' = moviesInfo.ts
import { FormsModule }   from '@angular/forms';
import { MoviesService } from '../movies.service';
import { CommonModule }  from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-movie',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-movie.component.html',
  styleUrl: './add-movie.component.css'
})
export class AddMovieComponent {

  // Constructor uses dependency injection to define the variable 'movieservice
  //    create an instance of MovieService and assign that instance to the moviesService variable
  // also  Dependency Injects the Router into the router variable (so we can go to different pages)
constructor(private movieService  : MoviesService, 
  private router: Router) {}

// Define a place to 'hold' the new movie when entered by the user
// Data from the web page will be used to fill in the values a new movie (two-way binding)
//  variable : data-type - using the INTERFACE (moviesinfo.ts) 
public newMovie : MoviesInfo =  {
                                  title : "",
                                  releaseYear: new Date().getFullYear(), // initialize to " 'new Date'().getFullYear()" = this year
                                  director: ""
                                };

// This method called when the submit button is clicked in the html form
//  it is 
// function name(parameter: data-type) USING INTERFACE as data-type
        addMovie(newMovie : MoviesInfo) {
  console.table(newMovie);
  this.movieService.addMovies(newMovie)  // call the service to add the newMovie to the data source
  this.router.navigate(['/movies'])  // changes to 'page' "/movies"
}
cancelButtonClicked() {
  this.router.navigate(['/movies'])
}
}


